package com.example.supisara.coinconverter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by supisara on 5/24/2018 AD.
 */

class ConvertNewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.convertnew_activity)
    }

    fun convertButtonClicked(view: View) {
        val inputEditText = findViewById<View>(R.id.inputEditText) as EditText
        inputEditText.inputType = InputType.TYPE_CLASS_NUMBER
        val inputText = inputEditText.text.toString()

        val rateEditText = findViewById<View>(R.id.rateEditText) as EditText
        rateEditText.inputType = InputType.TYPE_CLASS_NUMBER
        val rateText = rateEditText.text.toString()

        val outputTextView = findViewById<View>(R.id.outputTextView) as TextView
        outputTextView.inputType = InputType.TYPE_CLASS_NUMBER

        if(inputText != null && rateText != null && inputText != "-" && rateText != "-" && inputText != "" && rateText != ""){
            var input = 0.0
            var rate = 0.0
            input = Integer.parseInt(inputEditText.text.toString()).toDouble()
            rate = Integer.parseInt(inputEditText.text.toString()).toDouble()
            outputTextView.text = convert(input, rate).toString()
        } else{
            outputTextView.text = "Please enter a number"

        }
    }

    fun convert(number: Double, convertUnit: Double): Double {
        return number * convertUnit
    }

    fun clearButtonClicked(view: View) {
        val inputEditText = findViewById<View>(R.id.inputEditText) as EditText
        inputEditText.inputType = InputType.TYPE_CLASS_NUMBER
        inputEditText.setText("")

        val outputTextView = findViewById<View>(R.id.outputTextView) as TextView
        outputTextView.inputType = InputType.TYPE_CLASS_NUMBER
        outputTextView.text = ""

        val rateEditText = findViewById<View>(R.id.rateEditText) as EditText
        rateEditText.inputType = InputType.TYPE_CLASS_NUMBER
        rateEditText.setText("")
    }
}
