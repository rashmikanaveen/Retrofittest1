package com.example.retrofit_test1.data.models

sealed interface UiState {
    object Loading : UiState
    data class Success(val stocks: List<StockSymbol>) : UiState
    data class Error(val message: String) : UiState
}