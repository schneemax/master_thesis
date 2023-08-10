package com.example.master_thesis;

import android.os.Environment;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantData {

    private static final String COMMA_DELIMITER = ",";
    ArrayList<ParticipantEntity> data;

    public ParticipantData(int numberParticipants) {

        data = new ArrayList<ParticipantEntity>();

        for (int i = 0; i < numberParticipants; i++) {
            ParticipantEntity participant = new ParticipantEntity(i);

            data.add(participant);
        }

        /*
        //System.out.println("Working Directory = " + Environment.getExternalStorageDirectory());

        // first create file object for file placed at location
        // specified by filepath
        File file = new File(Environment.getExternalStorageDirectory() + "/participantData.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "Name", "Class", "Marks" };
            writer.writeNext(header);

            // add data to csv
            String[] data1 = { "Aman", "10", "620" };
            writer.writeNext(data1);
            String[] data2 = { "Suraj", "10", "630" };
            writer.writeNext(data2);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error");
        }
        */

        try {
            File csvfile = new File(Environment.getExternalStorageDirectory() + "/participantData.csv");
            CSVReader reader = new CSVReader(new FileReader(csvfile.getAbsolutePath()));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                ParticipantEntity participant = new ParticipantEntity(Integer.parseInt(nextLine[0]));
                participant.setName(nextLine[0]);
                participant.setEducation(nextLine[0]);
                participant.setGender(null);

                data.add(participant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    };

    public ArrayList<ParticipantEntity> getData() {
        return data;
    };

}
