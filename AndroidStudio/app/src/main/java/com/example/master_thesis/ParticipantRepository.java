package com.example.master_thesis;

public class ParticipantRepository {

    private static ParticipantRepository sInstance;

    private ParticipantRepository() {
        //Constructor
    }

    ;

    /**
     * Singleton principle
     */
    public static ParticipantRepository getInstance() {
        if (sInstance == null) {
            synchronized (ParticipantRepository.class) {
                if (sInstance == null) {
                    sInstance = new ParticipantRepository();
                }
            }
        }
        return sInstance;
    }

    /**
     * Get the information about participants.
     */

    /*public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }*/


}
