package com.tobeannounced.pizza

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class PizzaParserTest {

    @Test
    fun shouldParsePizza() {
        assertEquals(
                PizzaProblem(
                        Pizza(
                                setOf(
                                        Piece(0, 0, PieceKind.TOMATO, false),
                                        Piece(0, 1, PieceKind.MUSHROOM, false),
                                        Piece(0, 2, PieceKind.MUSHROOM, false),
                                        Piece(0, 3, PieceKind.MUSHROOM, false),
                                        Piece(0, 4, PieceKind.TOMATO, false),
                                        Piece(0, 5, PieceKind.TOMATO, false),
                                        Piece(0, 6, PieceKind.TOMATO, false),

                                        Piece(1, 0, PieceKind.MUSHROOM, false),
                                        Piece(1, 1, PieceKind.MUSHROOM, false),
                                        Piece(1, 2, PieceKind.MUSHROOM, false),
                                        Piece(1, 3, PieceKind.MUSHROOM, false),
                                        Piece(1, 4, PieceKind.TOMATO, false),
                                        Piece(1, 5, PieceKind.MUSHROOM, false),
                                        Piece(1, 6, PieceKind.MUSHROOM, false),

                                        Piece(2, 0, PieceKind.TOMATO, false),
                                        Piece(2, 1, PieceKind.TOMATO, false),
                                        Piece(2, 2, PieceKind.MUSHROOM, false),
                                        Piece(2, 3, PieceKind.TOMATO, false),
                                        Piece(2, 4, PieceKind.TOMATO, false),
                                        Piece(2, 5, PieceKind.MUSHROOM, false),
                                        Piece(2, 6, PieceKind.TOMATO, false),

                                        Piece(3, 0, PieceKind.TOMATO, false),
                                        Piece(3, 1, PieceKind.MUSHROOM, false),
                                        Piece(3, 2, PieceKind.MUSHROOM, false),
                                        Piece(3, 3, PieceKind.TOMATO, false),
                                        Piece(3, 4, PieceKind.MUSHROOM, false),
                                        Piece(3, 5, PieceKind.MUSHROOM, false),
                                        Piece(3, 6, PieceKind.MUSHROOM, false),

                                        Piece(4, 0, PieceKind.TOMATO, false),
                                        Piece(4, 1, PieceKind.TOMATO, false),
                                        Piece(4, 2, PieceKind.TOMATO, false),
                                        Piece(4, 3, PieceKind.TOMATO, false),
                                        Piece(4, 4, PieceKind.TOMATO, false),
                                        Piece(4, 5, PieceKind.TOMATO, false),
                                        Piece(4, 6, PieceKind.MUSHROOM, false),

                                        Piece(5, 0, PieceKind.TOMATO, false),
                                        Piece(5, 1, PieceKind.TOMATO, false),
                                        Piece(5, 2, PieceKind.TOMATO, false),
                                        Piece(5, 3, PieceKind.TOMATO, false),
                                        Piece(5, 4, PieceKind.TOMATO, false),
                                        Piece(5, 5, PieceKind.TOMATO, false),
                                        Piece(5, 6, PieceKind.MUSHROOM, false)
                                ), 6, 7),
                        ProblemParams(1, 5)
                ),
                parsePizza(fileFromResources("small.in")))
    }

    fun fileFromResources(name: String) = File((File::class as Any).javaClass.classLoader.getResource(name).file)
}