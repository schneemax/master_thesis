package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseTestSubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test_subject);

        Button btn = (Button) findViewById(R.id.btnContinueChooseTestParticipant);

        //System.out.println(GetCurrentParticipantUseCase.getInstance().getCurrentParticipant());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nextStep = GetNextExperimentStepUseCase.getInstance().getNextExperimentStep();

                String participantID = ((EditText) findViewById(R.id.editTextChooseParticipant)).getText().toString();
                //SetCurrentParticipantUseCase.getInstance().setCurrentParticipant(Integer.parseInt(participantID));
                //int participantID = Integer.parseInt(String.valueOf((EditText) findViewById(R.id.editTextChooseParticipant)));
                //SetCurrentParticipantUseCase.getInstance().setCurrentParticipant(participantID);

                if (!participantID.isEmpty()) {
                    try {
                        int integerValue = Integer.parseInt(participantID);
                        SetCurrentParticipantUseCase.getInstance().setCurrentParticipant(integerValue);
                    } catch (NumberFormatException e) {
                        // Handle the case where the entered text is not a valid integer
                    }
                };


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