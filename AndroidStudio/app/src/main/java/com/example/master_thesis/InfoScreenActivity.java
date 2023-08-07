package com.example.master_thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        Button btn = (Button) findViewById(R.id.btnContinueInfoScreen);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InfoScreenActivity.this, ChooseTestSubjectActivity.class));
            }
        });

        TextView textView = (TextView) findViewById(R.id.textViewInfoScreen);

        textView.setText("Max");

    }
}