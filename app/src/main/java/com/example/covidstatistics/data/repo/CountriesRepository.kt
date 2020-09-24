package com.example.covidstatistics.data.repo

import com.example.covidstatistics.data.dataFromUrl.Country
import com.example.covidstatistics.data.api.ApiService
import com.example.covidstatistics.data.api.SafeApiRequest
import com.example.covidstatistics.data.dataFromUrl.CountryResponse
import com.example.covidstatistics.data.dataFromUrl.Global

/*class CountriesRepository(private val api: ApiService) : SafeApiRequest() {

    suspend fun fetchAllCountries(): List<Country> {
        i("Country", "yes")
        val response = apiRequest { api.fetchAllCountries() }
        if (response != null) {
            i("Country", "Persisted ${response.countries}")
            response.countries
        }
        return mutableListOf()
    }
} */

class CountriesRepository(private val api: ApiService): SafeApiRequest() {
    suspend fun getAllCountries() : List<Country> {
        val allCountriesResponse = apiRequest { api.fetchAllCountries() }
        return allCountriesResponse?.countries?.sortedByDescending { it.totalConfirmed }!!
     }

    suspend fun getAllGlobalInformation() : Global {
        val allGlobalResponse =  apiRequest {api.fetchAllCountries()}
        return allGlobalResponse!!.global
    }
}
