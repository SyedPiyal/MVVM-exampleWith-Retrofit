package com.piyal.mvvmretrofit.api

import com.piyal.mvvmretrofit.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int) : Response<QuoteList>

    //baseUrl + "/quotes" + ?page=1
}