package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionnaireActivity extends AppCompatActivity {

    GetNextDataEntryUseCase getNextDataEntryUseCase;
    InsertDataPUseCase insertDataPUseCase;

    ExperimentRepository experimentRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        getNextDataEntryUseCase = GetNextDataEntryUseCase.getInstance();

        Button btn = (Button) findViewById(R.id.btnContinueQuestionnair);

        insertDataPUseCase = insertDataPUseCase.getInstance();
        experimentRepository = experimentRepository.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText question1EditTxt = (EditText) findViewById(R.id.editTextQuestion1Questionnair);
                EditText question2EditTxt = (EditText) findViewById(R.id.editTextQuestion2Questionnair);
                EditText question3EditTxt = (EditText) findViewById(R.id.editTextQuestion3Questionnair);

                insertDataPUseCase.setData(experimentRepository.getExperiment().getCurrentParticipant(), question1EditTxt.getText().toString(), question2EditTxt.getText().toString(), question3EditTxt.getText().toString());

                String nextStep = GetNextExperimentStepUseCase.getInstance().getNextExperimentStep();
                try {
                    Class<?> c = Class.forName(nextStep);
                    Intent intent = new Intent(QuestionnaireActivity.this, c);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        });



        TextView question1Txt = (TextView) findViewById(R.id.textViewQuestion1Questionnair);
        question1Txt.setText("Please enter your " + getNextDataEntryUseCase.getNameTxt());

        TextView question2Txt = (TextView) findViewById(R.id.textViewQuestion2Questionnair);
        question2Txt.setText("Please enter your " + getNextDataEntryUseCase.getGenderTxt());

        TextView question3Txt = (TextView) findViewById(R.id.textViewQuestion3Questionnair);
        question3Txt.setText("Please enter your " + getNextDataEntryUseCase.getEducationTxt());


    }
}