package com.faltenreich.rhyme.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faltenreich.rhyme.MR
import com.faltenreich.rhyme.language.LanguageChooser
import com.faltenreich.rhyme.shared.localization.getString

@Composable
fun SearchField(query: String, onValueChange: (String) -> Unit) {
    TextField(query,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(getString(MR.strings.search_placeholder)) },
        trailingIcon = {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = getString(MR.strings.clear_input),
                    modifier = Modifier.clickable { onValueChange("") },
                )
                Box {
                    var expanded by remember { mutableStateOf(false) }
                    Icon(
                        Icons.Default.Info,
                        contentDescription = getString(MR.strings.clear_input),
                        modifier = Modifier.clickable { expanded = true },
                    )
                    LanguageChooser(expanded, onDismissRequest = { expanded = false }, onLanguageSelected = {})
                }
            }
        }
    )
}