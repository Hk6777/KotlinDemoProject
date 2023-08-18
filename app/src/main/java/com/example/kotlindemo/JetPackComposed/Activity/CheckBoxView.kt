package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Checkbox
import androidx.wear.compose.material.CheckboxDefaults
import androidx.wear.compose.material.Text

data class ListItem(val id: Int, val text: String)

@Preview
@Composable
fun CheckBoxView() {
    val items = (1..10).map { ListItem(id = it, text = "Item $it") }
    val selectedItems = remember { mutableStateListOf<Int>() }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedItems.contains(item.id),
                    onCheckedChange = {
                        if (it) {
                            selectedItems.add(item.id)
                        } else {
                            selectedItems.remove(item.id)
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedBoxColor = MaterialTheme.colorScheme.primary, // Color when checked
                        uncheckedBoxColor = MaterialTheme.colorScheme.error, // Color when unchecked
                        checkedCheckmarkColor = MaterialTheme.colorScheme.primary // Color of the checkmark
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.text,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "Selected Items: ${selectedItems.joinToString()}",
        color = MaterialTheme.colorScheme.primary
    )

}