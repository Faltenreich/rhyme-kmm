package com.faltenreich.rhyme.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.faltenreich.rhyme.MR
import com.faltenreich.rhyme.shared.di.inject
import com.faltenreich.rhyme.shared.localization.getString
import com.faltenreich.rhyme.word.WordView

@Composable
fun SearchView(viewModel: SearchViewModel = inject()) {
    val state = viewModel.state.collectAsState(Idle).value
    Column {
        SearchField(state.query, viewModel::onQueryChanged)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            when (state) {
                is Idle -> Text(getString(MR.strings.search_hint))
                is Loading -> CircularProgressIndicator()
                is Error -> Icon(Icons.Filled.Info, null)
                is Result -> LazyColumn {
                    items(state.words) { word ->
                        WordView(word)
                        Divider()
                    }
                }
            }
        }
    }
}