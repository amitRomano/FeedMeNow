package com.example.alienware.projectpizza.Screens;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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
        findViewById(R.id.pizza_ref).setOnDragListener(dropListener);

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
    View.OnDragListener dropListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "exited");
                    break;
                case DragEvent.ACTION_DROP:
                    TextView target = (TextView) findViewById(R.id.show_picked);
                    TextView dragged = (TextView) event.getLocalState();
                    if(target.getText().toString().equals("drag the toppings to the pizza")) {
                        target.setText(dragged.getText());
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
}
