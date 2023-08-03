package com.example.master_thesis;

import java.util.ArrayList;

public class ExperimentRepository {

    private static ExperimentRepository sInstance;
    private ExperimentEntity experiment;

    private ExperimentRepository() {
        //Constructor
        this.experiment = new ExperimentData().getExperiment();
    }

    ;

    /**
     * Singleton principle
     */
    public static ExperimentRepository getInstance() {
        if (sInstance == null) {
            synchronized (ExperimentRepository.class) {
                if (sInstance == null) {
                    sInstance = new ExperimentRepository();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public ExperimentEntity getExperiment() {
        return experiment;
    }

}
