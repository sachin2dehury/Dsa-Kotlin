package recursion

import java.util.Stack
import kotlin.math.max
import kotlin.math.min
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
        val list = (1..n).toMutableList()

        var index = 0
        while (list.size > 1) {
            index = (index + k) % list.size
            list.removeAt(index)
        }

        return list.first()
//        recursion ans
//        if (n == 1) return 1
//        return josephusProblem(n - 1, k - 1) % n + 1
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
        if (result.isNotEmpty()) {
            permutationWithSpaces(string, currentIndex + 1, result + ' ' + string[currentIndex])
        }
        permutationWithSpaces(string, currentIndex + 1, result + string[currentIndex])
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

    override fun reverseStack(stack: Stack<Int>) {
        if (stack.isEmpty()) return
        val lastItem = stack.pop()
        reverseStack(stack)
        pushItemAtBottom(stack, lastItem)
    }

    private fun pushItemAtBottom(stack: Stack<Int>, item: Int) {
        if (stack.isEmpty()) {
            stack.push(item)
            return
        }
        val lastItem = stack.pop()
        pushItemAtBottom(stack, item)
        stack.push(lastItem)
    }

    override fun sortList(items: MutableList<Int>) {
        if (items.size <= 1) return
        val lastItem = items.removeLast()
        sortList(items)
        insertItemIntoSortedList(items, lastItem)
    }

    private fun insertItemIntoSortedList(items: MutableList<Int>, item: Int) {
        if (items.isEmpty()) {
            items.add(item)
            return
        }
        val lastItem = items.removeLast()
        val minItem = min(lastItem, item)
        val maxItem = max(lastItem, item)
        insertItemIntoSortedList(items, minItem)
        items.add(maxItem)
    }

    override fun sortStack(stack: Stack<Int>) {
        if (stack.size <= 1) return
        val lastItem = stack.pop()
        sortStack(stack)
        pushItemIntoSortedStack(stack, lastItem)
    }

    private fun pushItemIntoSortedStack(stack: Stack<Int>, item: Int) {
        if (stack.isEmpty()) {
            stack.push(item)
            return
        }
        val lastItem = stack.pop()
        val minItem = min(lastItem, item)
        val maxItem = max(lastItem, item)
        pushItemIntoSortedStack(stack, minItem)
        stack.push(maxItem)
    }

    override fun towerOfHanoi(discCount: Int, from: Char, to: Char, via: Char) {
        if (discCount == 0) return
        towerOfHanoi(discCount - 1, from, via, to)
        println("Disc is moved from $from to $to via $via")
        towerOfHanoi(discCount - 1, via, to, from)
    }
}