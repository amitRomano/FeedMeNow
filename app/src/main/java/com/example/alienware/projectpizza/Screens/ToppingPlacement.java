package com.example.alienware.projectpizza.Screens;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.alienware.projectpizza.Objects.Order;
import com.example.alienware.projectpizza.Objects.Pizza;
import com.example.alienware.projectpizza.Objects.Quarter;
import com.example.alienware.projectpizza.Objects.Topping;
import com.example.alienware.projectpizza.R;
import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ToppingPlacement extends AppCompatActivity {

   public static final Map<Integer, Topping> toppingsMap = new ImmutableMap.Builder<Integer, Topping>()
            .put(R.id.onion, Topping.onion)
            .put(R.id.mushrooms, Topping.mushrooms)
            .put(R.id.bacon, Topping.bacon)
            .put(R.id.corn, Topping.corn)
            .put(R.id.pepperoni, Topping.peperroni)
            .put(R.id.tuna, Topping.tuna)
            .put(R.id.extraCheese, Topping.extraCheese)
            .put(R.id.blueCheese, Topping.blueCheese)
            .put(R.id.pineapple, Topping.pineapple)
            .put(R.id.beef, Topping.beef)
            .put(R.id.anchovy, Topping.anchovi)
            .build();

    public  Map<Integer,Quarter> quarterMap;


    private static Order currentOrder;

    private static Pizza currentPizza;

    View.OnDragListener dropTopRightQuart = new QuarterListener(this, Arrays.asList(R.id.top_right_quart));

    View.OnDragListener dropTopLeftQuart = new QuarterListener(this, Arrays.asList(R.id.top_left_quart));

    View.OnDragListener dropBotLeftQuart = new QuarterListener(this, Arrays.asList(R.id.bot_left_quart));

    View.OnDragListener dropBotRightQuart = new QuarterListener(this, Arrays.asList(R.id.bot_right_quart));

    View.OnDragListener dropLeftHalf = new QuarterListener(this, Arrays.asList(R.id.top_left_quart, R.id.bot_left_quart));

    View.OnDragListener dropTopHalf = new QuarterListener(this, Arrays.asList(R.id.top_left_quart, R.id.top_right_quart));

    View.OnDragListener dropRightHalf = new QuarterListener(this, Arrays.asList(R.id.bot_right_quart, R.id.top_right_quart));

    View.OnDragListener dropBotHalf = new QuarterListener(this, Arrays.asList(R.id.bot_right_quart, R.id.bot_left_quart));

    View.OnDragListener dropAll = new QuarterListener(this, Arrays.asList(R.id.bot_right_quart, R.id.bot_left_quart, R.id.top_left_quart, R.id.top_right_quart));


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
        findViewById(R.id.onion).setOnLongClickListener(longListen);
        findViewById(R.id.mushrooms).setOnLongClickListener(longListen);
        findViewById(R.id.bacon).setOnLongClickListener(longListen);
        findViewById(R.id.corn).setOnLongClickListener(longListen);
        findViewById(R.id.pepperoni).setOnLongClickListener(longListen);
        findViewById(R.id.tuna).setOnLongClickListener(longListen);
        findViewById(R.id.extraCheese).setOnLongClickListener(longListen);
        findViewById(R.id.blueCheese).setOnLongClickListener(longListen);
        findViewById(R.id.pineapple).setOnLongClickListener(longListen);
        findViewById(R.id.beef).setOnLongClickListener(longListen);
        findViewById(R.id.anchovy).setOnLongClickListener(longListen);
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

        inistateToppingsMap();

        currentOrder = new Order();

        currentPizza = new Pizza();

        quarterMap = ImmutableMap.of(R.id.top_left_quart, Quarter.topLeftQuart,
                R.id.top_right_quart, Quarter.topRightQuart,
                R.id.bot_left_quart, Quarter.bottomLeftQuart,
                R.id.bot_right_quart, Quarter.bottomRightQuart

            );

    }

    private void inistateToppingsMap() {

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


    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }


    public static Pizza getCurrentPizza() {
        return currentPizza;
    }

    public static void setCurrentPizza(Pizza currentPizza) {
        ToppingPlacement.currentPizza = currentPizza;
    }

    public Quarter getQuarterFromId(int id){
        return quarterMap.get(id);
    }
}
