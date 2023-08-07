package com.example.master_thesis;

public class LogMetaDataUseCase {

    private static LogMetaDataUseCase sInstance;

    private ExperimentRepository experimentRepository;

    private LogMetaDataUseCase() {
        //Constructor
        this.experimentRepository = experimentRepository.getInstance();
    }

    ;

    /**
     * Singleton principle
     */
    public static LogMetaDataUseCase getInstance() {
        if (sInstance == null) {
            synchronized (LogMetaDataUseCase.class) {
                if (sInstance == null) {
                    sInstance = new LogMetaDataUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public void setMetaData(float metaData) {
        experimentRepository.getExperiment().setMetaData(metaData);
    }

}
