package com.example.master_thesis;

import java.util.ArrayList;

public class CreateNewParticipantUseCase {

    private static CreateNewParticipantUseCase sInstance;

    private ParticipantRepository participantRepository;

    ArrayList<ParticipantEntity> participants;

    private CreateNewParticipantUseCase() {
        //Constructor
        //this.participants = participantRepository.getParticipants();

    }

    ;

    /**
     * Singleton principle
     */
    public static CreateNewParticipantUseCase getInstance() {
        if (sInstance == null) {
            synchronized (CreateNewParticipantUseCase.class) {
                if (sInstance == null) {
                    sInstance = new CreateNewParticipantUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public void createNewParticipant(int part_id) {

        if(participantRepository.getInstance().getParticipant(part_id) == null){
            participantRepository.getInstance().createNewParticipant(participantRepository.getInstance().getParticipants().size()+1);
        } else {
            participantRepository.getInstance().createNewParticipant(part_id);
        };


    }


}
