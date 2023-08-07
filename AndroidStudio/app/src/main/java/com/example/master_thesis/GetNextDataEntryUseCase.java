package com.example.master_thesis;

import java.util.ArrayList;

public class GetNextDataEntryUseCase {

    private static GetNextDataEntryUseCase sInstance;

    private ParticipantRepository participantRepository;

    private ExperimentRepository experimentRepository;

    ParticipantEntity participant;

    private GetNextDataEntryUseCase() {
        //Constructor

        experimentRepository = experimentRepository.getInstance();
        participantRepository = participantRepository.getInstance();
        this.participant = participantRepository.getParticipant(experimentRepository.getExperiment().getCurrentParticipant());
        //this.participant = participantRepository.getParticipant(1);
    }

    ;

    /**
     * Singleton principle
     */
    public static GetNextDataEntryUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetNextDataEntryUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetNextDataEntryUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public String getName() {
        if (participant.getName() != null){
            return participant.getName();
        }
        return null;
    }

    public String getNameTxt() {
        return participant.getNameTxt();
    }

    public String getGender() {
        if (participant.getGender() != null){
            return participant.getGender();
        }
        return null;
    }

    public String getGenderTxt() {
        return participant.getGenderTxt();
    }

    public String GetEducation() {
        if (participant.getEducation() != null){
            return participant.getEducation();
        }
        return null;
    }

    public String getEducationTxt() {
        return participant.getEducationTxt();
    }

}
