package com.piyal.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.piyal.mvvmretrofit.api.QuoteService
import com.piyal.mvvmretrofit.api.RetrofitHelper
import com.piyal.mvvmretrofit.repository.QuotesRepository
import com.piyal.mvvmretrofit.viewmodel.MainViewModel
import com.piyal.mvvmretrofit.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("DATA",it.results.toString())
        })
    }
}