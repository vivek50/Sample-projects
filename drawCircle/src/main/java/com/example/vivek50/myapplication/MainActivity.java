package com.example.vivek50.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changecircle();

            }
        });

        }

    private void changecircle(){

        ((MyView)findViewById(R.id.MyView)).changeAttr(getCx(),getCy(),getRadius());

    }

    private float getCx(){

        return Float.parseFloat(((EditText)findViewById(R.id.edtCx))
                .getText().toString());
    }

    private float getCy() {

        return  Float.parseFloat(((EditText)findViewById(R.id.edtCy))
                .getText().toString());
    }

    private float getRadius() {

        return Float.parseFloat(((EditText)findViewById(R.id.edtr))
                .getText().toString());
    }

    }
