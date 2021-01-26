package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int count =0;
    boolean game = true;
    TextView txt;
int crossboard [] = new int[9];
int[][] board = {{0,1,2},{3,4,5},{6,7,8}
                ,{0,3,6},{1,4,7},{2,5,8},
                 {0,4,8},{2,4,6}};
private boolean player1 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.imageView);
       txt = findViewById(R.id.textView);
         Button button = findViewById(R.id.button);
         Arrays.fill(crossboard,2);


    }
    public void choose(View v) {
        ImageView img = (ImageView)v;
        int pos = Integer.parseInt(img.getTag().toString());//get tag number in form of string and then to integer

      if(crossboard[pos]!=2||game==false)
          return;

      img.setTranslationX(-1000f);
      if(player1){
          crossboard[pos] = 0;
          img.setImageResource(R.drawable.cross1);
          player1= false;
          count++;
          txt.setText("PLAYER 2 TURN");
      }
      else{
          crossboard[pos]=1;
          img.setImageResource(R.drawable.circle1);
          player1=true;
          count++;
          txt.setText("PLAYER 1 TURN");
      }
      img.animate().translationXBy(1000f).setDuration(500).rotationBy(720);

      for(int[] val : board){
          if(crossboard[val[0]]==crossboard[val[1]]&&crossboard[val[1]]==crossboard[val[2]]&&crossboard[val[0]]!=2){
              if(crossboard[val[0]]==0){
                  txt.setText("PLAYER 1 HAS WON!!");
              game=false;}
              else{
                  txt.setText("PLAYER 2 HAS WON!! ");
              game=false;}
          }
      }
        if(count==9){
            txt.setText("GAME IS TIE!!");
            game=false;
        }


    }



    public void resetgame(View v){
       game = true;
       player1=true;
       count=0;
       Arrays.fill(crossboard,2);
        ((ImageView)findViewById(R.id.imageView00)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView01)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView02)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(R.drawable.tictactoe);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(R.drawable.tictactoe);

        txt.setText("PLAYER 1 TURN");
    }
}
