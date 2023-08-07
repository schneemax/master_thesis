package com.example.master_thesis;

import java.util.ArrayList;

public class GetParticipantDataUseCase {

    private static GetParticipantDataUseCase sInstance;

    private ParticipantRepository participantRepository;

    ArrayList<ParticipantEntity> participantData;

    private GetParticipantDataUseCase() {
        //Constructor
        this.participantData = participantRepository.getParticipants();
    }

    ;

    /**
     * Singleton principle
     */
    public static GetParticipantDataUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetParticipantDataUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetParticipantDataUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public ArrayList<ParticipantEntity> getParticipantData() {
        return participantData;
    }


}
