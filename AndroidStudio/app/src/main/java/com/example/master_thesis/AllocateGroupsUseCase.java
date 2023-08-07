package com.example.master_thesis;

public class AllocateGroupsUseCase {

    private static AllocateGroupsUseCase sInstance;

    private String groupAllocation;

    private ParticipantRepository participantRepository;

    private GetCurrentParticipantUseCase getCurrentParticipantUseCase;

    private SetGroupAllocationPUseCase setGroupAllocationPUseCase;

    private ExperimentRepository experimentRepository;

    private int currentParticipant;
    private String currentParticipantGroup;

    private AllocateGroupsUseCase() {
        //Constructor

        getCurrentParticipantUseCase = GetCurrentParticipantUseCase.getInstance();
        participantRepository = participantRepository.getInstance();
        experimentRepository = experimentRepository.getInstance();
        setGroupAllocationPUseCase = setGroupAllocationPUseCase.getInstance();

    }

    ;

    /**
     * Singleton principle
     */
    public static AllocateGroupsUseCase getInstance() {
        if (sInstance == null) {
            synchronized (AllocateGroupsUseCase.class) {
                if (sInstance == null) {
                    sInstance = new AllocateGroupsUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public void allocateGroups() {
        currentParticipant = getCurrentParticipantUseCase.getCurrentParticipant();
        currentParticipantGroup = participantRepository.getParticipant(currentParticipant).getGroupAllocation();

        if(currentParticipantGroup == null){

            setGroupAllocationPUseCase.setGroupAllocation(experimentRepository.getExperiment().getGroupAllocation(), currentParticipant);

        } else {
            //Do nothing
        };
    }

}
