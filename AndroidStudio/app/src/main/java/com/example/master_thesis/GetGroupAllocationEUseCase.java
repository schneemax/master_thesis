package com.example.master_thesis;

public class GetGroupAllocationEUseCase {

    private static GetGroupAllocationEUseCase sInstance;

    private String groupAllocation;

    private ExperimentRepository experimentRepository;

    private GetGroupAllocationEUseCase() {
        //Constructor
        this.groupAllocation = experimentRepository.getInstance().getExperiment().getGroupAllocation();
    }

    ;

    /**
     * Singleton principle
     */
    public static GetGroupAllocationEUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetGroupAllocationEUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetGroupAllocationEUseCase();
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
