package com.example.master_thesis;

import android.os.Environment;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void setMetaData(Object metaData) {
        experimentRepository.getExperiment().setMetaData(metaData);
    }

    public Object getMetaData() {
        return experimentRepository.getExperiment().getMetaData();
    }

    public void printOutMetaData(){
        File file = new File(Environment.getExternalStorageDirectory() + "/participant" + GetCurrentParticipantUseCase.getInstance().getCurrentParticipant() + "TimeData.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "id", "time in milliseconds"};
            writer.writeNext(header);

            //Getting participant information
            ArrayList<ParticipantEntity> participantEntities = GetParticipantDataUseCase.getInstance().getParticipantData();

            //Writing current participant time into file
            //String[] data = {String.valueOf(GetCurrentParticipantUseCase.getInstance().getCurrentParticipant()), String.valueOf(timeDifference)};


            Iterator iter = participantEntities.iterator();
            while (iter.hasNext()) {
                String[] data = {String.valueOf(((ParticipantEntity)iter.next()).getId()), String.valueOf(((ParticipantEntity)iter.next()).getExperimentTime())};
                writer.writeNext(data);
            }
            //closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error");
        }
    };

}
