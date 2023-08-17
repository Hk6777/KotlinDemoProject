import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.JetPackComposed.ui.theme.Shapes
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_surfaceTint

@Preview
@Composable
fun MatrialDesignDemos() {
    var showMessage by remember { mutableStateOf(false) }
    Button(
        onClick = {
            showMessage = true
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(md_theme_light_surfaceTint),
        shape = Shapes.extraSmall

    ) {
        Text("Alert DialogBox")
    }
    if (showMessage) {
        AlertDialogComponent(onDismiss = { showMessage = false })
    }


}

@Composable

fun AlertDialogComponent(onDismiss: () -> Unit) {


    AlertDialog(
        onDismissRequest = {

            onDismiss()
        },
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        title = {
            Text(text = "Title")
        },
        text = {
            Text(
                "This area typically contains the supportive text " +
                        "which presents the details regarding the Dialog's purpose."
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Dismiss")
            }
        }
    )

}

