package com.example.kotlindemo.Classes.Activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.databinding.ActivityDatepickerBinding
import android.text.format.DateFormat
import java.sql.Timestamp
import java.util.Calendar

class DatePicker : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityDatepickerBinding
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatepickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//set current time
        val currentTimeMillis = System.currentTimeMillis()
        val timeStamp = Timestamp(currentTimeMillis)

        binding.tvTime.setText("$timeStamp")

        binding.btnPick.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(this@DatePicker, this@DatePicker, year, month, day)
            datePickerDialog.show()
        }

        binding.textView.setText("Day: $day  Month: $month  Year: $year")

    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(
            this@DatePicker, this@DatePicker, hour, minute, DateFormat.is24HourFormat(this)
        )
        timePickerDialog.show()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        myHour = hourOfDay
        myMinute = minute
        binding.textView.text =
            "Year: $myYear \n Month: $myMonth \n Day: $myDay \n Hour: $myHour \n Minute: $myMinute"
    }
}