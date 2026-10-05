package com.k2pitel.coffeeexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.k2pitel.coffeeexplorer.ui.theme.CoffeeExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeExplorerTheme {
                MainMenuScreen(
                    onOpenCollection = {
                        startActivity(Intent(this, CoffeeListActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
private fun MainMenuScreen(onOpenCollection: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Coffee Explorer") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Discover different coffee drinks and learn about their ingredients, origin and preparation.",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Menu",
                style = MaterialTheme.typography.titleMedium
            )

            Card(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = onOpenCollection,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Icon(Icons.Default.LocalCafe, contentDescription = null)
                    Text(text = " Coffee Collection")
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Icon(Icons.Default.Info, contentDescription = null)
                    Text(text = " About")
                }
            }
        }
    }
}
