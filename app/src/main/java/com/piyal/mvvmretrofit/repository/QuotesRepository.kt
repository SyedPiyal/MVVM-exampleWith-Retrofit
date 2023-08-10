package com.piyal.mvvmretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.piyal.mvvmretrofit.api.QuoteService
import com.piyal.mvvmretrofit.models.QuoteList

class QuotesRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int){
        val result = quoteService.getQuotes(page)
        if (result?.body()!=null){
            quotesLiveData.postValue(result.body())
        }
    }
}