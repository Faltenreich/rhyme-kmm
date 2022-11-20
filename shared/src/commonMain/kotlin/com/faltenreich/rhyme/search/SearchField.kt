package com.faltenreich.rhyme.search

import LanguageButton
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faltenreich.rhyme.MR
import com.faltenreich.rhyme.shared.di.inject
import com.faltenreich.rhyme.shared.localization.Localization

@Composable
fun SearchField(
    query: String,
    onValueChange: (String) -> Unit,
    localization: Localization = inject(),
) {
    TextField(query,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(localization.getString(MR.strings.search_placeholder)) },
        leadingIcon = { LanguageButton() },
        trailingIcon = { ClearButton(onClick = { onValueChange("") }) },
    )
}