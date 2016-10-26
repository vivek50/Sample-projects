package com.example.multiplemp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    private MediaPlayer bellsound,shankhsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnplay).setOnClickListener(this::startMusicService);
        findViewById(R.id.btnsound1).setOnClickListener(this::startsound1);
        findViewById(R.id.btnsound2).setOnClickListener(this::startsound2);

    }

    private void startsound2(View view) {

        shankhsound = new MediaPlayer();
        shankhsound = MediaPlayer.create(this,R.raw.shankh);
        shankhsound.start();

    }

    private void startsound1(View view) {

        bellsound = new MediaPlayer();
        bellsound = MediaPlayer.create(this,R.raw.bell);
        bellsound.start();

    }

    private void startMusicService(View view) {

        startService(new Intent(this,MyService.class));
    }
}
