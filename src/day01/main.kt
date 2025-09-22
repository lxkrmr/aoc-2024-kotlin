package day01

import println
import readInput
import kotlin.math.abs

fun main() {
    try {
        val testInput = readInput("day01/test_input")
        val puzzleInput = readInput("day01/input")

        // Part 1: total distance
        part1(testInput).also { check(it == 11) { "Expected 11 but got $it" } }
        part1(puzzleInput).println()

        // Part 2: similarity score
        part2(testInput).also { check(it == 31) { "Expected 31 but got $it" } }
        part2(puzzleInput).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun part1(input: List<String>): Int {
    val (left, right) = input.toLists()
    return left.sorted()
        .zip(right.sorted())
        .sumOf { abs(it.first - it.second) }
}

fun part2(input: List<String>): Int {
    val (left, right) = input.toLists()
    val frequencies = right.groupingBy { it }.eachCount()
    return left.sumOf {
        it * frequencies.getOrDefault(it, 0)
    }
}

fun List<String>.toLists(): Pair<List<Int>, List<Int>> = this
    .map {
        val first = it.substringBefore(' ').toInt()
        val second = it.substringAfterLast(' ').toInt()
        first to second
    }
    .unzip()
