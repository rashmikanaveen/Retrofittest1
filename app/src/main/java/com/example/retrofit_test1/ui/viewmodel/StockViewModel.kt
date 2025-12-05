package com.example.retrofit_test1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_test1.data.models.StockSymbol
import com.example.retrofit_test1.data.models.UiState
import com.example.retrofit_test1.data.repository.StockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StockViewModel: ViewModel() {
    private val repository = StockRepository()
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchStocks()
    }

    private fun fetchStocks(){

        viewModelScope.launch {
            try {
                // 2. Add Logging to see what happens in the background
                Log.d("StockViewModel", "Attempting to fetch data...")

                val result = repository.getStocks()

                Log.d("StockViewModel", "Success! Fetched ${result.size} items")
                Log.d("StockViewModel", "First item: ${result.firstOrNull()}")

                // 3. Update State to Success
                _uiState.value = UiState.Success(result)

            } catch (e: Exception) {
                // 4. Log the error (Check Logcat for this!)
                Log.e("StockViewModel", "Error fetching data", e)

                _uiState.value = UiState.Error("Failed to load: ${e.message}")
            }
        }
    }
}