package com.example.master_thesis;

import java.util.Random;

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

            if(experimentRepository.getExperiment().getGroupAllocation() == "random"){
                Random random = new Random();
                int randomNumber = random.nextInt(2); // Generates either 0 or 1

                if(randomNumber == 0 ){
                    setGroupAllocationPUseCase.setGroupAllocation("Group A", currentParticipant);
                } else {
                    setGroupAllocationPUseCase.setGroupAllocation("Group B", currentParticipant);
                }

            };

        } else {
            //Do nothing
        };
    }

}
