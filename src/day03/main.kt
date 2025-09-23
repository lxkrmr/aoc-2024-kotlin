package day03

import println
import readInput

private const val day = "day03"
private const val mulRegex = """mul\((\d{1,3}),(\d{1,3})\)"""
private const val doRegex = """do\(\)"""
private const val dontRegex = """don't\(\)"""

fun main() {
    try {
        val testInput = readInput("$day/test_input")
        val puzzleInput = readInput("$day/input")

        // Part 1: total distance
        part1(testInput).also { check(it == 161) { "Expected 161 but got $it" } }
        part1(puzzleInput).println()

        // Part 2: similarity score
        part2(testInput).also { check(it == 48) { "Expected 48 but got $it" } }
        part2(puzzleInput).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun part1(input: List<String>): Int {
    return input.sumOf { line ->
        mulRegex.toRegex()
            .findAll(line)
            .sumOf { it.toProduct() }
    }
}

fun part2(input: List<String>): Int {
    var result = 0
    var doMul = true

    for (line in input) {
        val findAll = "$mulRegex|$doRegex|$dontRegex".toRegex().findAll(line).toList()
        for (matchResult in findAll) {
            when (matchResult.value) {
                "do()" -> doMul = true
                "don't()" -> doMul = false
                else -> {
                    if (doMul) result += matchResult.toProduct()
                }
            }
        }
    }
    return result
}

private fun MatchResult.toProduct(): Int {
    val (first, second) = destructured
    return first.toInt() * second.toInt()
}
