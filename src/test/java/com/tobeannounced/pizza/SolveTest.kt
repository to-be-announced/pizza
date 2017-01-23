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
        println(outputFrom(solve(parsePizza(fileFromResources("small.in"))).toSlices()))
    }

    @Test
    fun outExample() {
        println(outputFrom(solve(parsePizza(fileFromResources("example.in"))).toSlices()))
    }
}