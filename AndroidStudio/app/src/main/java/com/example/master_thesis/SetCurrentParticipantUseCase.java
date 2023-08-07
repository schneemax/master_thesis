package com.example.master_thesis;

public class SetCurrentParticipantUseCase {


    private static SetCurrentParticipantUseCase sInstance;

    private int currentParticipant;

    private ExperimentRepository experimentRepository;

    private SetCurrentParticipantUseCase() {
        //Constructor

        experimentRepository = experimentRepository.getInstance();

    }

    ;

    /**
     * Singleton principle
     */
    public static SetCurrentParticipantUseCase getInstance() {
        if (sInstance == null) {
            synchronized (SetCurrentParticipantUseCase.class) {
                if (sInstance == null) {
                    sInstance = new SetCurrentParticipantUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public void setCurrentParticipant(int participantId) {

        experimentRepository.getExperiment().setCurrentParticipant(participantId);

    }

}
