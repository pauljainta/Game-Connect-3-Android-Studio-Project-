package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int player;

    // red:1,yellow:2, empty:3

    int[] gameState={3,3,3,3,3,3,3,3,3};
    int[][] winningPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};



    public void play(View view)
    {
        ImageView imageView=(ImageView) view;

        int tappedImage=Integer.parseInt(imageView.getTag().toString());

        gameState[tappedImage]=player;

        if(player==1)
        {
            imageView.setImageResource(R.drawable.red);
            player=2;
        }
        else
        {
            imageView.setImageResource(R.drawable.yellow);
            player=1;
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player=1;
    }
}