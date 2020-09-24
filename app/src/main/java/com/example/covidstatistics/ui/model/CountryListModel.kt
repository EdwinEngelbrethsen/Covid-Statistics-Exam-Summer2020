package com.example.covidstatistics.ui.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.covidstatistics.data.repo.CountriesRepository

class CountryListModel(private val repository: CountriesRepository) : ViewModel() {
    val listAllCountries = liveData {
        Log.i("Country Model", "Requesting data from repo")
        emit(repository.getAllCountries())
    }
}