package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoScreenActivity extends AppCompatActivity {

    private static TextView txtCounter;
    private static Handler handler;
    private static Runnable runnable ;
    private static int count;

     if (handler == null) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                txtCounter.setText("Count = " + count);
                count++;
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        Button btn = (Button) findViewById(R.id.btnContinueInfoScreen);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nextStep = GetNextExperimentStepUseCase.getInstance().getNextExperimentStep();
                try {
                    Class<?> c = Class.forName(nextStep);
                    Intent intent = new Intent(InfoScreenActivity.this, c);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        });

        //Set InfoText
        TextView textView = (TextView) findViewById(R.id.textViewInfoScreen);
        textView.setText(GetInfoScreenDataUseCase.getInstance().getInfoScreenData());

    }
}