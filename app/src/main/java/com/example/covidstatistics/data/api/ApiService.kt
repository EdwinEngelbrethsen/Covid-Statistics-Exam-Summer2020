package com.example.covidstatistics.data.api

import com.example.covidstatistics.data.dataFromUrl.CountryResponse
import com.example.covidstatistics.data.dataFromUrl.Global
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/summary")
    suspend fun fetchAllCountries(): Response<CountryResponse>


}