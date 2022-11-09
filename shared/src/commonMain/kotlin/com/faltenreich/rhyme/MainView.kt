package com.faltenreich.rhyme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainView(viewModel: MainViewModel = MainViewModel()) {
    MainTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                Text(Greeting().greeting())
                Text(viewModel.uiState.words.size.toString())
            }
        }
    }
}