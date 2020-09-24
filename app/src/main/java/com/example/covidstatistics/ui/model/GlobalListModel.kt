package com.example.covidstatistics.ui.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.covidstatistics.data.repo.CountriesRepository

class GlobalListModel(private val repository: CountriesRepository) : ViewModel() {
    val listAllGlobalData = liveData {
        Log.i("Global", "Requesting data from global repo")
        emit(repository.getAllGlobalInformation())
    }

}
