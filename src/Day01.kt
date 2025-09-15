import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        val (left, right) = input.toLists()
        return left.sorted()
            .zip(right.sorted())
            .sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Part 1: total distance
    check(part1(readInput("Day01_test")) == 11)
    part1(readInput("Day01")).println()

    // Part 2: similarity score
    // check(part2(readInput("Day01_test")) == 31)
    // part2(readInput("Day01")).println()
}

fun List<String>.toLists(): Pair<List<Int>, List<Int>> = this
    .map { it.split("\\s+".toRegex()) }
    .map { it[0].toInt() to it[1].toInt() }
    .unzip()
