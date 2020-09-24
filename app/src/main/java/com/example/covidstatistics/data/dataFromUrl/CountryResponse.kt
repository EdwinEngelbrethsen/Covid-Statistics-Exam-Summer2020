package com.example.covidstatistics.data.dataFromUrl


import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("Countries")
    val countries: List<Country>,
    @SerializedName("Global")
    val global: Global
)