package com.example.master_thesis;

public class SetGroupAllocationPUseCase {


    private static SetGroupAllocationPUseCase sInstance;

    private ParticipantRepository participantRepository;

    ParticipantEntity participant;

    private SetGroupAllocationPUseCase() {
        //Constructor
        //this.participant = participantRepository.getParticipant(experimentRepository.getInstance().getExperiment().getCurrentParticipant());
    }

    ;

    /**
     * Singleton principle
     */
    public static SetGroupAllocationPUseCase getInstance() {
        if (sInstance == null) {
            synchronized (SetGroupAllocationPUseCase.class) {
                if (sInstance == null) {
                    sInstance = new SetGroupAllocationPUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public void setGroupAllocation(String groupAllocation, int part_id) {

        ParticipantEntity participant = participantRepository.getInstance().getParticipant(part_id);

        participant.setGroupAllocation(groupAllocation);

        participantRepository.getInstance().updateParticipant(participant);


    }

}
