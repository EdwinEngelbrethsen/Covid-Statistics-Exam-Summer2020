
package com.example.covidstatistics.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidstatistics.ui.adapter.CountryAdapter
import com.example.covidstatistics.ui.model.CountryListModel
import com.example.covidstatistics.ui.factory.CountryListModelFactory
import com.example.covidstatistics.data.repo.CountriesRepository
import com.example.covidstatistics.R
import com.example.covidstatistics.data.api.ApiService
import com.example.covidstatistics.ui.factory.GlobalFactory
import com.example.covidstatistics.ui.model.GlobalListModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.global_content.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class CountryListActivity : AppCompatActivity() {

    private lateinit var adapter: CountryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.covid19api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)
        val repo = CountriesRepository(api)



        val viewModel by viewModels<CountryListModel> {
            CountryListModelFactory(
                repo
            )
        }
        viewModel.listAllCountries.observe(this, Observer { country ->
            recyclerView.also {
                adapter = CountryAdapter(country)
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this)
                invalidateOptionsMenu()
            }
        })

        val viewModelGlobal by viewModels<GlobalListModel> { GlobalFactory(repo) }
        viewModelGlobal.listAllGlobalData.observe(this, Observer { global ->

            global_total_number.text = global.totalConfirmed.toString()
            global_total_deaths.text = global.totalDeaths.toString()
            global_total_recovered.text = global.totalRecovered.toString()
            Log.i("Global", "Persisted ${global}")
        })

}


}