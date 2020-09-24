package com.example.covidstatistics.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidstatistics.R
import com.example.covidstatistics.data.dataFromUrl.Country
import com.example.covidstatistics.data.dataFromUrl.CountryResponse
import kotlinx.android.synthetic.main.country_row.view.*

class CountryAdapter(private val country: List<Country> ) :
        RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    // private var searchList: List<Country> = countries

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_row,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = country.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(country[position])

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindViewHolder(item: Country) {

            itemView.countryName.text = item.country
            itemView.confirmedCases.text = item.totalConfirmed.toString()
            Log.i("Country", "Persisted ${item.country}")
            
        }

    }

}
