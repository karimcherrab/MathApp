package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    String[] question_list = {"4,8,16,?","2+2*2 = ?","6 = 30\n3 = 15\n7 = 35\n2 = ?","4,11,18,?","5+5*5-5=?",
            "A + B = 60\nA - B = 40\nA / B = ?","26,13 = ?","8-8/4*3 = ?","","11,15,20,?","7,15,31,?",
            "13,18 = 31\n7,25 = 32\n12,30 = 42\n26,13 = ?"};

    int[] answer_list = {32,6,10,25,25,5,2,26,63,39};

    SharedPreferences sharedPreferences;
    int current_level;
    TextView level_game , question_level;
    EditText edit_answer;
    String numberPlayer ="";
    Button btn_clear , btn_enter;
    int level_menu =0 , indexAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        level_game = findViewById(R.id.level_game);
        question_level = findViewById(R.id.question_level);
        edit_answer = findViewById(R.id.edit_answer);
        btn_clear = findViewById(R.id.btn_clear);
        btn_enter = findViewById(R.id.btn_enter);
        sharedPreferences = getSharedPreferences("Math_game",MODE_PRIVATE);
        current_level = sharedPreferences.getInt("Level",0);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            level_menu = extras.getInt("LevelMenu");
            level_game.setText("Level"+(level_menu));
            question_level.setText(question_list[level_menu-1]);
            indexAnswer = level_menu-1;
        }else {

            level_game.setText("Level"+(current_level+1));
            question_level.setText(question_list[current_level]);
            indexAnswer  = current_level;
        }

        System.out.println("ssss = " + current_level);
        System.out.println("aaaa = " + level_menu);

        findViewById(R.id.image_back).setOnClickListener(
                back ->{
                    startActivity(new Intent(PlayActivity.this ,MainActivity.class));
                    finish();
                }
        );





        btn_clear.setOnClickListener(
                clear->{
                    numberPlayer ="";
                    edit_answer.setText(numberPlayer);
                }
        );
        btn_enter.setOnClickListener(
                enter ->{
                   //Convert String to int
                    int num_player = Integer.parseInt(numberPlayer);
                    if(num_player == answer_list[indexAnswer]){
                        //Update the player's level
                        if(level_menu==0){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt("Level",current_level+1);
                            editor.apply();

                            //GO to ResulteActivity
                            Intent intent = new Intent(PlayActivity.this , ResulteActivity.class);
                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(PlayActivity.this , LevelsActivity.class);
                            startActivity(intent);
                        }
                        finish();


                    }else {
                        Toast.makeText(PlayActivity.this,"Wrong. Try again!",Toast.LENGTH_LONG).show();
                        numberPlayer ="";
                        edit_answer.setText(numberPlayer);
                    }
                }
        );

    }

    public void click_number(View view) {
        Button btn_choose = (Button) view;
        if(numberPlayer.length()<=5){
            numberPlayer = numberPlayer + btn_choose.getText().toString();
            edit_answer.setText(numberPlayer);
        }
    }
}