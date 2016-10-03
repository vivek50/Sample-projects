package com.example.listview;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String[] avenlist;

    int[] avenimages = {R.drawable.captain_america,R.drawable.hulk,R.drawable.thor,R.drawable.black_widow,R.drawable.iron_man,
            R.drawable.clint,R.drawable.ultron,R.drawable.vision};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        avenlist = resources.getStringArray(R.array.Avengers);
        ListView listView = (ListView) findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter(this,avenlist,avenimages);
        listView.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter {

        String[] titles;
        Context context;
        int images[];


        public MyAdapter(Context context, String[] titles, int images[]) {

            super(context,R.layout.list,R.id.textview,titles);
            this.context = context;
            this.images = images;
            this.titles = titles;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.list,parent,false);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
            imageView.setImageResource(images[position]);
            TextView textView = (TextView) view.findViewById(R.id.textview);
            textView.setText(titles[position]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(position==0)
                    {
                        Toast.makeText(getContext(), "Postion" + position, Toast.LENGTH_SHORT).show();
                    }
                    else if (position==1)
                    {
                        Toast.makeText(getContext(), "Postion" + position, Toast.LENGTH_SHORT).show();
                    }

                }
            });

            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    }

}
