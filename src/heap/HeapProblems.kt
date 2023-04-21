package heap

interface HeapProblems {

    fun kSmallestElement(items: List<Int> = listOf(7, 10, 4, 3, 20, 15, 30, 40), k: Int = 3): Int

    fun kLargestElement(items: List<Int> = listOf(7, 10, 4, 3, 20, 15, 30, 40), k: Int = 3): Int

    fun topKFrequentNumbers(items: List<Int> = listOf(3, 1, 4, 4, 5, 2, 6, 1), k: Int = 2): List<Int>

    fun frequencySortDescending(items: List<Int> = listOf(3, 1, 4, 4, 5, 2, 6, 1), k: Int = 3): List<Int>

    fun sortKSortedList(items: List<Int>, k: Int = 3)

    fun kClosestElement(items: List<Int>, k: Int = 3)

    fun kClosestToOrigin(items: List<Pair<Int, Int>>, k: Int = 3)

    fun minimizeConnectingRopes(items: List<Int>, k: Int = 3)

    fun sumOfElementsBetweenK1andK2(items: List<Int>, k: Int = 3)
}