package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player;

    // red:1,yellow:2, empty:3

    int[] gameState={3,3,3,3,3,3,3,3,3};
    int[][] winningPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};


    public boolean CheckWinningPositions(int P)
    {
        boolean hasWon=false;

            for(int i=0;i<winningPositions.length;i++)
            {
                int counter=0;
                for(int j=0;j<3;j++)
                {
                    if(gameState[winningPositions[i][j]-1]==P) counter++;
                }
                Log.i("COUNTER",counter+"");

                if(counter==3)
                {
                    hasWon=true;
                    break;
                }
            }




        return hasWon;
    }




    public void play(View view)
    {
        ImageView imageView=(ImageView) view;

        int tappedImage=Integer.parseInt(imageView.getTag().toString());

        gameState[tappedImage-1]=player;

        if(player==1)
        {
            imageView.setImageResource(R.drawable.red);
           if(CheckWinningPositions(player))
           {
               //Toast.makeText(this,player+" has won")
               Log.i("JITSE NAKI?",player+" has won");



           }
            player=2;
        }
        else
        {
            imageView.setImageResource(R.drawable.yellow);
            if(CheckWinningPositions(player))
            {
                Log.i("JITSE NAKI?",player+" has won");
               return;
            }

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