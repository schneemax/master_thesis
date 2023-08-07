package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseTestSubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test_subject);

        Button btn = (Button) findViewById(R.id.btnContinueChooseTestParticipant);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nextStep = GetNextExperimentStepUseCase.getInstance().getNextExperimentStep();
                try {
                    Class<?> c = Class.forName(nextStep);
                    Intent intent = new Intent(ChooseTestSubjectActivity.this, c);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        });
    }
}