package com.example.mathgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LevelAdapter extends ArrayAdapter<LevelModel> {
    public LevelAdapter(Context context , ArrayList<LevelModel> levels){
        super(context , 0 , levels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if(listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.item_level,parent,false);
        }
        LevelModel levelModel = getItem(position);
        Button btn_level = listitemView.findViewById(R.id.btn_level);
        btn_level.setText(levelModel.getNumberLevel()+"");
        if(!levelModel.isEnable){
            btn_level.setEnabled(false);
            btn_level.setBackgroundResource(R.color.color);
        }
        btn_level.setOnClickListener(
                a->{
                    Intent intent = new Intent(getContext() , PlayActivity.class);
                    intent.putExtra("LevelMenu",levelModel.getNumberLevel());
                    getContext().startActivity(intent);

                }
        );
        return listitemView;
    }
}
