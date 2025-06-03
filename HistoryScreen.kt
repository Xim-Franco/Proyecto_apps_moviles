package com.example.proyecto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto.data.HistoryRepository

@Composable
fun HistoryScreen(navController: NavController) {
    val historyItems = remember { HistoryRepository.getHistory() }
    var items by remember { mutableStateOf(historyItems) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Text("Historial de letras reconocidas", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn {
                    items(items) { item ->
                        Text(text = item, style = MaterialTheme.typography.bodyLarge)
                        Divider()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    HistoryRepository.clearHistory()
                    items = emptyList()
                }) {
                    Text("Borrar Historial")
                }
            }
        }
    )
}
