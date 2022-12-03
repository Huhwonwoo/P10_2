package com.cookandroid.p10_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");



        Integer ivID[] = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,
                R.id.iv7,R.id.iv8,R.id.iv9};
        Integer imageID[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        ImageView imageViews[] = new ImageView[9];
        int[] resultID = new int[9];

        for(int i=0; i<9; i++){
            imageViews[i] = (ImageView) findViewById(ivID[i]);
        }
        for(int i=0; i<9; i++){
            resultID[i] = 0;
        }
        for(int i=0; i<9; i++){
            for(int j = i+1; j<9; j++){
                if(voteResult[i] < voteResult[j]){
                    resultID[i]++;
                }else{
                    resultID[j]++;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            imageViews[resultID[i]].setImageResource(imageID[i]);
        }
        Button btnStart, btnStop;
        final ViewFlipper viewFlipper;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewF);

        viewFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.startFlipping();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
            }
        });
    }

}
