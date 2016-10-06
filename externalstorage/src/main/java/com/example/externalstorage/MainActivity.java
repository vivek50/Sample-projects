package com.example.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isExternalStorageWritable();
    }

    public void isExternalStorageWritable() {

        findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String state = Environment.getExternalStorageState();

                if (Environment.MEDIA_MOUNTED.equals(state)) {

                    Toast.makeText(MainActivity.this, "External Storage is Writable", Toast.LENGTH_LONG).show();

                } else

                    Toast.makeText(MainActivity.this, "External Storage isn't Writable", Toast.LENGTH_LONG).show();

            }
        });



    }
}

