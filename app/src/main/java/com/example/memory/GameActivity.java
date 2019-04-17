package com.example.memory;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int[] cardsData = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // --- Init Cards

        // >> 0,1,2,3,4,5,0,1,2,3,4,5

        for (int i = 0; i <8; i++){
            cardsData[i] = i;
            cardsData[i+6] = i;
        }

        // --- Shuffle Cards

        Random rnd = new Random();
        for(int i=0; i<12; i++){

            //Random
            int r = rnd.nextInt(12);

            //Swap
            int tmp = cardsData[i];
            cardsData[i] = cardsData[r];
            cardsData[r] = tmp;
        }

        Log.i("Cards Rnd", ""+printIntArray(cardsData));


        // ---

        for (int i=0; i<12; i++){

            int id = getResources().getIdentifier("cards"+i,"id",getPackageName());
            ImageView card = (ImageView) findViewById(id);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = view.getResources().getResourceName(view.getId());
                    int curId = Integer.parseInt(name.substring(5));

                    ImageView curCard = (ImageView) view;

                    curCard.animate().scaleX(0f).setDuration(100);


                    Handler curTimer = new Handler();
                    curTimer.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 200);



                }
            });
        }

    }

    String printIntArray(int[] a){
        String s = "";
        for (int i =0; i<a.length; i++){
            s += a[i]+", ";
        }
        return s;
    }
}
