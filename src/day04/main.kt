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
    input.println()
    return 1
}

fun part2(input: List<String>): Int {
    return 2
}

