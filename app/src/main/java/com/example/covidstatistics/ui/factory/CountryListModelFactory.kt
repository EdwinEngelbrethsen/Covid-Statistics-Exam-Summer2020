package com.example.covidstatistics.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidstatistics.data.repo.CountriesRepository
import com.example.covidstatistics.ui.model.CountryListModel

@Suppress("UNCHECKED_CAST")
class CountryListModelFactory(private val repo: CountriesRepository) :
        ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountryListModel(repo) as T
    }
}
