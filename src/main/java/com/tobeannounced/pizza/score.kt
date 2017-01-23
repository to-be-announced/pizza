package com.tobeannounced.pizza

fun calculateScore(pizza: Pizza): Int {
    return pizza.pieces.count { it.assigned }
}