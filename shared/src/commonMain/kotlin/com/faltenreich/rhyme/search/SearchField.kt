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
import com.faltenreich.rhyme.language.LanguagePicker
import com.faltenreich.rhyme.shared.di.inject
import com.faltenreich.rhyme.shared.localization.Localization

@Composable
fun SearchField(query: String, onValueChange: (String) -> Unit) {
    val localization = inject<Localization>()
    TextField(query,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(localization.getString(MR.strings.search_placeholder)) },
        trailingIcon = {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = localization.getString(MR.strings.clear_input),
                    modifier = Modifier.clickable { onValueChange("") },
                )
                Box {
                    var expanded by remember { mutableStateOf(false) }
                    Icon(
                        Icons.Default.Info,
                        contentDescription = localization.getString(MR.strings.clear_input),
                        modifier = Modifier.clickable { expanded = true },
                    )
                    LanguagePicker(expanded, onDismissRequest = { expanded = false })
                }
            }
        }
    )
}