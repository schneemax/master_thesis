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

    public ParticipantEntity getParticipant(int id){
        for(ParticipantEntity participant : data) {
            if(participant.getId() == id) {
                return participant;
            }
        }
        return null;
    };

    public void updateParticipant(ParticipantEntity i_part) {
        for (int i = 0; i < data.size(); i++) {
            if (i_part.getId() == data.get(i).getId()) {
                data.set(i, i_part);
            }
            ;
        }
        ;
    };

    public void createNewParticipant(int id) {
        data.add(new ParticipantEntity(id));
    };

}
