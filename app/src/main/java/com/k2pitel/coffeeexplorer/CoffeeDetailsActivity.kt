package com.k2pitel.coffeeexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
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

class CoffeeDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coffeeId = intent.getIntExtra(EXTRA_COFFEE_ID, -1)
        val selectedCoffee = CoffeeRepository.getCoffeeById(coffeeId)

        setContent {
            CoffeeExplorerTheme {
                CoffeeDetailsScreen(
                    coffee = selectedCoffee,
                    onBack = {
                        startActivity(Intent(this, CoffeeListActivity::class.java))
                        finish()
                    }
                )
            }
        }
    }

    companion object {
        const val EXTRA_COFFEE_ID = "extra_coffee_id"
    }
}

@Composable
private fun CoffeeDetailsScreen(coffee: Coffee?, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(coffee?.name ?: "Coffee Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (coffee == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Coffee not found.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    CoffeeDetailCard("Category", coffee.category)
                }
                item {
                    CoffeeDetailCard("Description", coffee.description)
                }
                item {
                    CoffeeDetailCard("Origin", coffee.origin)
                }
                item {
                    CoffeeDetailCard("Preparation", coffee.preparation)
                }
                item {
                    CoffeeDetailCard("Caffeine Level", coffee.caffeineLevel)
                }
                item {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Ingredients",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            coffee.ingredients.forEach { ingredient ->
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Text(text = "• $ingredient", style = MaterialTheme.typography.bodyMedium)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CoffeeDetailCard(title: String, value: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(text = value, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
