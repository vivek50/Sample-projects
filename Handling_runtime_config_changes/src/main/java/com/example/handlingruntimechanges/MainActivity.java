package com.example.handlingruntimechanges;

//There's a three method to handle configuration changes...

// 1). In a First Method, In Manifest file you can add configChanges in activity tag and set values...

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final java.lang.String KEY_DATA = "Data";

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.Infotext);

        // 2). It's Second method to handle config changes by creating a condition...

        /*if(savedInstanceState != null)
            textview.setText(savedInstanceState.getString(KEY_DATA));*/

        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textview.setText("Data Handle at Runtime Changes");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(MainActivity.this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }
    
    /*  3). It's Third Method to handle config changes by save and restore data
          by onSaveInstanceState and onRestoreInstanceState Method...*/

/*    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_DATA,textview.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

         if(savedInstanceState != null)
            textview.setText(savedInstanceState.getString(KEY_DATA));

    }*/
}
