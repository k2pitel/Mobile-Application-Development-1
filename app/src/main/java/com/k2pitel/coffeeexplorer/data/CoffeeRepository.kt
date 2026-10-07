package com.k2pitel.coffeeexplorer.data

object CoffeeRepository {
    val coffees: List<Coffee> = listOf(
        Coffee(
            id = 1,
            name = "Espresso",
            category = "Hot Coffee",
            shortDescription = "Concentrated coffee served in a small shot.",
            description = "Espresso is a rich, concentrated coffee brewed by forcing hot water through finely ground coffee beans.",
            origin = "Italy",
            ingredients = listOf("Finely ground coffee", "Hot water"),
            preparation = "Extract under high pressure for about 25–30 seconds.",
            caffeineLevel = "High"
        ),
        Coffee(
            id = 2,
            name = "Americano",
            category = "Hot Coffee",
            shortDescription = "Espresso diluted with hot water.",
            description = "Americano keeps espresso flavor while offering a lighter body similar to drip coffee.",
            origin = "Italy / United States",
            ingredients = listOf("Espresso", "Hot water"),
            preparation = "Pour hot water over a shot of espresso.",
            caffeineLevel = "Medium to High"
        ),
        Coffee(
            id = 3,
            name = "Cappuccino",
            category = "Milk Coffee",
            shortDescription = "Balanced espresso, steamed milk, and foam.",
            description = "Cappuccino combines equal parts espresso, steamed milk, and milk foam for a creamy texture.",
            origin = "Italy",
            ingredients = listOf("Espresso", "Steamed milk", "Milk foam"),
            preparation = "Top espresso with steamed milk and thick foam.",
            caffeineLevel = "Medium"
        ),
        Coffee(
            id = 4,
            name = "Latte",
            category = "Milk Coffee",
            shortDescription = "Espresso with plenty of steamed milk.",
            description = "Latte is a smooth coffee drink with espresso and a larger amount of steamed milk.",
            origin = "Italy",
            ingredients = listOf("Espresso", "Steamed milk", "Light milk foam"),
            preparation = "Add steamed milk to espresso and finish with a light foam layer.",
            caffeineLevel = "Medium"
        ),
        Coffee(
            id = 5,
            name = "Mocha",
            category = "Flavored Coffee",
            shortDescription = "Chocolate-flavored latte.",
            description = "Mocha blends espresso, steamed milk, and chocolate for a sweet coffee dessert drink.",
            origin = "Yemen-inspired / Italy",
            ingredients = listOf("Espresso", "Steamed milk", "Chocolate syrup"),
            preparation = "Mix chocolate with espresso, add steamed milk, and stir well.",
            caffeineLevel = "Medium"
        ),
        Coffee(
            id = 6,
            name = "Flat White",
            category = "Milk Coffee",
            shortDescription = "Velvety milk with espresso and thin foam.",
            description = "Flat White features espresso with microfoam, creating a smooth and velvety texture.",
            origin = "Australia / New Zealand",
            ingredients = listOf("Espresso", "Steamed microfoam milk"),
            preparation = "Pour textured microfoam milk over espresso.",
            caffeineLevel = "Medium to High"
        ),
        Coffee(
            id = 7,
            name = "Cold Brew",
            category = "Cold Coffee",
            shortDescription = "Coffee brewed slowly with cold water.",
            description = "Cold Brew is steeped for many hours in cold water, producing a smooth and less acidic drink.",
            origin = "Modern global trend",
            ingredients = listOf("Coarse coffee grounds", "Cold water"),
            preparation = "Steep grounds in cold water for 12–18 hours, then filter.",
            caffeineLevel = "High"
        ),
        Coffee(
            id = 8,
            name = "Macchiato",
            category = "Hot Coffee",
            shortDescription = "Espresso marked with milk foam.",
            description = "Traditional Macchiato is an espresso with a small amount of milk foam.",
            origin = "Italy",
            ingredients = listOf("Espresso", "Milk foam"),
            preparation = "Top espresso with a spoonful of milk foam.",
            caffeineLevel = "High"
        )
    )

    fun getCoffeeById(id: Int): Coffee? = coffees.find { it.id == id }
}
