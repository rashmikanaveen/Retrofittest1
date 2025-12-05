package com.example.retrofit_test1.data.api

import com.example.retrofit_test1.data.models.StockSymbol
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("stock/symbol")
    suspend fun getStockSymbols(
        @Query("exchange")exchange: String,
        @Query("token")token: String
    ): List<StockSymbol>
}