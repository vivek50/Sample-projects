package com.example.assets_resources_styles_themes;

import android.content.res.AssetManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int appVersion = getResources().getInteger(R.integer.appVersion);
        Log.i("@modi","App Version - " +appVersion);

//        int color = getResources().getColor(R.color.pureWhite);
//        Deprecated Code


        int color = ResourcesCompat.getColor(getResources(),R.color.pureWhite,null);
        color = ContextCompat.getColor(this,R.color.pureWhite);

        AssetManager manger = getAssets();

        try {
            InputStream input = manger.open("android.txt");
//            if file exist in your system

            StringBuilder builder = new StringBuilder();

            while(true) {

                int ch = input.read();

                if (ch == -1)
                    break;
                else
                    builder.append((char) ch);
            }
            Log.i("@modi1","Asset Data is - " + builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
