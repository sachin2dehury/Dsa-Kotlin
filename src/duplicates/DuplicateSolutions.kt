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

    override fun findAllMissingAndDuplicates(items: List<Int>) {
        val list = items.toMutableList()
        var i = 0
        val duplicate = mutableListOf<Int>()
        val missing = mutableListOf<Int>()
        while (i < list.size) {
            if (list[i] != list[list[i] - 1]) {
                val temp = list[i]
                list[i] = list[temp - 1]
                list[temp - 1] = temp
            } else {
                i++
            }
        }
        list.forEachIndexed { index, it ->
            if (it != index + 1) {
                duplicate.add(it)
                missing.add(index + 1)
            }
        }

        println(duplicate)
        println(missing)
    }
}