package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class LevelsActivity extends AppCompatActivity {
    GridView gridView;
    int maxLevel = 10 , currentLevel_player;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        gridView = findViewById(R.id.gridView);
        sharedPreferences = getSharedPreferences("Math_game",MODE_PRIVATE);
        currentLevel_player = sharedPreferences.getInt("Level",0);

        ArrayList<LevelModel> listLevels = new ArrayList<>();
        for (int i = 1 ; i<=maxLevel ; i++){
            LevelModel levelModel = new LevelModel(i , false);
            if(i<=currentLevel_player+1){
                levelModel.setEnable(true);
            }
            listLevels.add(levelModel);
        }
        LevelAdapter levelAdapter  = new LevelAdapter(this , listLevels);
        gridView.setAdapter(levelAdapter);
    }
}