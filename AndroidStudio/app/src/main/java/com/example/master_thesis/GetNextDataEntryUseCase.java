package com.example.master_thesis;

import java.util.ArrayList;

public class GetNextDataEntryUseCase {

    private static GetNextDataEntryUseCase sInstance;

    private ParticipantRepository participantRepository;

    private ExperimentRepository experimentRepository;

    ParticipantEntity participant;

    private GetNextDataEntryUseCase() {
        //Constructor
        this.participant = participantRepository.getParticipant(experimentRepository.getInstance().getExperiment().getCurrentParticipant());
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

    public String getGender() {
        if (participant.getGender() != null){
            return participant.getGender();
        }
        return null;
    }

    public String GetEducation() {
        if (participant.getEducation() != null){
            return participant.getEducation();
        }
        return null;
    }

}
