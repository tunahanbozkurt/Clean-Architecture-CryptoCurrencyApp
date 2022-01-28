package com.example.cryptocurrencycleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptocurrencycleanarchitecture.presentation.CryptoListViewModel
import com.example.cryptocurrencycleanarchitecture.presentation.components.CoinListItem
import com.example.cryptocurrencycleanarchitecture.ui.theme.CryptoCurrencyCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptoCurrencyCleanArchitectureTheme {

                CoinListLayout()

            
            }
        }
    }
}

@Composable
fun CoinListLayout(viewModel:CryptoListViewModel = viewModel()){
    val state = viewModel.state.value
    Box(Modifier.fillMaxSize()) {

        LazyColumn {
            items(items = state.coins){ coin ->
                CoinListItem(model = coin)
            }
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }

}






