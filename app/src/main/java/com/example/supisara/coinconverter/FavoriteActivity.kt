package com.example.supisara.coinconverter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import java.util.ArrayList

class FavoriteActivity : AppCompatActivity() {
    private var mCountryList: ArrayList<CountryItem>? = null
    private var mAdapter: CountryAdapter? = null

    //    public ArrayList<String> favoriteList;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorite_activity)

        initList()

        val spinnerCountries = findViewById<Spinner>(R.id.spinner_countries)

        mAdapter = CountryAdapter(this, this!!.mCountryList!!)
        spinnerCountries.adapter = mAdapter

        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val clickedItem = parent.getItemAtPosition(position) as CountryItem
                val clickedCountryName = clickedItem.countryName
                Toast.makeText(this@FavoriteActivity, clickedCountryName + " selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        val items = ArrayList<String>()
        var adapter: ArrayAdapter<String>? = null

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
//        favoriteListView.adapter = adapter
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

    fun chooseButtonClicked(view: View) {
        val spinnerFrom = findViewById<View>(R.id.spinner_countries) as Spinner
        val spinnerFrom_data = spinnerFrom.selectedItem.toString()

        //        favoriteList.add(spinnerFrom_data);

    }


}
