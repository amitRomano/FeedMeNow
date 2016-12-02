package com.example.alienware.projectpizza.Screens;


import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import com.example.alienware.projectpizza.R;

public class ChooseYourToppings extends AppCompatActivity {
    boolean hasOrderd(String order, String newTopping ){
        int k = 0;
        for(int i = 0; i <= order.length() - newTopping.length(); i++ ){
            if(order.charAt(i) == newTopping.charAt(0)){
                k = i;
                for(int j = 0; order.charAt(k) == newTopping.charAt(j) ; j++){
                    k++;
                    if (j == newTopping.length() - 1){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_toppings);
        findViewById(R.id.top1).setOnLongClickListener(longListen);
        findViewById(R.id.top2).setOnLongClickListener(longListen);
        findViewById(R.id.top3).setOnLongClickListener(longListen);
        findViewById(R.id.top4).setOnLongClickListener(longListen);
        findViewById(R.id.top5).setOnLongClickListener(longListen);
        findViewById(R.id.top6).setOnLongClickListener(longListen);
        findViewById(R.id.top7).setOnLongClickListener(longListen);
        findViewById(R.id.top8).setOnLongClickListener(longListen);
        findViewById(R.id.top9).setOnLongClickListener(longListen);
        findViewById(R.id.top10).setOnLongClickListener(longListen);
        findViewById(R.id.top11).setOnLongClickListener(longListen);
        findViewById(R.id.top12).setOnLongClickListener(longListen);
        findViewById(R.id.dragHere).setOnDragListener(dropListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

        @Override
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
                    TextView target = (TextView) v;
                    TextView dragged = (TextView) event.getLocalState();
                    if(target.getText().toString().equals("Drag here")) {
                        target.setText(dragged.getText());
                    }
                    else if (hasOrderd(target.getText().toString(), dragged.getText().toString() )){
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