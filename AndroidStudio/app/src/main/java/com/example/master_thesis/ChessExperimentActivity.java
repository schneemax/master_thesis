package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.opencsv.CSVWriter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class ChessExperimentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_experiment);

        Button btn = (Button) findViewById(R.id.chessBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nextStep = GetNextExperimentStepUseCase.getInstance().getNextExperimentStep();
                try {
                    Class<?> c = Class.forName(nextStep);
                    Intent intent = new Intent(ChessExperimentActivity.this, c);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        });

        /*
        // MockUp for data Output
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
*/
/*
        try {
            // Establish connection
            Socket socket = new Socket("127.0.0.1.", 52665);

            // Request data
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello World!");

            // Read data
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String message = inputStream.readUTF();

            // Shut down socket
            socket.shutdownInput();
            socket.shutdownOutput();
            socket.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
*/


    }
}