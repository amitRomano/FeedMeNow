package com.example.alienware.projectpizza.Screens;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import com.example.alienware.projectpizza.R;

import java.util.List;

/**
 * Created by michael on 18/11/2016.
 */

public class QuarterListener extends AppCompatActivity implements View.OnDragListener  {
    List<Integer> quaeterIds;

    public QuarterListener(List<Integer> quaeterIds) {
        this.quaeterIds = quaeterIds;
    }

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
            case DragEvent.ACTION_DRAG_EXITED:
                Log.i("Drag Event", "exited");
                makeAllIdsInvisible();
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.i("Drag Event", "entered");
                makeAllIdsVisible();
                break;
            case DragEvent.ACTION_DROP:
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

    private void makeAllIdsVisible() {
        for(Integer id : quaeterIds){
            findViewById(id).setVisibility(View.VISIBLE);
        }
    }

    private void makeAllIdsInvisible() {
        for(Integer id : quaeterIds){
            findViewById(id).setVisibility(View.INVISIBLE);
        }
    }
}
