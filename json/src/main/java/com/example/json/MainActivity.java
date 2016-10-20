package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = readJson();

        Log.i("@modi","Json is : " + json);

        ((TextView)findViewById(R.id.nameview)).setText("Name is : " + names(json));
        ((TextView)findViewById(R.id.cityview)).setText("Cities is : " + cities(json));
        ((TextView)findViewById(R.id.ageview)).setText("Age is : " + age(json));
        ((TextView)findViewById(R.id.nationview)).setText("isIndian : " + isIndian(json));

    }

    private String readJson() {

        StringBuilder builder = new StringBuilder();

        try {
            InputStream is = getAssets().open("android.json");

            while (true){
                int ch = is.read();
                if (ch == -1)
                    break;
                else
                    builder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private String names (String name){

        String names = null;

        try {
            JSONObject object = new JSONObject(name);
            names = object.getString("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return names;
    }

    private ArrayList<String> cities (String city) {

        ArrayList<String> cities = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(city);
            JSONArray array = object.getJSONArray("cities");
            for (int i = 0; i < array.length(); i++)
                cities.add(array.getString(i));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private Integer age (String json) {

        Integer age = null;

        try {
            JSONObject object = new JSONObject(json);
            age = object.getInt("age");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return age;
    }

    private Boolean isIndian (String json) {

        Boolean isIndian = null;

        try {
            JSONObject object = new JSONObject(json);
            isIndian = object.getBoolean("isIndian");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return isIndian;
    }
}
