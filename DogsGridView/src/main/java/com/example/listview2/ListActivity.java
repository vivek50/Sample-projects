package com.example.listview2;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    String[] dogslist;

    int[] dogimages = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources resources = getResources();
        dogslist = resources.getStringArray(R.array.Doglist);
        GridView gridView = (GridView) findViewById(R.id.gridview);

        MyAdapter adapter = new MyAdapter(this,dogslist,dogimages);
        gridView.setAdapter(adapter);

    }
        class MyAdapter extends ArrayAdapter {

            String[] titles;
            Context context;
            int images[];


            public MyAdapter(Context context, String[] titles, int images[]) {
                super(context, R.layout.list, R.id.textview, titles);

                this.context = context;
                this.images = images;
                this.titles = titles;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

                View view = inflater.inflate(R.layout.list, parent, false);

                ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
                imageView.setImageResource(images[position]);
                TextView textView = (TextView) view.findViewById(R.id.textview);
                textView.setText(titles[position]);


                return view;
            }

            @Override
            public int getCount() {
                return images.length;
            }

        }


}
