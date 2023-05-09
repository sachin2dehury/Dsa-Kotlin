package dynamicprogramming

object DynamicProgrammingExecutor: DynamicProgrammingProblems by DynamicProgrammingSolutions() {

    operator fun invoke() {

        largestSumContiguousSubArray()
        minimumJumpsToReachEnd()

        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left?.right = Node(4)
        root.right?.left = Node(5)
        root.right?.right = Node(6)
        root.right?.left?.left = Node(7)
        root.right?.left?.right = Node(8)

        println(diameterOfBinaryTree(root))

        countOfSubsetSum()
        countOfSubsetWithDifference()
        eggDroppingProblem()
        equalSum()
        knapsack()
        longestCommonSubSequence()
    }
}