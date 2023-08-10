package com.piyal.mvvmretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyal.mvvmretrofit.models.QuoteList
import com.piyal.mvvmretrofit.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val repository: QuotesRepository):ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }
    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}