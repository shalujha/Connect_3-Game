package com.example.game_connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     public  int active_number=0;
     int[]game_status={2,2,2,2,2,2,2,2,2};
     int[][]wining_points={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
     boolean game_activator=true;

    public void clickFunction(View view){
        ImageView imageView=(ImageView)view;
        int tag_num=Integer.parseInt(imageView.getTag().toString());
        game_status[tag_num]=active_number;
        view.setTranslationY(-1500); // set the image view 1500 units above the reference point
        if(active_number==0 && game_activator){
            imageView.setImageResource(R.drawable.yellow); // set yellow image to imageview
            active_number=1;
        }else if(active_number==1 && game_activator) {
            imageView.setImageResource(R.drawable.red); // set yellow image to imageview
            active_number=0;
        }
        view.animate().translationYBy(1500).rotation(3600).setDuration(900); // provide animation to image view
        // lets add check  whether someone has lost or won  or no effect
        String winner="";
        if(game_status[tag_num]==0 && game_activator){
            winner="yellow";
        }else if(game_status[tag_num]==1 && game_activator){
            winner="red";
        }
        boolean won=false;
        for(int[]wining_point: wining_points){
            if(game_status[wining_point[0]]==game_status[tag_num] && game_status[wining_point[1]]==game_status[tag_num] && game_status[wining_point[2]]==game_status[tag_num]){
                Toast.makeText(this, winner+" Won !!", Toast.LENGTH_SHORT).show();
                won=true;
                game_activator=false;
                playAgain();
                break;
            }
        }
        // lets check for draw condition:
        if(!won && game_activator) {
            boolean draw = true;
            for (int val : game_status) {
                if (val == 2) {
                    draw = false;
                    break;
                }
            }

            if (draw && game_activator) {
                Toast.makeText(this, "Draw Ho Gya :(", Toast.LENGTH_SHORT).show();
                game_activator=false;
                playAgain();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
    }

    public void playAgain(){
        Button btn=(Button)findViewById(R.id.button);
        btn.setVisibility(View.VISIBLE);
    }
    public void ButtonClick(View view){
        game_activator=true;
        for(int i=0;i<game_status.length;i++){
            game_status[i]=2;
        }
        ImageView im1=(ImageView)findViewById(R.id.imageView1);
        ImageView im2=(ImageView)findViewById(R.id.imageView2);
        ImageView im3=(ImageView)findViewById(R.id.imageView3);
        ImageView im4=(ImageView)findViewById(R.id.imageView4);
        ImageView im5=(ImageView)findViewById(R.id.imageView5);
        ImageView im6=(ImageView)findViewById(R.id.imageview6);
        ImageView im7=(ImageView)findViewById(R.id.imageView7);
        ImageView im8=(ImageView)findViewById(R.id.imageview8);
        ImageView im9=(ImageView)findViewById(R.id.imageView9);
        im1.setImageDrawable(null);
        im2.setImageDrawable(null);
        im3.setImageDrawable(null);
        im4.setImageDrawable(null);
        im5.setImageDrawable(null);
        im6.setImageDrawable(null);
        im7.setImageDrawable(null);
        im8.setImageDrawable(null);
        im9.setImageDrawable(null);
        Button btn=(Button)findViewById(R.id.button);
        btn.setVisibility(View.INVISIBLE);
    }
}