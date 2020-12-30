package com.dobcalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_main)
        /*This is implemented by android studio it self when we select the Basic Activity while creating the project.*/
        setSupportActionBar(toolbar)

        btnDatePicker.setOnClickListener {
            clickDatePicker(it)
            Toast.makeText(this@MainActivity,"Button works",Toast.LENGTH_LONG).show()
        }

    }

    fun clickDatePicker(view : View) {

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month =myCalender.get(Calendar.MONTH)
        val day =myCalender.get(Calendar.DAY_OF_MONTH)

       val dpd =  DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, selectedYear,selectedMonth , selectedDayOfMonth ->

           val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            tvSelectedDate.setText(selectedDate)

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate =sdf.parse(selectedDate)
         val selectedDateInMinutes = theDate.time / 60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes = currentDate!!.time / 60000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

        },
                year,
                month,
                day)
        dpd.datePicker.maxDate  =Date().time - 86400000
        dpd.show()

    }

}