package heap

interface HeapProblems {

    fun kSmallestElement(items: List<Int> = listOf(7, 10, 4, 3, 20, 15, 30, 40), k: Int = 3)

    fun kLargestElement(items: List<Int> = listOf(7, 10, 4, 3, 20, 15, 30, 40), k: Int = 3)

    fun topKFrequentNumbers(
        items: List<Int> = listOf(3, 1, 4, 4, 5, 2, 6, 1),
        k: Int = 2,
    )

    fun frequencySortDescending(
        items: List<Int> = listOf(3, 1, 4, 4, 5, 2, 6, 1),
        k: Int = 3,
    )

    fun sortKSortedList(items: List<Int> = listOf(6, 5, 3, 2, 8, 10, 9), k: Int = 3)

    fun kClosestElement(
        items: List<Int> = listOf(12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56),
        k: Int = 3,
        item: Int = 35,
    )

    fun kClosestToOrigin(
        items: List<Pair<Int, Int>> = listOf(3 to 3, 5 to -1, -2 to 4),
        k: Int = 3,
    )

    fun minimizeConnectingRopes(items: List<Int> = listOf(4, 3, 2, 6))

    fun sumOfElementsBetweenSmallestK1andK2(
        items: List<Int> = listOf(20, 8, 22, 4, 12, 10, 14),
        k1: Int = 3,
        k2: Int = 6,
    )
}
