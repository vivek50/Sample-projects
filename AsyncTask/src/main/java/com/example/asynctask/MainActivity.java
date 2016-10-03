package com.example.asynctask;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               new MyTask().execute(new Integer[]{1,100});
            }
        });
    }

    private void IncrementCounter(String text) {

        ((TextView)findViewById(R.id.textcounter)).setText(text);

    }

    /*private void StartCounter() {

        for(int i = 1; i<=100 ; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IncrementCounter(" "+i);
        }

    }

    private void StartWorkCounter() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                StartCounter();
            }
        }).start();

    }*/

    private class MyTask extends AsyncTask<Integer/*params*/,Integer/*progress*/,Boolean/*Result*/>  {


//        private ProgressDialog dialog;

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            dialog = ProgressDialog.show(MainActivity.this,"Progress","Progressing....");
//            UI Thread

        }

        @Override
        protected Boolean/*Result*/ doInBackground(Integer... params/*params*/) {

            int i;

            for (i = params[0]; i < params[1]; i++) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(/*progress*/i);
            }
            //Worker thread
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

//            dialog.dismiss();
            builder.setIcon(R.drawable.alert_icon);
            builder.setTitle(getResources().getString(R.string.alertTitle));
            builder.setMessage(getResources().getString(R.string.alertMessage));
            builder.setPositiveButton(R.string.AlertPositive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    new MyTask().execute(new Integer[]{1,100});

                }
            });
            builder.setNegativeButton(R.string.AlertNegative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    System.exit(0);

                }
            });
            builder.show();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            IncrementCounter(""+values[0]);
            //UI thread
        }
    }
}
