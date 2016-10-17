package com.example.adapterview;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        String []dataset = {"1","2","3","4","5","6","7"};

        ((GridView)findViewById(R.id.gridview))
                .setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dataset));
    }
}
