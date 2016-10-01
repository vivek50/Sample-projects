package com.example.notifications;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends AppCompatDialogFragment {


    public MyDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Dialog dialog = null;

        if(getTag().equals(DialogActivity.TAG_ALERT))dialog = Alert();
        else if (getTag().equals(DialogActivity.TAG_DATE))dialog = DatePicker();
        else if (getTag().equals(DialogActivity.TAG_TIME))dialog = TimePicker();
        else if (getTag().equals(DialogActivity.TAG_PROGRESS))dialog = Progress();
        else dialog = Custom();

        return dialog;
    }

    private Dialog Alert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.AlertTitle));
        builder.setMessage(getResources().getString(R.string.AlertMessage));
        builder.setIcon(R.drawable.alert_icon);
        builder.setPositiveButton(R.string.AlertPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Message("Ok");

            }
        });
        builder.setNegativeButton(R.string.AlertNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Message("Cancel");

            }
        });

        return builder.create();
    }

    private Dialog DatePicker() {

        DatePickerDialog datepicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                StringBuilder builder = new StringBuilder();
                builder.append("").append(month)
                        .append("-").append(dayOfMonth)
                        .append("-").append(year);

                Message(builder.toString());

            }
        },2016,9,28);

        return datepicker;
    }

    private Dialog TimePicker() {

        TimePickerDialog timepicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                StringBuilder builder = new StringBuilder();
                builder.append("").append(hourOfDay)
                        .append(":").append(minute);

                Message(builder.toString());

            }
        },02,30,false);

        return timepicker;
    }

    private Dialog Progress() {

        ProgressDialog progress = new ProgressDialog(getActivity());
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setTitle(getResources().getString(R.string.progressTitle));
        progress.setMessage(getResources().getString(R.string.progressMessage));

        return progress;
    }

    private Dialog Custom() {

        View dialogview = getActivity().getLayoutInflater().inflate(R.layout.cutom_dialog,null,false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(dialogview);

        return builder.create();
    }

    private void Message(String message) {

        Toast.makeText(getActivity(), message , Toast.LENGTH_SHORT).show();

    }

}
