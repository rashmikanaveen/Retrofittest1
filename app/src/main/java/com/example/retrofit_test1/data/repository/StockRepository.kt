package com.example.retrofit_test1.data.repository

import com.example.retrofit_test1.BuildConfig
import com.example.retrofit_test1.data.api.RetrifitInstance
import com.example.retrofit_test1.data.models.StockSymbol
import retrofit2.Retrofit

class StockRepository {
    private val api = RetrifitInstance.apiService
    val apiKey= BuildConfig.FINNHUB_API_KEY
    suspend fun getStocks(): List<StockSymbol>{
        return api.getStockSymbols(
            exchange = "US",
            token = apiKey
        )

    }
}