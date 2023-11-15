package recursion

import java.util.Stack

interface RecursionProblems {

    fun deleteMiddleElementOfStack(stack: Stack<Int>, mid: Int = stack.size / 2)

    fun heightOfBinaryTree(node: Node?): Int

    fun josephusProblem(n: Int = 7, k: Int = 3): Int

    fun kthElementInGrammar(row: Int = 3, k: Int = 2): Int

    fun nBitBinaryNumber(length: Int = 4, unusedOne: Int = 0, result: String = "")

    fun permutationWithCaseChange(string: String = "abc", currentIndex: Int = 0, result: String = "")

    fun permutationWithLetter(string: String = "a1b2", currentIndex: Int = 0, result: String = "")

    fun permutationWithSpaces(string: String = "abc", currentIndex: Int = 0, result: String = "")

    fun printAllSubSequences(string: String = "abc", currentIndex: Int = 0, result: String = "")

    fun printUniqueSubSequences(
        string: String = "abaa",
        currentIndex: Int = 0,
        tempResult: String = "",
        result: MutableSet<String>
    )

    fun reverseStack(stack: Stack<Int>)

    fun sortList(items: MutableList<Int>)

    fun sortStack(stack: Stack<Int>)

    fun towerOfHanoi(discCount: Int, from: Char = 'A', to: Char = 'B', via: Char = 'C')
}