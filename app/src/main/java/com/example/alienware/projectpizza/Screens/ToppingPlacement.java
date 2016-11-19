package com.example.alienware.projectpizza.Screens;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alienware.projectpizza.R;

import java.util.Arrays;

public class ToppingPlacement extends AppCompatActivity {

    View.OnDragListener dropTopRightQuart = new QuarterListener(this, Arrays.asList(R.id.onTopRightQuart));

    View.OnDragListener dropTopLeftQuart = new QuarterListener(this, Arrays.asList(R.id.onTopLeftQuart));

    View.OnDragListener dropBotLeftQuart = new QuarterListener(this, Arrays.asList(R.id.onBotLeftQuart));

    View.OnDragListener dropBotRightQuart = new QuarterListener(this, Arrays.asList(R.id.onBotRightQuart));

    View.OnDragListener dropLeftHalf = new QuarterListener(this, Arrays.asList(R.id.onTopLeftQuart, R.id.onBotLeftQuart));

    View.OnDragListener dropTopHalf = new QuarterListener(this, Arrays.asList(R.id.onTopLeftQuart, R.id.onTopRightQuart));

    View.OnDragListener dropRightHalf = new QuarterListener(this, Arrays.asList(R.id.onBotRightQuart, R.id.onTopRightQuart));

    View.OnDragListener dropBotHalf = new QuarterListener(this, Arrays.asList(R.id.onBotRightQuart, R.id.onBotLeftQuart));

    View.OnDragListener dropAll = new QuarterListener(this, Arrays.asList(R.id.onBotRightQuart, R.id.onBotLeftQuart, R.id.onTopLeftQuart, R.id.onTopRightQuart));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping_placement);
        findViewById(R.id.newTop1).setOnLongClickListener(longListen);
        findViewById(R.id.newTop2).setOnLongClickListener(longListen);
        findViewById(R.id.newTop3).setOnLongClickListener(longListen);
        findViewById(R.id.newTop4).setOnLongClickListener(longListen);
        findViewById(R.id.newTop5).setOnLongClickListener(longListen);
        findViewById(R.id.newTop6).setOnLongClickListener(longListen);
        findViewById(R.id.newTop7).setOnLongClickListener(longListen);
        findViewById(R.id.newTop8).setOnLongClickListener(longListen);
        findViewById(R.id.newTop9).setOnLongClickListener(longListen);
        findViewById(R.id.newTop10).setOnLongClickListener(longListen);
        findViewById(R.id.newTop11).setOnLongClickListener(longListen);
        findViewById(R.id.newTop12).setOnLongClickListener(longListen);
        findViewById(R.id.newTop13).setOnLongClickListener(longListen);
        findViewById(R.id.newTop14).setOnLongClickListener(longListen);
        findViewById(R.id.newTop15).setOnLongClickListener(longListen);
        findViewById(R.id.newTop16).setOnLongClickListener(longListen);
        findViewById(R.id.newTop17).setOnLongClickListener(longListen);
        findViewById(R.id.newTop18).setOnLongClickListener(longListen);
        findViewById(R.id.newTop19).setOnLongClickListener(longListen);
        findViewById(R.id.newTop20).setOnLongClickListener(longListen);
        findViewById(R.id.newTop21).setOnLongClickListener(longListen);
        findViewById(R.id.newTop22).setOnLongClickListener(longListen);
        findViewById(R.id.newTop23).setOnLongClickListener(longListen);
        findViewById(R.id.newTop24).setOnLongClickListener(longListen);
        findViewById(R.id.top_left_quart).setOnDragListener(dropTopLeftQuart);
        findViewById(R.id.top_right_quart).setOnDragListener(dropTopRightQuart);
        findViewById(R.id.bot_left_quart).setOnDragListener(dropBotLeftQuart);
        findViewById(R.id.bot_right_quart).setOnDragListener(dropBotRightQuart);
        findViewById(R.id.left_half).setOnDragListener(dropLeftHalf);
        findViewById(R.id.right_half).setOnDragListener(dropRightHalf);
        findViewById(R.id.bot_half).setOnDragListener(dropBotHalf);
        findViewById(R.id.top_half).setOnDragListener(dropTopHalf);
        findViewById(R.id.full_pizza).setOnDragListener(dropAll);

    }


    View.OnLongClickListener longListen = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            DragShadow dragShadow = new DragShadow(v);
            v.startDrag(data, dragShadow, v, 0);

            return false;
        }
    };

    private class DragShadow extends View.DragShadowBuilder {
        ColorDrawable greyBox;

        public DragShadow(View view) {
            super(view);
            greyBox = new ColorDrawable(Color.LTGRAY);
            findViewById(R.id.bot_left_quart).setVisibility(View.VISIBLE);
            findViewById(R.id.bot_right_quart).setVisibility(View.VISIBLE);
            findViewById(R.id.top_left_quart).setVisibility(View.VISIBLE);
            findViewById(R.id.top_right_quart).setVisibility(View.VISIBLE);
            findViewById(R.id.bot_half).setVisibility(View.VISIBLE);
            findViewById(R.id.top_half).setVisibility(View.VISIBLE);
            findViewById(R.id.left_half).setVisibility(View.VISIBLE);
            findViewById(R.id.right_half).setVisibility(View.VISIBLE);
            findViewById(R.id.full_pizza).setVisibility(View.VISIBLE);
        }

        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            View v = getView();
            int height = (int) v.getHeight();
            int width = (int) v.getWidth();

            greyBox.setBounds(0, 0, width, height);
            shadowSize.set(width, height);
            shadowTouchPoint.set((int) width / 2, (int) height / 2);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            super.onDrawShadow(canvas);
        }
    }


}
