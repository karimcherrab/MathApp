package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResulteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulte);
        findViewById(R.id.btn_nextplay).setOnClickListener(
                nextLevel->{
                    startActivity(new Intent(ResulteActivity.this ,PlayActivity.class));
                    finish();
                }
        );
    }
}