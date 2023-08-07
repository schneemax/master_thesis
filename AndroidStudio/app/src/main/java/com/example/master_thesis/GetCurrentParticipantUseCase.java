package com.example.master_thesis;

public class GetCurrentParticipantUseCase {

    private static GetCurrentParticipantUseCase sInstance;

    private int currentParticipant;

    private ExperimentRepository experimentRepository;

    private GetCurrentParticipantUseCase() {
        //Constructor
        this.currentParticipant = experimentRepository.getInstance().getExperiment().getCurrentParticipant();
    }

    ;

    /**
     * Singleton principle
     */
    public static GetCurrentParticipantUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetCurrentParticipantUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetCurrentParticipantUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public int getCurrentParticipant() {
        return currentParticipant;
    }

}
