package com.example.master_thesis;

import java.util.ArrayList;

public class GetNextExperimentStepUseCase {

    private static GetNextExperimentStepUseCase sInstance;

    private String nextExperimentStep;

    private ArrayList<String> steps;

    private int currentStep;

    private ExperimentRepository experimentRepository;

    private GetNextExperimentStepUseCase() {
        //Constructor
        steps = experimentRepository.getInstance().getExperiment().getSteps();
        currentStep = 0;
        this.nextExperimentStep = steps.get(currentStep);
    }

    ;

    /**
     * Singleton principle
     */
    public static GetNextExperimentStepUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetNextExperimentStepUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetNextExperimentStepUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public String getNextExperimentStep() {
        System.out.println(currentStep);
        if( steps.size() > (currentStep) ){

            currentStep++;
            //System.out.println(steps.get(currentStep-1));
            return steps.get(currentStep-1);
        }
        currentStep = 1;
        //System.out.println(steps.get(currentStep));
        return steps.get(currentStep-1);
    }

}
