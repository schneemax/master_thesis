package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                String startTime = (String) LogMetaDataUseCase.getInstance().getMetaData();

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = format.parse(currentTime);
                    date2 = format.parse(startTime);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                long difference = date1.getTime() - date2.getTime();
                LogMetaDataUseCase.getInstance().setMetaData(difference);
                System.out.println(difference);
            }
        });



        TextView question1Txt = (TextView) findViewById(R.id.textViewQuestion1Questionnair);
        EditText question1EditTxt = (EditText) findViewById(R.id.editTextQuestion1Questionnair);

        if (getNextDataEntryUseCase.getNameTxt() == null){
            question1Txt.setVisibility(View.INVISIBLE);
            question1EditTxt.setVisibility(View.INVISIBLE);
        } else {
            question1Txt.setText("Please enter your " + getNextDataEntryUseCase.getNameTxt());
        }

        TextView question2Txt = (TextView) findViewById(R.id.textViewQuestion2Questionnair);
        EditText question2EditTxt = (EditText) findViewById(R.id.editTextQuestion2Questionnair);

        if (getNextDataEntryUseCase.getGenderTxt() == null){
            question2Txt.setVisibility(View.INVISIBLE);
            question2EditTxt.setVisibility(View.INVISIBLE);
        } else {
            question2Txt.setText("Please enter your " + getNextDataEntryUseCase.getGenderTxt());
        }

        TextView question3Txt = (TextView) findViewById(R.id.textViewQuestion3Questionnair);
        EditText question3EditTxt = (EditText) findViewById(R.id.editTextQuestion3Questionnair);

        if (getNextDataEntryUseCase.getEducationTxt() == null){
            question3Txt.setVisibility(View.INVISIBLE);
            question3EditTxt.setVisibility(View.INVISIBLE);
        } else {
            question3Txt.setText("Please enter your " + getNextDataEntryUseCase.getEducationTxt());
        }

    }
}