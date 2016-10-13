package com.example.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnDial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_DIAL));

            }
        });

        findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_CALL)
                        .setData(Uri.parse("tel://9999900000")));

            }
        });

        findViewById(R.id.btnWebsearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_WEB_SEARCH)
                        .setData(Uri.parse("http://Google.com")));

            }
        });

        findViewById(R.id.btnMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_VIEW)
                        .setData(Uri.parse("http://maps.google.com/maps?")));

            }
        });

        findViewById(R.id.btnNews).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_VIEW)
                        .setData(Uri.parse("http://news.google.co.in/news?")));

            }
        });

        findViewById(R.id.btnPlayStore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_VIEW)
                        .setData(Uri.parse("http://play.google.com/store")));

            }
        });

        findViewById(R.id.btnMusic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction(Intent.ACTION_VIEW)
                        .setData(Uri.parse("http://music.google.com/music")));

            }
        });

        findViewById(R.id.btnGithub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent().setAction("com.example.action.github")
                        .setData(Uri.parse("http://Github.com")));

            }
        });

    }
}
