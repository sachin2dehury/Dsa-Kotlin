package dynamicprogramming

interface DynamicProgrammingProblems {

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

    fun largestSumContiguousSubArray(items: List<Int> = listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))

    fun longestCommonSubString(string1: String = "ABC", string2: String = "BABA")

    fun longestPalindromicSubsequence(string: String = "ABBDCACB")

    fun longestRepeatingSubsequence(string: String = "ATACTCGGA")

    fun matrixChainMultiplication(items: List<Int> = listOf(10, 30, 5, 60))

    fun maximumNumberOfWaysToChangeCoins(items: List<Int> = listOf(1, 3, 5, 7), sum: Int = 8)

    fun maximumPathSumOfBinaryTree(node: Node?)

    fun maximumPathSumOfBinaryTreeLeafToLeafNode(node: Node?)

    fun minimumDifferenceOfSum(items: List<Int> = listOf(3, 1, 4, 2, 2, 1))

    fun minimumInsertionForPalindrome(string: String = "aebcbda")

    fun minimumJumpsToReachEnd(items: List<Int> = listOf(4, 2, 0, 3, 2, 0, 1, 8))

    fun minimumNumberOfCoinsToChange(items: List<Int> = listOf(1, 3, 5, 7), sum: Int = 9)

    fun minimumNumberOfDeletionForPalindrome(string: String = "aebcbda")

    fun minimumNumberOfInsertAndDeleteToMatch(string1: String = "geek", string2: String = "eke")

    fun minimumNumberOfPalindromePartitioning(string: String = "nitik")

    fun printLongestCommonSubsequence(string1: String = "ABC", string2: String = "ABAB")

    fun printShortestCommonSuperSequence(string1: String = "geek", string2: String = "eke")

    fun rodCuttingProblem(items: List<Int> = listOf(1, 5, 8, 9, 10, 17, 17, 20), length: Int = 8)

    fun patternMatching(string: String = "ABEDFHR", pattern: String = "AEF")

    fun shortestCommonSuperSequence(string1: String = "geek", string2: String = "eke")

    fun subsetSum(items: List<Int> = listOf(1, 2, 3, 3), sum: Int = 4)

    fun targetSum(items: List<Int> = listOf(1, 2, 3, 3), sum: Int = 4)

    fun unboundedKnapsack(items: List<Pair<Int, Int>> = listOf(10 to 5, 30 to 10, 20 to 15), weight: Int = 100)

    fun minimumEditDistance(string1: String = "sunday", string2: String = "saturday")

    fun longestIncreasingSubsequence(items: List<Int> = listOf(3, 10, 2, 1, 20))

    fun regularExpressionMatch(pattern: String = "ba*a?", string: String = "baaabab")

    fun maximumSumRectangularMatrix(items: List<List<Int>>)

    fun wordBreakProblem(
        dictionary: Set<String> = setOf(
            "mobile", "samsung", "sam", "sung",
            "man", "mango", "icecream", "and",
            "go", "i", "like", "ice", "cream"
        ), string: String = "ilikesamsung"
    )

    fun countWaysToReachNthStair(n: Int = 4)

    fun boxStackingProblem(boxes: List<Box>)

    fun interleaveString(string1: String = "YX", string2: String = "X", string3: String = "XXY")

    fun totalNumberOfPathsInMatrix(m: Int = 2, n: Int = 3)

    fun numbersWithoutConsecutive1(n: Int)

    fun longestBitonicSubsequence(items: List<Int>)
}