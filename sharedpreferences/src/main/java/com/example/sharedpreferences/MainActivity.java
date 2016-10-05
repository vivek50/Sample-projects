package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_INT = "MyInt";
    private static final String KEY_STRING1 = "MyString1";
    private static final String KEY_FLOAT = "MyFloat";
    private static final String KEY_STRING2 = "MyString2";
    private static final String KEY_BOOLEAN = "My Boolean";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    WriteSharedPreferences();

                    ReadSharedPreferences();

                }
            });

    }

    private void WriteSharedPreferences() {

        SharedPreferences preferences = getSharedPreferences("my_file",MODE_PRIVATE);

//        preferences = getPreferences(MODE_PRIVATE);
//        This is a declaration of getPreferences...

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_INT,07);
        editor.putString(KEY_STRING1,"March");
        editor.putFloat(KEY_FLOAT,19.95f);
        editor.putString(KEY_STRING2,"MODI");
        editor.putBoolean(KEY_BOOLEAN,true);
        editor.commit();

    }

    private void ReadSharedPreferences() {

        SharedPreferences preferences = getSharedPreferences("my_file",MODE_PRIVATE);

        Integer INT = preferences.getInt(KEY_INT,7);
        String STR1 = preferences.getString(KEY_STRING1,"Mar");
        Float  FLT = preferences.getFloat(KEY_FLOAT,199.5f);
        String STR2 = preferences.getString(KEY_STRING2,"VIVEK");
        Boolean BOOL = preferences.getBoolean(KEY_BOOLEAN,false);

        Log.i("@modi@","Integer = " + INT);
        Log.i("@modi@","String1 = " + STR1);
        Log.i("@modi@","Float = " + FLT);
        Log.i("@modi@","String2 = " + STR2);
        Log.i("@modi@","Boolean = " + BOOL);
    }

}