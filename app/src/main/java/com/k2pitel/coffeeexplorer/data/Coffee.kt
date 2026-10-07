package com.k2pitel.coffeeexplorer.data

data class Coffee(
    val id: Int,
    val name: String,
    val category: String,
    val shortDescription: String,
    val description: String,
    val origin: String,
    val ingredients: List<String>,
    val preparation: String,
    val caffeineLevel: String
)
