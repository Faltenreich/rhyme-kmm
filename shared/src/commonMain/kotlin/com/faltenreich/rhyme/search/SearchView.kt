package com.faltenreich.rhyme.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun SearchView(viewModel: SearchViewModel = SearchViewModel) {
    val state = viewModel.uiState.collectAsState(SearchViewState())
    Column {
        TextField(state.value.query, onValueChange = viewModel::search)
    }
}