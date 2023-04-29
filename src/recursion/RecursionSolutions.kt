package recursion

import java.util.Stack
import kotlin.math.max
import kotlin.math.pow

class RecursionSolutions : RecursionProblems {

    override fun deleteMiddleElementOfStack(stack: Stack<Int>, mid: Int) {
        if (stack.isEmpty()) return
        if (stack.size == mid) {
            stack.pop()
        } else {
            val item = stack.pop()
            deleteMiddleElementOfStack(stack, mid)
            stack.push(item)
        }
    }


    override fun heightOfBinaryTree(node: Node?): Int {
        if (node == null) return 0
        val leftHeight = heightOfBinaryTree(node.left)
        val rightHeight = heightOfBinaryTree(node.right)
        val height = 1 + max(leftHeight, rightHeight)
        return height
    }

    override fun josephusProblem(n: Int, k: Int): Int {
        if (n == 1) return 1
        return josephusProblem(n - 1, k - 1) % n + 1
    }

    override fun kthElementInGrammar(n: Int, k: Int): Int {
        if (n == 1 && k == 1) return 0
        if (2f.pow(n - 1) < k) return -1
        if (2f.pow(n - 2) < k) return kthElementInGrammar(n - 1, k)

        val item = kthElementInGrammar(n - 1, k)
        return if (item == 0) 1 else 0
    }

    override fun nBitBinaryNumber(length: Int, unusedOne: Int, result: String) {
        if (length == 0) {
            println(result)
            return
        }
        if (unusedOne > 0) {
            nBitBinaryNumber(length - 1, unusedOne - 1, result + 0)
        }
        nBitBinaryNumber(length - 1, unusedOne + 1, result + 1)
    }

    override fun permutationWithCaseChange(string: String, currentIndex: Int, result: String) {
        if (currentIndex == string.length) {
            println(result)
            return
        }
        permutationWithCaseChange(string, currentIndex + 1, result + string[currentIndex].uppercaseChar())
        permutationWithCaseChange(string, currentIndex + 1, result + string[currentIndex].lowercaseChar())
    }

    override fun permutationWithLetter(string: String, currentIndex: Int, result: String) {
        if (currentIndex == string.length) {
            println(result)
            return
        }
        if (string[currentIndex].isDigit()) {
            permutationWithLetter(string, currentIndex + 1, result + string[currentIndex])
        } else {
            permutationWithLetter(string, currentIndex + 1, result + string[currentIndex].lowercaseChar())
            permutationWithLetter(string, currentIndex + 1, result + string[currentIndex].uppercaseChar())
        }
    }

    override fun permutationWithSpaces(string: String, currentIndex: Int, result: String) {
        if (currentIndex == string.length) {
            println(result)
            return
        }
        if (result.isEmpty()) {
            permutationWithSpaces(string, currentIndex + 1, result + string[currentIndex])
        }
        permutationWithSpaces(string, currentIndex + 1, result + ' ' + string[currentIndex])
    }

    override fun printAllSubSequences(string: String, currentIndex: Int, result: String) {
        if (currentIndex == string.length) {
            println(result)
            return
        }
        printAllSubSequences(string, currentIndex + 1, result)
        printAllSubSequences(string, currentIndex + 1, result + string[currentIndex])
    }

    override fun printUniqueSubSequences(
        string: String,
        currentIndex: Int,
        tempResult: String,
        result: MutableSet<String>
    ) {
        if (currentIndex == string.length) {
            result.add(tempResult)
            return
        }
        printUniqueSubSequences(string, currentIndex + 1, tempResult, result)
        printUniqueSubSequences(string, currentIndex + 1, tempResult + string[currentIndex], result)
    }

    override fun reverseStack() {

    }

    override fun sortList() {

    }

    override fun sortStack() {

    }

    override fun towerOfHanoi() {

    }
}