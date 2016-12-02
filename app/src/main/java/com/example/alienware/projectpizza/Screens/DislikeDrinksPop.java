package com.example.alienware.projectpizza.Screens;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.alienware.projectpizza.R;

/**
 * Created by barak on 27/11/2016.
 */

public class DislikeDrinksPop extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dislikedrinks_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8),(int)(height * 0.8));
    }
}
