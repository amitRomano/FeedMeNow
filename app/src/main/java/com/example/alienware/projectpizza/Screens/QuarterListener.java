package com.example.alienware.projectpizza.Screens;

import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;

import com.example.alienware.projectpizza.Objects.Quarter;
import com.example.alienware.projectpizza.Objects.Topping;
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
    List<Integer> onTopQuartersIds;
    ToppingPlacement toppingPlacement;

    public QuarterListener(ToppingPlacement toppingPlacement, List<Integer> quaeterIds) {
        this.onTopQuartersIds = quaeterIds;
        this.toppingPlacement = toppingPlacement;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int dragEvent = event.getAction();
        v.getId();
        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_ENDED:
                makeAllQuartersInvisible();
            case DragEvent.ACTION_DRAG_EXITED:
                Log.i("Drag Event", "exited");
                makeAllRelevantQuartersInvisible();
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.i("Drag Event", "entered");
                makeAllRelevantQuartersVisible();
                break;
            case DragEvent.ACTION_DROP:
                makeAllQuartersInvisible();


                AppCompatTextView localState = (AppCompatTextView)event.getLocalState();

                for(Integer quarter : onTopQuartersIds){
                    //get the quarter object base on is id
                    Quarter quarterObject = toppingPlacement.getQuarterFromId(quarter);
                    // get the relevant topping from the toppingMap based on the id of the object we are dragging
                    Topping topping = ToppingPlacement.toppingsMap.get(localState.getId());

                    toppingPlacement.getCurrentPizza().insertTopping(quarterObject, topping);
                }
                break;

        }
        return true;

    }

    private void makeAllQuartersInvisible() {
        toppingPlacement.findViewById(R.id.bot_left_quart).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.bot_right_quart).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.top_left_quart).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.top_right_quart).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.bot_half).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.top_half).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.left_half).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.right_half).setVisibility(View.INVISIBLE);
        toppingPlacement.findViewById(R.id.full_pizza).setVisibility(View.INVISIBLE);
    }

    private void makeAllRelevantQuartersVisible() {
        for(Integer id : onTopQuartersIds){
            toppingPlacement.findViewById(id).setVisibility(View.VISIBLE);
        }
    }

    private void makeAllRelevantQuartersInvisible() {
        for(Integer id : onTopQuartersIds){
            toppingPlacement.findViewById(id).setVisibility(View.INVISIBLE);
        }
    }
}
