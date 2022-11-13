package com.faltenreich.rhyme.language

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.faltenreich.rhyme.shared.view.DropDownMenu
import com.faltenreich.rhyme.shared.view.DropDownMenuItem

@Composable
fun LanguageChooser(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onLanguageSelected: (Language) -> Unit,
) {
    DropDownMenu(expanded, onDismissRequest) {
        Language.values().forEach { language ->
            DropDownMenuItem(
                text = { Text(language.title) },
                onClick = { onDismissRequest(); onLanguageSelected(language) },
            )
        }
    }
}