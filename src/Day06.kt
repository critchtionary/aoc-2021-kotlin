/**
 * Day 6: Lanternfish
 */
fun main() {

    fun calculateLanternfish(input: List<String>, days: Int): Long {
        /**
         * Calculate how many lanternfish there would be after a specified number of days.
         */
        val fishIntervals = input.first().split(",").map{ it.toInt() }

        // Create an array to keep track of how many lanternfish there are for each internal timer
        var lanternfish = LongArray(9)
        fishIntervals.forEach { lanternfish[it]++ }

        // Simulate each day
        for (i in 1 .. days) {
            val zeroCount: Long = lanternfish.first()

            // Reduce timer of all fish by reducing index by 1
            lanternfish = lanternfish.copyOfRange(1, 8 + 1)

            // Fish with a timer of zero get reset to six, and result in a new fish with a timer of eight
            lanternfish += zeroCount
            lanternfish[6] += zeroCount
        }

        return lanternfish.sum()
    }

    fun part1(input: List<String>): Long {
        return calculateLanternfish(input, 80)
    }

    fun part2(input: List<String>): Long {
        return calculateLanternfish(input, 256)
    }

    // Test against examples
    val testInput = readInput("Day06_test")
    check(part1(testInput).toInt() == 5934)
    check(part2(testInput) == 26984457539)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}