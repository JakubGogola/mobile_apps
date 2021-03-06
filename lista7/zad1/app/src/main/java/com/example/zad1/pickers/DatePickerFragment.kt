package com.example.zad1.pickers

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import android.widget.EditText
import com.example.zad1.AddTaskActivity
import com.example.zad1.R
import com.example.zad1.containers.Date
import java.util.*

@SuppressLint("ValidFragment")
class DatePickerFragment(private val addTaskActivity: AddTaskActivity) :
    DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, year, month, day)
    }

    @SuppressLint("SetTextI18n")
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        addTaskActivity.date = Date(dayOfMonth, month + 1, year)
        addTaskActivity.findViewById<EditText>(R.id.taskDate).setText(addTaskActivity.date.toString())
    }
}