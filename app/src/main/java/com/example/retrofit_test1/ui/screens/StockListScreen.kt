package com.example.retrofit_test1.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofit_test1.data.models.StockSymbol
import com.example.retrofit_test1.ui.viewmodel.StockViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import com.example.retrofit_test1.data.models.UiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockListScreen(viewModel: StockViewModel = viewModel()) {

    // Observe the UiState instead of just the list
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Market Watch") }) }
    ) { paddingValues ->

        // Switch based on the state
        when (val currentState = state) {

            is UiState.Loading -> {
                // SHOW LOADING SPINNER
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success -> {
                // SHOW DATA LIST
                LazyColumn(
                    contentPadding = paddingValues,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(currentState.stocks) { stock ->
                        StockItem(stock = stock)
                    }
                }
            }

            is UiState.Error -> {
                // SHOW ERROR MESSAGE
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        text = currentState.message,
                        color = androidx.compose.material3.MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}


@Composable
fun StockItem(stock: StockSymbol) { // <--- Ensure 'StockSymbol' matches the type inside 'stockList'
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Use specific fields to be safe
            Text(text = "Symbol: ${stock.displaySymbol}")
            Text(text = "Description:${stock.description}")
            Text(text = "mic:${stock.mic}")
        }
    }
}