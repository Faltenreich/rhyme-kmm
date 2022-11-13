package com.faltenreich.rhyme.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.faltenreich.rhyme.MR
import com.faltenreich.rhyme.di.inject
import com.faltenreich.rhyme.getString
import com.faltenreich.rhyme.word.WordView

@Composable
fun SearchView(viewModel: SearchViewModel = inject()) {
    val state = viewModel.uiState.collectAsState(SearchViewState())
    Column {
        TextField(state.value.query,
            onValueChange = viewModel::search,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(getString(MR.strings.search_placeholder)) },
            trailingIcon = {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = getString(MR.strings.clear_input),
                    modifier = Modifier.clickable { viewModel.reset() },
                )
            }
        )
        LazyColumn {
            items(state.value.results) { word ->
                WordView(word)
                Divider()
            }
        }
    }
}