package com.tobeannounced.pizza

import org.junit.Assert
import org.junit.Test

class SolveTest {

    val examplePizza = parsePizza(fileFromResources("example.in"))

    @Test
    fun shouldSolvePizza() {
        Assert.assertEquals(
                examplePizza.pizza.height * examplePizza.pizza.width,
                solve(examplePizza).map { it.size }.sum())
    }

    @Test
    fun outSmall() {
        print(solve(parsePizza(fileFromResources("small.in"))).map { it.map { it.cell }.toSet() }.toSet())
    }

    @Test
    fun outExample() {
        print(solve(parsePizza(fileFromResources("example.in"))).map { it.map { it.cell }.toSet() }.toSet())
    }
}