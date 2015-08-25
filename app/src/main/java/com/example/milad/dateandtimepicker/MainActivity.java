package com.example.milad.dateandtimepicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;


public class MainActivity extends ActionBarActivity implements DatePickerDialog.OnDateSetListener
        , TimePickerDialog.OnTimeSetListener{

    PersianCalendar mPersianCalendar;
    DatePickerDialog mDatePickerDialog;
    TimePickerDialog mTimePickerDialog;

    Button Date, Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date = (Button) findViewById(R.id.date);
        Time = (Button) findViewById(R.id.time);
        mPersianCalendar = new PersianCalendar();
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog = DatePickerDialog.newInstance(MainActivity.this
                        ,mPersianCalendar.getPersianYear(),
                        mPersianCalendar.getPersianMonth(),
                        mPersianCalendar.getPersianDay());
                mDatePickerDialog.show(getFragmentManager(),"Datepickerdialog");
            }
        });

        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimePickerDialog = TimePickerDialog.newInstance(MainActivity.this,
                        mPersianCalendar.getTime().getHours(),
                        mPersianCalendar.getTime().getMinutes(),
                        false);
                mTimePickerDialog.show(getFragmentManager(),"Timepickerdialog");
            }
        });


    }



    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int monthOfYear, int dayOfMonth) {
        String date = "You picked the following date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;

        Toast.makeText(getApplicationContext(),date,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(RadialPickerLayout radialPickerLayout, int hourOfDay, int minute) {
        String time = "You picked the following time: "+hourOfDay+"h"+minute;

        Toast.makeText(getApplicationContext(),time,Toast.LENGTH_LONG).show();
    }
}
