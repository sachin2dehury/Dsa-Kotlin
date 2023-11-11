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

        countOfSubsetSum()
        countOfSubsetWithDifference()
        diameterOfBinaryTree(root)
        eggDroppingProblem()
        equalSum()
        knapsack()
        largestSumContiguousSubArray()
        longestCommonSubSequence()
        longestCommonSubString()
        longestPalindromicSubsequence()
        longestRepeatingSubsequence()
        matrixChainMultiplication()
        maximumNumberOfWaysToChangeCoins()
        maximumPathSumOfBinaryTree(root)
        maximumPathSumOfBinaryTreeLeafToLeafNode(root)
        minimumJumpsToReachEnd()
        minimumNumberOfDeletionForPalindrome()
        minimumDifferenceOfSum()
        minimumInsertionForPalindrome()
        minimumNumberOfCoinsToChange()
        minimumNumberOfInsertAndDeleteToMatch()
        minimumNumberOfPalindromePartitioning()
        printLongestCommonSubsequence()
        printShortestCommonSuperSequence()
        rodCuttingProblem()
        patternMatching()
        shortestCommonSuperSequence()
        unboundedKnapsack()
        minimumEditDistance()
        regularExpressionMatch()
        countWaysToReachNthStair()
        wordBreakProblem()
        boxStackingProblem()
        interleaveString()
        totalNumberOfPathsInMatrix()
        numbersWithoutConsecutive1()
        longestBitonicSubsequence()
    }
}

fun main() {
    DynamicProgrammingExecutor.invoke()
}