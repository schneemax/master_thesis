package com.example.master_thesis;

import java.util.ArrayList;

public class ParticipantRepository {

    private static ParticipantRepository sInstance;
    private ArrayList<ParticipantEntity> data;

    private ParticipantRepository() {
        //Constructor
        this.data = new ParticipantData(5).getData();
    }

    ;

    /**
     * Singleton principle
     */
    public static ParticipantRepository getInstance() {
        if (sInstance == null) {
            synchronized (ParticipantRepository.class) {
                if (sInstance == null) {
                    sInstance = new ParticipantRepository();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public ArrayList<ParticipantEntity> getParticipants() {
        return data;
    }


}
