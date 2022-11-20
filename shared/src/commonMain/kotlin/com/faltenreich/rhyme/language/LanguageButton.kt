
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import com.faltenreich.rhyme.language.LanguagePicker
import com.faltenreich.rhyme.language.LanguageState
import com.faltenreich.rhyme.language.LanguageViewModel
import com.faltenreich.rhyme.shared.di.inject

@Composable
fun LanguageButton(viewModel: LanguageViewModel = inject()) {
    val state = viewModel.uiState.collectAsState().value
    val currentLanguage = (state as? LanguageState.Loaded)?.currentLanguage ?: return
    Box {
        var expanded by remember { mutableStateOf(false) }
        TextButton(onClick = { expanded = true }) { Text(currentLanguage.code.uppercase()) }
        LanguagePicker(expanded, onDismissRequest = { expanded = false })
    }
}