package com.example.mathgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickButton(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this , PlayActivity.class));
                break;
            case R.id.btn_levels:
                startActivity(new Intent(MainActivity.this , LevelsActivity.class));

                break;
            case R.id.btn_settings:
                Show_AlertDialog_Settings();
                break;
            case R.id.btn_follows:
                followUs();
                break;
            case R.id.btn_exit:
                this.finishAffinity();
                break;
        }
    }

    private void followUs() {
        Uri uri = Uri.parse("https://www.instagram.com/?hl=fr");
        Intent linkIng  = new Intent(Intent.ACTION_VIEW , uri);
        linkIng.setPackage("com.instagram.android");
        try {
            startActivity(linkIng);
        }catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.instagram.com/?hl=fr")));
        }
    }

    private void Show_AlertDialog_Settings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View layoutView = getLayoutInflater().inflate(R.layout.alertdialog_settings , null);
        builder.setView(layoutView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        alertDialog.setCancelable(false);

        layoutView.findViewById(R.id.btn_restart).setOnClickListener(
                restart ->{
                    SharedPreferences sharedPreferences = getSharedPreferences("Math_game",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("Level",0);
                    editor.apply();
                    alertDialog.dismiss();

                }
        );

        layoutView.findViewById(R.id.btn_close).setOnClickListener(
                close ->{
                    alertDialog.dismiss();
                }
        );



    }
}