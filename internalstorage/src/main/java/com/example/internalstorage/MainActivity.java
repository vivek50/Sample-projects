package com.example.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    FileOutputStream FileOutput = openFileOutput("my",MODE_PRIVATE);
                    FileOutput.write("Hello..!! ".getBytes());
                    FileOutput.write("Welcome to Android World".getBytes());
                    FileOutput.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fileInput = openFileInput("my");
                    StringBuilder builder = new StringBuilder();

                    while (true) {

                        int ch = fileInput.read();
                        if(ch == -1)
                            break;
                        else
                            builder.append((char)ch);
                    }
                    Log.i("@data","Read internal storage  \n" + builder.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        findViewById(R.id.btnImp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File fileprivate = getFilesDir();
                Log.i("@filesDir","getFilesDir() - " + fileprivate.getAbsolutePath());

                File newDir = getDir("Internal_Storage",MODE_PRIVATE);
                Log.i("@getDir","getDir() - " + newDir.getAbsolutePath());

                String[] fileNames = fileList();
                for(String fileName : fileNames)
                    Log.i("@filenames","Filename - " + fileName);

            }
        });

    }
}
