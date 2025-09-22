package day02

import println
import readInput
import kotlin.math.abs

fun main() {
    try {
        val testInput = readInput("day02/test_input")
        val puzzleInput = readInput("day02/input")

        // Part 1: total distance
        part1(testInput).also { check(it == 2) { "Expected 2 but got $it" } }
        part1(puzzleInput).println()

        // Part 2: similarity score
        part2(testInput).also { check(it == 4) { "Expected 4 but got $it" } }
        part2(puzzleInput).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun part1(input: List<String>): Int {
    return input.map { it.toReport() }
        .filter { it.isSafe() }
        .size
}

fun part2(input: List<String>): Int {
    return input.size
}

typealias Report = List<Int>
typealias Level = Int

fun String.toReport(): Report = split(" ").map { it.toInt() }

fun Report.isSafe(): Boolean = (allLevelsAreIncreasing() || allLevelsAreDecreasing())
        && allLevelsDifferAtLeastByOneAndAtMostByThree()

fun Report.allLevelsDifferAtLeastByOneAndAtMostByThree(): Boolean = this.windowed(2)
    .all {
        val diff = abs(it.first() - it.last())
        diff in 1..3
    }

fun Report.allLevelsAreIncreasing(): Boolean = windowed(2)
    .map { it.last() - it.first() }
    .all { it.isPositive() }

fun Report.allLevelsAreDecreasing(): Boolean = windowed(2)
    .map { it.last() - it.first() }
    .all { it.isNegative() }

fun Level.isPositive(): Boolean = this > 0

fun Level.isNegative(): Boolean = this < 0
