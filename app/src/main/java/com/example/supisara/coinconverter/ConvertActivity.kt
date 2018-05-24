package com.example.supisara.coinconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

import java.util.ArrayList
import java.util.regex.Pattern

import android.text.InputType

class ConvertActivity : AppCompatActivity() {
    private var mCountryList: ArrayList<CountryItem>? = null
    private var mAdapter: CountryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.convert_activity)

        initList()

        val spinnerCountries = findViewById<Spinner>(R.id.spinner_countries)
        val spinnerCountries2 = findViewById<Spinner>(R.id.spinner_countries2)

        mAdapter = CountryAdapter(this, this!!.mCountryList!!)
        spinnerCountries.adapter = mAdapter
        spinnerCountries2.adapter = mAdapter


        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val clickedItem = parent.getItemAtPosition(position) as CountryItem
                val clickedCountryName = clickedItem.countryName
                Toast.makeText(this@ConvertActivity, clickedCountryName + " selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        spinnerCountries2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val clickedItem = parent.getItemAtPosition(position) as CountryItem
                val clickedCountryName = clickedItem.countryName
                Toast.makeText(this@ConvertActivity, clickedCountryName + " selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun initList() {
        mCountryList = ArrayList()
        mCountryList!!.add(CountryItem("USD", R.drawable.usd))
        mCountryList!!.add(CountryItem("INR", R.drawable.india))
        mCountryList!!.add(CountryItem("THB", R.drawable.thai))
        mCountryList!!.add(CountryItem("JPY", R.drawable.japan))
        mCountryList!!.add(CountryItem("HKD", R.drawable.hk))
        mCountryList!!.add(CountryItem("CHF", R.drawable.swiz))
        mCountryList!!.add(CountryItem("GBP", R.drawable.eng))
        mCountryList!!.add(CountryItem("EUR", R.drawable.eu))

    }

    fun convertButtonClicked(view: View) {
        val spinnerFrom = findViewById<View>(R.id.spinner_countries) as Spinner
        val spinnerFrom_data = spinnerFrom.selectedItem.toString()

        val spinnerTo = findViewById<View>(R.id.spinner_countries2) as Spinner
        val spinnerTo_data = spinnerTo.selectedItem.toString()

        val inputEditText = findViewById<View>(R.id.inputEditText) as EditText
        inputEditText.inputType = InputType.TYPE_CLASS_NUMBER
        val inputText = inputEditText.text.toString()

        val outputTextView = findViewById<View>(R.id.outputTextView) as TextView
        outputTextView.inputType = InputType.TYPE_CLASS_NUMBER

        if(inputText != null && inputText != "-" && inputText != ""){
            var input = Integer.parseInt(inputEditText.text.toString()).toDouble()

            var usd = 0.0
            var want = 0.0

            if (spinnerFrom_data == "USD") {
                usd = input
            } else if (spinnerFrom_data == "INR") {
                usd = convert(input, 0.0146)

            } else if (spinnerFrom_data == "THB") {
                usd = convert(input, 0.0311)
                //change thai to usd
            } else if (spinnerFrom_data == "JPY") {
                usd = convert(input, 0.0091)

            } else if (spinnerFrom_data == "HKD") {
                usd = convert(input, 0.1274)

            } else if (spinnerFrom_data == "CHF") {
                usd = convert(input, 1.0036)

            } else if (spinnerFrom_data == "GBP") {
                usd = convert(input, 1.3324)

            } else if (spinnerFrom_data == "EUR") {
                usd = convert(input, 1.1685)

            }

            if (spinnerTo_data == "USD") {
                want = usd
            } else if (spinnerTo_data == "INR") {
                want = convert(usd, 68.3850)

            } else if (spinnerTo_data == "THB") {
                want = convert(usd, 32.14)
                //change usd to thai
            } else if (spinnerTo_data == "JPY") {
                want = convert(usd, 110.2455)

            } else if (spinnerTo_data == "HKD") {
                want = convert(usd, 7.8499)

            } else if (spinnerTo_data == "CHF") {
                want = convert(usd, 0.9964)

            } else if (spinnerTo_data == "GBP") {
                want = convert(usd, 0.7505)

            } else if (spinnerTo_data == "EUR") {
                want = convert(usd, 0.8558)
            }

            if (spinnerFrom_data == spinnerTo_data) want = input

            outputTextView.text = want.toString()
        } else {
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

    }

}