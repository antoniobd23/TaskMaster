package com.antonio.taskmaster.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskDialog(onDismiss: () -> Unit, onConfirm: (String) -> Unit) {
    // ... (El mismo código del AlertDialog que te di antes)
    var text by remember { mutableStateOf("") }
    var selectedPriority by remember { mutableStateOf(1) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nueva Tarea") },
        text = {
            Column{
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Título de la tarea") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Prioridad:")
                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    FilterChip(
                        selected = selectedPriority == 1,
                        onClick = { selectedPriority = 1 },
                        label = { Text("Alta") }
                    )
                    FilterChip(
                        selected = selectedPriority == 2,
                        onClick = { selectedPriority = 2 },
                        label = { Text("Media") }
                    )
                    FilterChip(
                        selected = selectedPriority == 3,
                        onClick = { selectedPriority = 3 },
                        label = { Text("Alta") }
                    )
                }
            }
        },
        confirmButton = {
            Button(onClick = { if (text.isNotBlank()) onConfirm(text) }) {
                Text("Añadir")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancelar") }
        }
    )
}