package com.example.alienware.projectpizza.Screens;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import com.example.alienware.projectpizza.R;

import java.util.List;

/**
 * Created by michael on 18/11/2016.
 */
 /*
 this class get a toppingPlacement instant , and list of chosen ids of this instance ,
 and rearrange the dragListener to match to the chosen ids
 when entering event ACTION_DRAG_EXITED and ACTION_DRAG_ENTERED
 this chosen ids will be VISIBLE / UNVISIBLE accordingly
  */

public class QuarterListener  implements View.OnDragListener  {
    List<Integer> quaeterIds;
    ToppingPlacement toppingPlacement;

    public QuarterListener(ToppingPlacement toppingPlacement, List<Integer> quaeterIds) {
        this.quaeterIds = quaeterIds;
        this.toppingPlacement = toppingPlacement;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int dragEvent = event.getAction();
        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_ENDED:
                toppingPlacement.findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
            case DragEvent.ACTION_DRAG_EXITED:
                Log.i("Drag Event", "exited");
                makeAllIdsInvisible();
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.i("Drag Event", "entered");
                makeAllIdsVisible();
                break;
            case DragEvent.ACTION_DROP:
                toppingPlacement.findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
                toppingPlacement.findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
                TextView target1 = (TextView) toppingPlacement.findViewById(R.id.topRightText);
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
            toppingPlacement.findViewById(id).setVisibility(View.VISIBLE);
        }
    }

    private void makeAllIdsInvisible() {
        for(Integer id : quaeterIds){
            toppingPlacement.findViewById(id).setVisibility(View.INVISIBLE);
        }
    }
}
