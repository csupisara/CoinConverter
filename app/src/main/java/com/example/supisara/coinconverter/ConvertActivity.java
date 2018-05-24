package com.example.supisara.coinconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

import android.text.InputType;

public class ConvertActivity extends AppCompatActivity {
    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_activity);

        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner_countries);
        Spinner spinnerCountries2 = findViewById(R.id.spinner_countries2);

        mAdapter = new CountryAdapter(this, mCountryList);
        spinnerCountries.setAdapter(mAdapter);
        spinnerCountries2.setAdapter(mAdapter);


        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getCountryName();
                Toast.makeText(ConvertActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCountries2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getCountryName();
                Toast.makeText(ConvertActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

    public void convertButtonClicked(View view){
        final Spinner spinnerFrom = (Spinner) findViewById(R.id.spinner_countries);
        String spinnerFrom_data = spinnerFrom.getSelectedItem().toString();

        final Spinner spinnerTo = (Spinner) findViewById(R.id.spinner_countries2);
        String spinnerTo_data = spinnerTo.getSelectedItem().toString();

        EditText inputEditText = (EditText) findViewById(R.id.inputEditText);
        inputEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        String inputText = inputEditText.getText().toString();
        double input = 0;

        if(inputText.matches("[0-9]+(\\.[0-9]+)?")){
            input = Integer.parseInt(inputEditText.getText().toString());
        }

        double usd = 0, want = 0;

        if(spinnerFrom_data.equals("USD")){
            usd = input;
        } else if(spinnerFrom_data.equals("INR")){
            usd = convert(input,0.0146);

        } else if(spinnerFrom_data.equals("THB")){
            usd = convert(input,0.0311);
            //change thai to usd
        } else if(spinnerFrom_data.equals("JPY")){
            usd = convert(input,0.0091);

        } else if(spinnerFrom_data.equals("HKD")){
            usd = convert(input,0.1274);

        } else if(spinnerFrom_data.equals("CHF")){
            usd = convert(input,1.0036);

        } else if(spinnerFrom_data.equals("GBP")){
            usd = convert(input,1.3324);

        } else if(spinnerFrom_data.equals("EUR")){
            usd = convert(input,1.1685);

        }

        if(spinnerTo_data.equals("USD")){
            want = usd;
        } else if(spinnerTo_data.equals("INR")){
            want = convert(usd, 68.3850);

        } else if(spinnerTo_data.equals("THB")){
            want = convert(usd, 32.14);
            //change usd to thai
        } else if(spinnerTo_data.equals("JPY")){
            want = convert(usd, 110.2455);

        } else if(spinnerTo_data.equals("HKD")){
            want = convert(usd, 7.8499);

        } else if(spinnerTo_data.equals("CHF")){
            want = convert(usd, 0.9964);

        } else if(spinnerTo_data.equals("GBP")){
            want = convert(usd, 0.7505);

        } else if(spinnerTo_data.equals("EUR")){
            want = convert(usd, 0.8558);
        }

        if(spinnerFrom_data.equals(spinnerTo_data)) want = input;

        //print the converted result
        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        outputTextView.setInputType(InputType.TYPE_CLASS_NUMBER);

        outputTextView.setText(String.valueOf(want));

    }

    public double convert(double number, double convertUnit){
        return number * convertUnit;
    }

    public void clearButtonClicked(View view){
        EditText inputEditText = (EditText) findViewById(R.id.inputEditText);
        inputEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputEditText.setText("");

        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        outputTextView.setInputType(InputType.TYPE_CLASS_NUMBER);
        outputTextView.setText("");

    }

}