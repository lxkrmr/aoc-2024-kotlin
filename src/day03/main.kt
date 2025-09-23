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
        part2(testInput).also { check(it == 48) { "Expected 48 but got $it" } }
        part2(puzzleInput).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun part1(input: List<String>): Int {
    return input.sumOf { line ->
        "mul\\((\\d+),(\\d+)\\)".toRegex()
            .findAll(line)
            .sumOf { matchResult ->
                matchResult.groupValues[1].toInt() * matchResult.groupValues[2].toInt()
            }
    }
}

fun part2(input: List<String>): Int {
    var result = 0
    var doMul = true

    for (line in input) {
        val findAll = """mul\((\d+),(\d+)\)|do\(\)|don't\(\)""".toRegex().findAll(line).toList()
        for (matchResult in findAll) {
            when(matchResult.value) {
                "do()" -> doMul = true
                "don't()" -> doMul = false
                else -> {
                    if (doMul) {
                        result += matchResult.groupValues[1].toInt() * matchResult.groupValues[2].toInt()
                    }
                }
            }
        }
    }


    return result
}
