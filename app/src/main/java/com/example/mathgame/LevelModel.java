package com.example.mathgame;

public class LevelModel {
    int numberLevel ;
    boolean isEnable ;

    public LevelModel(int numberLevel, boolean isEnable) {
        this.numberLevel = numberLevel;
        this.isEnable = isEnable;
    }

    public int getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(int numberLevel) {
        this.numberLevel = numberLevel;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
