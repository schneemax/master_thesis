package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
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

    public class Server {
        public void main(String[] args) {
            try {
                ServerSocket serverSocket = new ServerSocket(12345); // Choose a suitable port
                System.out.println("Server listening on port 12345...");

                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with client: " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message = in.readLine();
                System.out.println("Received message: " + message);

                in.close();
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Client {
        public void main(String[] args) {
            try {
                Socket socket = new Socket("SERVER_IP_ADDRESS", 12345); // Replace with the actual server's IP address

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello from client!");
                out.close();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}