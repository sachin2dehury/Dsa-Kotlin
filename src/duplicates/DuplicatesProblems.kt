package duplicates

interface DuplicatesProblems {

    fun findDuplicateAndMissingElement(items: List<Int> = listOf(1, 2, 3, 6, 5, 6))

    fun findAllMissingAndDuplicates(items: List<Int> = listOf(1, 2, 3, 6, 3, 6, 1))
}