package com.example.adapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vivek50 on 14/9/16.
 */
public class MyAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<MyItem>dataset;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<MyItem>dataset) {

        this.context = context;
        this.dataset = dataset;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataset.get(position).getItemId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemview = null;
        if(convertView == null)
            itemview = inflater.inflate(R.layout.my_item,null,false);
        else
            itemview = convertView;

        ((ImageView)itemview.findViewById(R.id.imageview))
                .setImageResource(dataset.get(position).getImageId());

        ((TextView)itemview.findViewById(R.id.textview)).setText(dataset.get(position).getText());

        return itemview;

    }
}
