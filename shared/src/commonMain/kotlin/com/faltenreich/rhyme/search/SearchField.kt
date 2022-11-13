package com.faltenreich.rhyme.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faltenreich.rhyme.MR
import com.faltenreich.rhyme.getString

@Composable
fun SearchField(query: String, onValueChange: (String) -> Unit) {
    TextField(query,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(getString(MR.strings.search_placeholder)) },
        trailingIcon = {
            Icon(
                Icons.Default.Clear,
                contentDescription = getString(MR.strings.clear_input),
                modifier = Modifier.clickable { onValueChange("") },
            )
        }
    )
}