package com.example.master_thesis;

public class InsertDataPUseCase {

    private static InsertDataPUseCase sInstance;

    private ParticipantRepository participantRepository;

    ParticipantEntity participant;

    private InsertDataPUseCase() {
        //Constructor
        //this.participant = participantRepository.getParticipant(experimentRepository.getInstance().getExperiment().getCurrentParticipant());
    }

    ;

    /**
     * Singleton principle
     */
    public static InsertDataPUseCase getInstance() {
        if (sInstance == null) {
            synchronized (InsertDataPUseCase.class) {
                if (sInstance == null) {
                    sInstance = new InsertDataPUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public void setData(int part_id, String name, String gender, String education) {

        ParticipantEntity participant = participantRepository.getInstance().getParticipant(part_id);

        participant.setName(name);
        participant.setGender(gender);
        participant.setEducation(education);

        participantRepository.getInstance().updateParticipant(participant);


    }

}
