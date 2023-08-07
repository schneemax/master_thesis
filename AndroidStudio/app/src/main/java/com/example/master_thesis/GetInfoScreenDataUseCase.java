package com.example.master_thesis;

public class GetInfoScreenDataUseCase {

    private static GetInfoScreenDataUseCase sInstance;

    private String infoScreenDate;

    private ExperimentRepository experimentRepository;

    private GetInfoScreenDataUseCase() {
        //Constructor
        this.infoScreenDate = experimentRepository.getInstance().getExperiment().getInfoScreen();
    }

    ;

    /**
     * Singleton principle
     */
    public static GetInfoScreenDataUseCase getInstance() {
        if (sInstance == null) {
            synchronized (GetInfoScreenDataUseCase.class) {
                if (sInstance == null) {
                    sInstance = new GetInfoScreenDataUseCase();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    public String getInfoScreenData() {
        return infoScreenDate;
    }

}
