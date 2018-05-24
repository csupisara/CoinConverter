package com.example.supisara.coinconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by supisara on 5/24/2018 AD.
 */

public class ConvertNewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertnew_activity);
    }

    public void convertButtonClicked(View view){
        EditText inputEditText = (EditText) findViewById(R.id.inputEditText);
        inputEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        String inputText = inputEditText.getText().toString();

        EditText rateEditText = (EditText) findViewById(R.id.rateEditText);
        rateEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        String rateText = rateEditText.getText().toString();

        double input = 0, rate = 0;

        if(inputText.matches("[0-9]+(\\.[0-9]+)?") && rateText.matches("[0-9]+(\\.[0-9]+)?")) {
            input = Integer.parseInt(inputEditText.getText().toString());
            rate = Integer.parseInt(inputEditText.getText().toString());
        }

        //print the converted result
        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        outputTextView.setInputType(InputType.TYPE_CLASS_NUMBER);

        outputTextView.setText(String.valueOf(convert(input, rate)));

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

        EditText rateEditText = (EditText) findViewById(R.id.rateEditText);
        rateEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        rateEditText.setText("");
    }
}
