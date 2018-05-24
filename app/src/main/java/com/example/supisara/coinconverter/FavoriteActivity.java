package com.example.supisara.coinconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;

//    public ArrayList<String> favoriteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_activity);

        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner_countries);

        mAdapter = new CountryAdapter(this, mCountryList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getCountryName();
                Toast.makeText(FavoriteActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        ListAdapter adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1, favoriteList);
//        ListView favoriteListView = (ListView) findViewById(R.id.favoriteListView);
//        favoriteListView.setAdapter(adapter);

//        ListView favoriteListView = (ListView) findViewById(R.id.favoriteListView);
//        favoriteListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteList));

    }

    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new CountryItem("USD", R.drawable.usd));
        mCountryList.add(new CountryItem("INR", R.drawable.india));
        mCountryList.add(new CountryItem("THB", R.drawable.thai));
        mCountryList.add(new CountryItem("JPY", R.drawable.japan));
        mCountryList.add(new CountryItem("HKD", R.drawable.hk));
        mCountryList.add(new CountryItem("CHF", R.drawable.swiz));
        mCountryList.add(new CountryItem("GBP", R.drawable.eng));
        mCountryList.add(new CountryItem("EUR", R.drawable.eu));

    }

    public void chooseButtonClicked(View view){
        final Spinner spinnerFrom = (Spinner) findViewById(R.id.spinner_countries);
        String spinnerFrom_data = spinnerFrom.getSelectedItem().toString();

//        favoriteList.add(spinnerFrom_data);

    }



}
