package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startActivity(new Intent(MainActivity.this, InfoScreenActivity.class));

        String nextStep = GetNextExperimentStepUseCase.getInstance().getNextExperimentStep();
        try {
            Class<?> c = Class.forName(nextStep);
            Intent intent = new Intent(MainActivity.this, c);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}