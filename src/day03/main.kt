package day03

import println
import readInput

fun main() {
    try {
        val testInput = readInput("day03/test_input")
        val puzzleInput = readInput("day03/input")

        // Part 1: total distance
        part1(testInput).also { check(it == 161) { "Expected 161 but got $it" } }
        part1(puzzleInput).println()

        // Part 2: similarity score
        // part2(testInput).also { check(it == 4) { "Expected 4 but got $it" } }
        // part2(puzzleInput).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun part1(input: List<String>): Int {
    return input.size
}

fun part2(input: List<String>): Int {
    return input.size
}
