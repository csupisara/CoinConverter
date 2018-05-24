package com.example.supisara.coinconverter

import android.content.Intent
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
import android.text.InputType

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun convertPageButtonClicked(view: View) {
        val intent = Intent(this, ConvertActivity::class.java)

        startActivityForResult(intent, INPUT_REQUEST_CODE)
    }

//    fun favoritePageButtonClicked(view: View) {
//        val intent = Intent(this, FavoriteActivity::class.java)
//        startActivityForResult(intent, INPUT_REQUEST_CODE2)
//    }

    fun convertNewPageButtonClicked(view: View) {
        val intent = Intent(this, ConvertNewActivity::class.java)
        startActivityForResult(intent, INPUT_REQUEST_CODE3)
    }

    companion object {

        val INPUT_REQUEST_CODE = 100
        val INPUT_REQUEST_CODE2 = 200
        val INPUT_REQUEST_CODE3 = 300
    }

}
