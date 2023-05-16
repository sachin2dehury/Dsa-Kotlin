package dynamicprogramming

object DynamicProgrammingExecutor : DynamicProgrammingProblems by DynamicProgrammingSolutions() {

    operator fun invoke() {

        val root = Node(10)
        root.left = Node(2)
        root.right = Node(10)
        root.left?.left = Node(20)
        root.left?.right = Node(1)
        root.right?.right = Node(-25)
        root.right?.right?.left = Node(3)
        root.right?.right?.right = Node(4)

        largestSumContiguousSubArray()
        minimumJumpsToReachEnd()

        diameterOfBinaryTree(root)

        countOfSubsetSum()
        countOfSubsetWithDifference()
        eggDroppingProblem()
        equalSum()
        knapsack()
        longestCommonSubSequence()
        longestCommonSubString()
        longestPalindromicSubsequence()
        longestRepeatingSubsequence()
        maximumNumberOfWaysToChangeCoins()

        maximumPathSumOfBinaryTree(root)

        minimumNumberOfDeletionForPalindrome()
        minimumDifferenceOfSum()
        minimumInsertionForPalindrome()
        minimumNumberOfCoinsToChange()
        minimumNumberOfInsertAndDeleteToMatch()

        matrixChainMultiplication()
        minimumNumberOfPalindromePartitioning()
        printLongestCommonSubsequence()
        printShortestCommonSuperSequence()
        rodCuttingProblem()

        patternMatching()
        shortestCommonSuperSequence()
        unboundedKnapsack()
    }
}