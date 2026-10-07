package com.k2pitel.coffeeexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.k2pitel.coffeeexplorer.data.Coffee
import com.k2pitel.coffeeexplorer.data.CoffeeRepository
import com.k2pitel.coffeeexplorer.ui.theme.CoffeeExplorerTheme

class CoffeeListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeExplorerTheme {
                CoffeeListScreen(
                    coffees = CoffeeRepository.coffees,
                    onBack = {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    },
                    onCoffeeSelected = { coffeeId ->
                        val intent = Intent(this, CoffeeDetailsActivity::class.java).apply {
                            putExtra(CoffeeDetailsActivity.EXTRA_COFFEE_ID, coffeeId)
                        }
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
private fun CoffeeListScreen(
    coffees: List<Coffee>,
    onBack: () -> Unit,
    onCoffeeSelected: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Coffee Collection") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(coffees) { coffee ->
                CoffeeListItem(coffee = coffee, onClick = { onCoffeeSelected(coffee.id) })
            }
        }
    }
}

@Composable
private fun CoffeeListItem(coffee: Coffee, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = coffee.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = coffee.category,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Divider()
            Text(
                text = coffee.shortDescription,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
