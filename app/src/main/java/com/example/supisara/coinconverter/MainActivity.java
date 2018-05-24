package com.example.supisara.coinconverter;

import android.content.Intent;
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
import android.text.InputType;

public class MainActivity extends AppCompatActivity {

    public static final int INPUT_REQUEST_CODE = 100;
    public static final int INPUT_REQUEST_CODE2 = 200;
    public static final int INPUT_REQUEST_CODE3 = 300;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void convertPageButtonClicked(View view){
        Intent intent = new Intent(this, ConvertActivity.class);
        startActivityForResult(intent, INPUT_REQUEST_CODE);
    }

    public void favoritePageButtonClicked(View view){
        Intent intent = new Intent(this, FavoriteActivity.class);
        startActivityForResult(intent, INPUT_REQUEST_CODE2);
    }

    public void convertNewPageButtonClicked(View view){
        Intent intent = new Intent(this, ConvertNewActivity.class);
        startActivityForResult(intent, INPUT_REQUEST_CODE3);
    }

}
