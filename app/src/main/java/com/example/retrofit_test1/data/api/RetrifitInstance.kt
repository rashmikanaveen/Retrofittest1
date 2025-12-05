package com.example.retrofit_test1.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrifitInstance {
    private const val base_url="https://finnhub.io/api/v1/"
    val apiService: ApiService by lazy {
        Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}