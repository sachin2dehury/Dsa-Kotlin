package recursion

import java.util.Stack

interface RecursionProblems {

    fun deleteMiddleElementOfStack(stack: Stack<Int>, mid: Int = stack.size / 2)

    fun heightOfBinaryTree(node: Node?): Int

    fun josephusProblem(n: Int = 7, k: Int = 3): Int

    fun kthElementInGrammar(n: Int = 3, k: Int = 2): Int

    fun nBitBinaryNumber(length: Int = 4, unusedOne: Int = 0, result: String = "")

    fun permutationWithCaseChange(string: String, currentIndex: Int = 0, result: String = "")

    fun permutationWithLetter(string: String, currentIndex: Int = 0, result: String = "")

    fun permutationWithSpaces(string: String, currentIndex: Int = 0, result: String = "")

    fun printAllSubSequences(string: String, currentIndex: Int = 0, result: String = "")

    fun printUniqueSubSequences(
        string: String,
        currentIndex: Int = 0,
        tempResult: String = "",
        result: MutableSet<String> = mutableSetOf()
    )

    fun reverseStack()

    fun sortList()

    fun sortStack()

    fun towerOfHanoi()
}