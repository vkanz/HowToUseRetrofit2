package ru.vkanz.howtouseretrofit2

import retrofit2.Call
import retrofit2.http.GET

interface QuoteService {
    @GET("api/1.0/?method=getQuote&format=json&lang=ru")
    fun getQuote(): Call<QuoteResponse>
}