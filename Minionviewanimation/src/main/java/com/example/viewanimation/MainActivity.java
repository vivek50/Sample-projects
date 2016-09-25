package com.example.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnmixed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animbuilding(R.anim.mixed);
                Toast.makeText(MainActivity.this, "Mixed Viewanimation", Toast.LENGTH_SHORT).show();

            }
        });

        findViewById(R.id.btnrotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animbuilding(R.anim.rotate);
                Toast.makeText(MainActivity.this, "Rotate Viewanimation", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void animbuilding(int animation){

        findViewById(R.id.minionview).startAnimation(AnimationUtils.loadAnimation(this,animation));
    }

}
