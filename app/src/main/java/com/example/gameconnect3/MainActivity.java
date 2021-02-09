package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int player;


    public void play(View view)
    {
        ImageView imageView=(ImageView) view;

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