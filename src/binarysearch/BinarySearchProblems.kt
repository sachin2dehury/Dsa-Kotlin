package binarysearch

interface BinarySearchProblems {

    // [10, 20, 30, 50, 60, 80, 110, 130, 140, 170]
    // 110 -> 6
    fun binarySearch(
        items: List<Int> = listOf(10, 20, 30, 50, 60, 80, 110, 130, 140, 170),
        item: Int = 110,
    )

    fun reverseBinarySearch(
        items: List<Int> = listOf(10, 20, 30, 50, 60, 80, 110, 130, 140, 170).asReversed(),
        item: Int = 110
    )

    // [1, 3, 5, 5, 5, 5, 67, 123, 125]
    // 5 -> 2
    fun firstOccurrenceOfElement(
        items: List<Int> = listOf(1, 3, 5, 5, 5, 5, 67, 123, 125),
        item: Int = 5,
    )

    // [1, 3, 5, 5, 5, 5, 67, 123, 125]
    // 5 -> 5
    fun lastOccurrenceOfElement(
        items: List<Int> = listOf(1, 3, 5, 5, 5, 5, 67, 123, 125),
        item: Int = 5,
    )

    // [1, 3, 5, 5, 5, 5, 67, 123, 125]
    // 5 -> 4
    fun countOfAnElement(
        items: List<Int> = listOf(1, 3, 5, 5, 5, 5, 67, 123, 125),
        item: Int = 5,
    )

    // [1, 2, 8, 10, 10, 12, 19]
    // 5 -> 2
    fun floorOfAnElement(items: List<Int> = listOf(1, 2, 8, 10, 10, 12, 19), item: Int = 5)

    // [1, 2, 8, 10, 10, 12, 19]
    // 5 -> 8
    fun ceilOfAnElement(items: List<Int> = listOf(1, 2, 8, 10, 10, 12, 19), item: Int = 5)

    // [2, 5, 10, 12, 15]
    // 5 -> 5
    fun minimumDifferenceElement(items: List<Int> = listOf(2, 5, 10, 12, 15), item: Int = 5)

    fun nextAlphabetInList(items: List<Char> = listOf('D', 'J', 'K', 'L'), item: Char = 'D')

    // [15, 18, 2, 3, 6, 12] -> 2
    fun numberOfRotation(items: List<Int> = listOf(15, 18, 2, 3, 6, 12))

    // [15, 18, 2, 3, 6, 12]
    // 6 -> 4
    fun binarySearchInRotatedList(
        items: List<Int> = listOf(15, 18, 2, 3, 6, 12),
        item: Int = 6,
    )

    // [5, 10, 20, 15]
    fun peakElement(items: List<Int> = listOf(5, 10, 20, 15))

    fun firstOccurrenceOfOne(items: List<Int> = listOf(0, 0, 0, 0, 0, 0, 0, 1, 1))

    fun maximumElementInBitonicList(items: List<Int> = listOf(100, 80, 60, 40, 20, 0))

    fun binarySearchInBitonicList(
        items: List<Int> = listOf(3, 23, 10, 8, 7, 6),
        item: Int = 23,
    )

    fun binarySearchInInfiniteList(
        items: List<Int> = listOf(10, 20, 30, 50, 60, 80, 110, 130, 140, 170),
        item: Int = 110,
    )

    fun binarySearchInNearlySortedList(
        items: List<Int> = listOf(10, 3, 40, 20, 50, 80, 70),
        item: Int = 50,
    )

    fun binarySearchInUnknownOrder(
        items: List<Int> = listOf(10, 20, 30, 50, 60, 80, 110, 130, 140, 170).reversed(),
        item: Int = 110,
    )

    fun binarySearchInMatrix(
        items: List<List<Int>> = listOf(
            listOf(10, 20, 30, 40),
            listOf(15, 25, 35, 45),
            listOf(27, 29, 37, 48),
            listOf(32, 33, 39, 50),
        ),
        item: Int = 29,
    )

    fun allocateNumberOfPages(items: List<Int> = listOf(10, 20, 30, 40), k: Int = 2)
}
