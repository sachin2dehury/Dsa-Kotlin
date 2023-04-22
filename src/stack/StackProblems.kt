package stack

interface StackProblems {

    // [4,5,2,25] -> [5,25,25,-1]
    fun nearestGreaterToRight(items: List<Int> = listOf(4, 5, 2, 25)): List<Int>

    // [4,5,2,25] -> [-1,-1,5,-1]
    fun nearestGreaterToLeft(items: List<Int> = listOf(4, 5, 2, 25)): List<Int>

    // [4,5,2,25] -> [2,2,-1,-1]
    fun nearestSmallerToRight(items: List<Int> = listOf(4, 5, 2, 25)): List<Int>

    // [4,5,2,25] -> [-1,-1,-1,2]
    fun nearestSmallerToLeft(items: List<Int> = listOf(4, 5, 2, 25)): List<Int>

    // [3, 0, 2, 0, 4]
    // [4, 4, 4, 4, 4]
    // [3, 3, 3, 3, 4]
    fun rainWaterTrapping(items: List<Int> = listOf(3, 0, 2, 0, 4)): Int

    // [6, 2, 5, 4, 5, 1, 6]
    // [2, 1, 4, 1, 1, -1, -1]
    // [-1, -1, 2, 2, 4, -1, 1]
    // -> 12
    fun maximumAreaHistogram(items: List<Int> = listOf(6, 2, 5, 4, 5, 1, 6)): Int

    // [100, 80, 60, 70, 60, 75, 85]
    fun stockSpan(items: List<Int> = listOf(100, 80, 60, 70, 60, 75, 85)): List<Int>

    fun binaryMatrixMaximumAreaHistogram(
        items: List<List<Int>> = listOf(
            listOf(0, 1, 1, 0),
            listOf(1, 1, 1, 1),
            listOf(1, 1, 1, 1),
            listOf(1, 1, 0, 0),
            ),
    ): Int

    // 53+62/*35*+ -> 39
    fun postfixEvaluation(expression: String = "53+62/*35*+"): Int?

    // [()]{}{[()()]()} -> true
    fun balancedParenthesis(expression: String = "[()]{}{[()()]()}"): Boolean
}
