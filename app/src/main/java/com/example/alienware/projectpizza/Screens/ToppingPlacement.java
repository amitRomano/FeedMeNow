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

public class ToppingPlacement extends AppCompatActivity {

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
    View.OnDragListener dropTopRightQuart = new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int dragEvent = event.getAction();
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENDED:
                        findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                        Log.i("Drag Event", "Entered");
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.i("Drag Event", "exited");
                        findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.i("Drag Event", "entered");
                        findViewById(R.id.onTopRightQuart).setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DROP:
                        findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                        findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                        findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                        TextView target1 = (TextView) findViewById(R.id.topRightText);
                        TextView dragged = (TextView) event.getLocalState();

                        if(target1.getText().toString().equals("top right:")) {
                            target1.setText("top right: " + dragged.getText());
                        }
                        else if (target1.getText().toString().contains(dragged.getText().toString())){
                        }
                        else {
                            target1.setText(target1.getText().toString() +", " + dragged.getText().toString());
                        }
                        break;
                }
                return true;
            }

    };
    View.OnDragListener dropTopLeftQuart = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.topLeftText);
                    TextView dragged = (TextView) event.getLocalState();
                    if(target.getText().toString().equals("top left:")) {
                        target.setText("top left: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }

    };

    View.OnDragListener dropBotLeftQuart = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.botLeftText);
                    TextView dragged = (TextView) event.getLocalState();
                    if(target.getText().toString().equals("bot left:")) {
                        target.setText("bot left: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }

    };

    View.OnDragListener dropBotRightQuart = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.botRightText);
                    TextView dragged = (TextView) event.getLocalState();
                    if(target.getText().toString().equals("bot right:")) {
                        target.setText("bot right: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }

    };
    View.OnDragListener dropLeftHalf = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.botLeftText);
                    TextView target2 = (TextView) findViewById(R.id.topLeftText);
                    TextView dragged = (TextView) event.getLocalState();

                    if(target.getText().toString().equals("bot left:")) {
                        target.setText("bot left: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }

                    if(target2.getText().toString().equals("top left:")) {
                        target2.setText("top left: " + dragged.getText());
                    }
                    else if (target2.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target2.setText(target2.getText().toString() +", " + dragged.getText().toString());
                    }

                    break;
            }
            return true;
        }
    };
    View.OnDragListener dropTopHalf = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.topRightText);
                    TextView target2 = (TextView) findViewById(R.id.topLeftText);
                    TextView dragged = (TextView) event.getLocalState();

                    if(target.getText().toString().equals("top right:")) {
                        target.setText("top right: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }

                    if(target2.getText().toString().equals("top left:")) {
                        target2.setText("top left: " + dragged.getText());
                    }
                    else if (target2.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target2.setText(target2.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dropRightHalf = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.botRightText);
                    TextView target2 = (TextView) findViewById(R.id.topRightText);
                    TextView dragged = (TextView) event.getLocalState();

                    if(target.getText().toString().equals("bot right:")) {
                        target.setText("bot right: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }

                    if(target2.getText().toString().equals("top right:")) {
                        target2.setText("top right: " + dragged.getText());
                    }
                    else if (target2.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target2.setText(target2.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dropBotHalf = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.i("Drag Event", "Entered");
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.botRightText);
                    TextView target2 = (TextView) findViewById(R.id.botLeftText);
                    TextView dragged = (TextView) event.getLocalState();

                    if(target.getText().toString().equals("bot right:")) {
                        target.setText("bot right: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }

                    if(target2.getText().toString().equals("bot left:")) {
                        target2.setText("bot left: " + dragged.getText());
                    }
                    else if (target2.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target2.setText(target2.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dropAll = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.i("Drag Event", "Entered");
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "entered");
                    findViewById(R.id.onBotRightQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.VISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    findViewById(R.id.onBotRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onBotLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopLeftQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.onTopRightQuart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                    findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                    findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                    TextView target = (TextView) findViewById(R.id.botRightText);
                    TextView target2 = (TextView) findViewById(R.id.botLeftText);
                    TextView target3 = (TextView) findViewById(R.id.topRightText);
                    TextView target4 = (TextView) findViewById(R.id.topLeftText);
                    TextView dragged = (TextView) event.getLocalState();

                    if(target.getText().toString().equals("bot right:")) {
                        target.setText("bot right: " + dragged.getText());
                    }
                    else if (target.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target.setText(target.getText().toString() +", " + dragged.getText().toString());
                    }

                    if(target2.getText().toString().equals("bot left:")) {
                        target2.setText("bot left: " + dragged.getText());
                    }
                    else if (target2.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target2.setText(target2.getText().toString() +", " + dragged.getText().toString());
                    }
                    if(target3.getText().toString().equals("top right:")) {
                        target3.setText("top right: " + dragged.getText());
                    }
                    else if (target3.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target3.setText(target3.getText().toString() +", " + dragged.getText().toString());
                    }

                    if(target4.getText().toString().equals("top left:")) {
                        target4.setText("top left: " + dragged.getText());
                    }
                    else if (target4.getText().toString().contains(dragged.getText().toString())){
                    }
                    else {
                        target4.setText(target4.getText().toString() +", " + dragged.getText().toString());
                    }
                    break;
            }
            return true;
        }
    };
}
