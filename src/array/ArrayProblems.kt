package array

interface ArrayProblems {

    fun pairSum(items: ArrayList<Int> = arrayListOf(1, 4, 45, 6, 10, 8), sum: Int = 16)

    fun tripletSum(items: ArrayList<Int> = arrayListOf(12, 3, 4, 1, 6, 9), sum: Int = 24)

    fun firstRepeatingElement(items: ArrayList<Int> = arrayListOf(10, 5, 3, 4, 3, 5, 6))

    fun firstMissingElement(items: ArrayList<Int> = arrayListOf(2, 3, -7, 6, 8, 1, -10, 15))

    fun unionAndIntersectionOfSortedArray(
        array1: ArrayList<Int> = arrayListOf(1, 3, 4, 5, 7),
        array2: ArrayList<Int> = arrayListOf(2, 3, 5, 6)
    )

    fun minimizeTheMaximumDifference(items: List<Int> = listOf(7, 4, 8, 8, 8, 9), k: Int = 6)

    fun printMatrixSpirally(
        items: List<List<Int>> = listOf(
            listOf(1, 2, 3, 4),
            listOf(5, 6, 7, 8),
            listOf(9, 10, 11, 12),
            listOf(13, 14, 15, 16)
        )
    )
}