package com.example.adapterview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customAdapter();

//        arrayAdapter();

//        gridview();

    }


    private void customAdapter() {

        ArrayList<MyItem> items = new ArrayList<>();
        items.add(new MyItem(1l,R.mipmap.ic_launcher,"Android"));
        items.add(new MyItem(2l,R.mipmap.ic_launcher,"Windows"));
        items.add(new MyItem(3l,R.mipmap.ic_launcher,"Apple"));
        items.add(new MyItem(4l,R.mipmap.ic_launcher,"Rim"));

        ((ListView)findViewById(R.id.listview)).setAdapter(new MyAdapter(this,items));

    }

    private void arrayAdapter() {

        ArrayList<String> dataset = new ArrayList<>();
        dataset.add("Gujarat");
        dataset.add("Maharastra");
        dataset.add("Madhyapradesh");
        dataset.add("Goa");
        dataset.add("Rajsthan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataset);

        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);
    }

    private void gridview() {

        startActivity(new Intent(this,GridActivity.class));

    }

}
