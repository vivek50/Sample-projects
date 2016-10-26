package com.example.multiplemp3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.View;

public class MyService extends Service{

    private MediaPlayer player;

    public MyService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(this::startMusic).start();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {

        player.stop();
        player.release();
        super.onDestroy();
    }

    private void startMusic () {

        player = new MediaPlayer();
        player = MediaPlayer.create(this,R.raw.song);
        player.start();


    }
}
