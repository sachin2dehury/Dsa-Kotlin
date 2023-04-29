package duplicates

class DuplicateSolutions : DuplicatesProblems {

    override fun findDuplicateAndMissingElement(items: List<Int>) {
        val currentSum = items.sum()
        val actualSum = (items.size * (items.size + 1)) / 2
        // a - b
        val difference = currentSum - actualSum

        val currentSquareSum = items.sumOf { it * it }
        val actualSquareSum = (items.size * (items.size + 1) * (2 * items.size + 1)) / 6

        // a^2-b^2
        val squareDifference = currentSquareSum - actualSquareSum

        // a+b
        val addition = squareDifference / difference

        val duplicate = (addition + difference) / 2
        val missing = (addition - difference) / 2

        val result = duplicate to missing

        println(result)
    }
}