package day04

import println
import readInput

private const val day = "day04"

fun main() {
    try {
        val testInput = readInput("$day/test_input")
        val puzzleInput = readInput("$day/input")

        // Part 1: total distance
        part1(testInput).also { check(it == 18) { "Expected 18 but got $it" } }
        part1(puzzleInput).println()

        // Part 2: similarity score
        part2(testInput).also { check(it == 48) { "Expected 48 but got $it" } }
        part2(puzzleInput).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun part1(input: List<String>): Int {
    var result = 0
    val grid = input.map { line -> line.toList() }
    for (x in grid.indices) {
        for (y in grid[x].indices) {
            result += grid.horizontal(x, y).isXmasOrXmasReversed().toScore() +
                    grid.vertical(x, y).isXmasOrXmasReversed().toScore() +
                    grid.diagonalRight(x, y).isXmasOrXmasReversed().toScore() +
                    grid.diagonalLeft(x, y).isXmasOrXmasReversed().toScore()
        }
    }
    return result
}

fun part2(input: List<String>): Int {
    return 2
}

fun List<List<Char>>.horizontal(x: Int, y: Int): String {
    return try {
        val row = this[x]
        row.subList(y, y + 4).joinToString("")
    } catch (_: IndexOutOfBoundsException) {
        ""
    }
}

fun List<List<Char>>.vertical(x: Int, y: Int): String {
    return try {
        val column = this.map { row -> row[y] }
        column.subList(x, x + 4).joinToString("")
    } catch (_: IndexOutOfBoundsException) {
        ""
    }
}

fun List<List<Char>>.diagonalRight(x: Int, y: Int): String {
    return try {
        (0..<4).map {
            this[x + it][y + it]
        }.joinToString("")
    } catch (_: IndexOutOfBoundsException) {
        ""
    }
}

fun List<List<Char>>.diagonalLeft(x: Int, y: Int): String {
    return try {
        (0..<4).map {
            this[x - it][y - it]
        }.joinToString("")
    } catch (_: IndexOutOfBoundsException) {
        ""
    }
}

fun String.isXmasOrXmasReversed(): Boolean = this.lowercase() == "xmas" || this.lowercase() == "samx"

fun Boolean.toScore(): Int = if (this) 1 else 0
