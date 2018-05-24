package com.example.supisara.coinconverter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList


class CountryAdapter(context: Context, countryList: ArrayList<CountryItem>) : ArrayAdapter<CountryItem>(context, 0, countryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.country_spinner_row, parent, false
            )
        }

        val imageViewFlag = convertView!!.findViewById<ImageView>(R.id.image_view_flag)
        val textViewName = convertView.findViewById<TextView>(R.id.text_view_name)

        val currentItem = getItem(position)

        if (currentItem != null) {
            imageViewFlag.setImageResource(currentItem.flagImage)
            textViewName.text = currentItem.countryName
        }

        return convertView
    }
}