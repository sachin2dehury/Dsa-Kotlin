package dynamicprogramming

interface DynamicProgrammingProblems {

    fun largestSumContiguousSubArray(items: List<Int> = listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))

    fun minimumJumpsToReachEnd(items: List<Int> = listOf(4, 2, 0, 3, 2, 0, 1, 8))

    fun countOfSubsetSum(items: List<Int> = listOf(7, 3, 2, 5, 8), sum: Int = 14)

    fun countOfSubsetWithDifference(items: List<Int> = listOf(1, 2, 3, 1, 2), difference: Int = 1)

    fun diameterOfBinaryTree(node: Node?)

    fun eggDroppingProblem(floorCount: Int = 10, eggCount: Int = 2)

    fun equalSum(items: List<Int> = listOf(1, 5, 11, 5))

    fun knapsack(
        items: List<Pair<Int, Int>> = listOf(20 to 1, 5 to 2, 10 to 3, 40 to 8, 15 to 7, 25 to 4),
        weight: Int = 10
    )

    fun longestCommonSubSequence(string1: String = "ABCBDAB", string2: String = "BDCABA")

    fun longestCommonSubString(string1: String = "ABC", string2: String = "BABA")

    fun longestPalindromicSubsequence(string: String = "ABBDCACB")

    fun longestRepeatingSubsequence(string: String = "ATACTCGGA")

    fun matrixChainMultiplication(items: List<Int> = listOf(10, 30, 5, 60))

    fun maximumNumberOfWaysToChangeCoins(items: List<Int> = listOf(1, 2, 3), sum: Int = 4)

    fun maximumPathSumOfBinaryTree(node: Node?)

    fun minimumNumberOfDeletionForPalindrome(string: String = "aebcbda")

    fun minimumDifferenceOfSum(items: List<Int> = listOf(3, 1, 4, 2, 2, 1))

    fun minimumInsertionForPalindrome(string: String = "aebcbda")

    fun minimumNumberOfCoinsToChange(items: List<Int>, sum: Int)

    fun minimumNumberOfInsertAndDeleteToMatch(string1: String, string2: String)

    fun minimumNumberOfPalindromePartitioning(string: String)

    fun printLongestCommonSubsequence(string1: String, string2: String)

    fun printShortestCommonSuperSequence(string1: String, string2: String)

    fun rodCuttingProblem(items: List<Int>, length: Int)

    fun patternMatching(string: String, pattern: String)

    fun shortestCommonSuperSequence(string1: String, string2: String)

    fun subsetSum(items: List<Int>, sum: Int)

    fun targetSum(items: List<Int>, sum: Int)

    fun unboundedKnapsack(items: List<Pair<Int, Int>>, weight: Int)
}