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
            for (moveFn in moveFunctions) {
                result += grid
                    .extractString(x,y, 4, moveFn)
                    .isXmas()
                    .toScore()
            }
        }
    }
    return result
}

fun part2(input: List<String>): Int {
    return 2
}


typealias Grid = List<List<Char>>
typealias moveFn = (x: Int, y: Int, step: Int) -> Pair<Int, Int>

val moveFunctions = listOf(
    { x: Int, y: Int, step: Int -> x to y + step }, // "right"
    { x: Int, y: Int, step: Int -> x to y - step }, // "left"
    { x: Int, y: Int, step: Int -> x + step to y }, // "down"
    { x: Int, y: Int, step: Int -> x - step to y }, // "up"
    { x: Int, y: Int, step: Int -> x + step to y + step }, // "downRight"
    { x: Int, y: Int, step: Int -> x + step to y - step }, // "downLeft"
    { x: Int, y: Int, step: Int -> x - step to y + step }, // "upRight"
    { x: Int, y: Int, step: Int -> x - step to y - step }, // "upLeft"
)

fun Grid.extractString(startX: Int, startY: Int, steps: Int, move: moveFn): String {
    return try {
        (0..<steps)
            .map { step -> move(startX, startY, step) }
            .map { (x, y) -> this[x][y] }
            .joinToString("")
    } catch (_: IndexOutOfBoundsException) {
        ""
    }
}

fun String.isXmas(): Boolean = this.lowercase() == "xmas"

fun Boolean.toScore(): Int = if (this) 1 else 0
