package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player;

    // red:1,yellow:2, empty:3

    int[] gameState={3,3,3,3,3,3,3,3,3};
    int[][] winningPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    boolean isEnd;
    Button playAgainButton;
    GridLayout gridLayout;

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
         playAgainButton=(Button) findViewById(R.id.button);
         gridLayout=(GridLayout) findViewById(R.id.grid);

        int tappedImage=Integer.parseInt(imageView.getTag().toString());

        if(gameState[tappedImage-1]==3 && !isEnd) {

            gameState[tappedImage - 1] = player;
            if (player == 1) {
                imageView.setImageResource(R.drawable.red);
                if (CheckWinningPositions(player)) {
                    Log.i("JITSE NAKI?", player + " has won");
                    isEnd=true;
                    playAgainButton.setVisibility(View.VISIBLE);




                }
                player = 2;
            }
            else {
                imageView.setImageResource(R.drawable.yellow);
                if (CheckWinningPositions(player)) {
                    Log.i("JITSE NAKI?", player + " has won");
                    isEnd=true;
                    playAgainButton.setVisibility(View.VISIBLE);

                }

                player = 1;
            }
        }


    }

    public void PlayAgain(View view)
    {
        playAgainButton.setVisibility(View.INVISIBLE);
        isEnd=false;
        gameState= new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3};
          for(int i=0;i<gridLayout.getChildCount();i++)
          {
              ImageView imageView=(ImageView) gridLayout.getChildAt(i);
              imageView.setImageDrawable(null);
          }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player=1;
        isEnd=false;
    }
}