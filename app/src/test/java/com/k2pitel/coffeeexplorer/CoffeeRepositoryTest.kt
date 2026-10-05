package com.k2pitel.coffeeexplorer

import com.k2pitel.coffeeexplorer.data.CoffeeRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class CoffeeRepositoryTest {

    @Test
    fun getCoffeeById_returnsCoffee_whenIdExists() {
        val coffee = CoffeeRepository.getCoffeeById(1)

        assertNotNull(coffee)
        assertEquals("Espresso", coffee?.name)
    }

    @Test
    fun getCoffeeById_returnsNull_whenIdMissing() {
        val coffee = CoffeeRepository.getCoffeeById(999)

        assertNull(coffee)
    }
}
