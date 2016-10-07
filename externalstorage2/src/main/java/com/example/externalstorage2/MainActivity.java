package com.example.externalstorage2;

import android.media.MediaScannerConnection;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeonPublicStorage();

        readfromPublicStorage();
    }

    private void writeonPublicStorage () {

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),"Our.txt");

        try {

            FileOutputStream fos = new FileOutputStream(file);
            fos.write("Hello....".getBytes());
            fos.write("This is an External Storage".getBytes());
            fos.close();
            MediaScannerConnection.scanFile(MainActivity.this,new String[] { file.toString()}, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readfromPublicStorage () {

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"Our.txt");

        try {
            FileInputStream fis = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();

            while (true)
            {
                int ch = fis.read();

                if (ch == -1)
                    break;
                else
                    builder.append((char)ch);
            }
            Log.i("@vivek",builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
