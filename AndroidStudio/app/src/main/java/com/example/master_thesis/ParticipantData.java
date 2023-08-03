package com.example.master_thesis;

import java.util.ArrayList;

public class ParticipantData {

    ArrayList<ParticipantEntity> data;

    public ParticipantData(int numberParticipants) {

        data = new ArrayList<ParticipantEntity>();

        for (int i = 0; i < numberParticipants; i++) {
            ParticipantEntity Participant = new ParticipantEntity(i);

            data.add(Participant);
        }
    };

    public ArrayList<ParticipantEntity> getData() {
        return data;
    };

}
