package com.example.covidstatistics.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidstatistics.data.repo.CountriesRepository
import com.example.covidstatistics.ui.model.GlobalListModel

@Suppress("UNCHECKED_CAST")
class GlobalFactory(private val globalRepo: CountriesRepository) :
        ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) : T {
        return GlobalListModel(globalRepo) as T
    }
}