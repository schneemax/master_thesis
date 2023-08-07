package com.example.master_thesis;

public class GetGroupAllocationPUseCase {

    private static GetGroupAllocationPUseCase sInstance;

    private String groupAllocation;

    private ParticipantRepository participantRepository;

    private GetCurrentParticipantUseCase getCurrentParticipantUseCase;

    private GetGroupAllocationPUseCase() {
        //Constructor
        this.groupAllocation = participantRepository.getInstance().getParticipant(getCurrentParticipantUseCase.getInstance().getCurrentParticipant()).getGroupAllocation();
    }

    ;

    /**
     * Singleton principle
     */
    public static GetGroupAllocationPUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetGroupAllocationPUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetGroupAllocationPUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public String getGroupAllocation() {
        return groupAllocation;
    }

}