package slidingwindow

interface SlidingWindowProblems {

    fun countOfOccurrencesOfAnagram(string: String = "forxxorfxdofr", pattern: String = "for")

    fun firstNegativeNumberInWindow(items: List<Int> = listOf(-8, 2, 3, -6, 10), windowSize: Int = 2)

    fun longestSubArrayOfSumK(items: List<Int> = listOf(-5, 8, -14, 2, 4, 12), k: Int = -5)

    fun longestSubStringWithKUniqueChar(string: String = "aabbccaaaabbbb", k: Int = 2)

    fun longestSubStringWithoutRepeatingChar(string: String = "ABDABEFEFGABEF")

    fun maximumElementOfAllSubArray(items: List<Int> = listOf(1, 2, 3, 1, 4, 5, 2, 3, 6), windowSize: Int = 3)

    fun maximumSumOfArrayOfSizeK(items: List<Int> = listOf(1, 4, 2, 10, 23, 3, 1, 0, 20), windowSize: Int = 4)

    fun minimumWindowSubString(string: String = "this is a test string", pattern: String = "tist")

    fun pickToys(string: String = "abaccab", toysWindowSize: Int = 2)
}