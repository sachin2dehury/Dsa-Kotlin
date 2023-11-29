package stack

import java.util.Stack
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class StackSolutions : StackProblems {

    // [4,5,2,25] -> [5,25,25,-1]
    override fun nearestGreaterToRight(items: List<Int>) {
        val stack = Stack<Int>()
        val result = items.toMutableList()
        for (i in items.lastIndex downTo 0) {
            if (stack.isEmpty()) {
                result[i] = -1
            } else if (stack.peek() > items[i]) {
                result[i] = stack.peek()
            } else {
                while (stack.isNotEmpty() && stack.peek() <= items[i]) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    result[i] = -1
                } else {
                    result[i] = stack.peek()
                }
            }
            stack.push(items[i])
        }
        println(result)
    }

    // [4,5,2,25] -> [-1,-1,5,-1]
    override fun nearestGreaterToLeft(items: List<Int>) {
        val stack = Stack<Int>()
        val result = items.toMutableList()
        items.forEachIndexed { index, item ->
            if (stack.isEmpty()) {
                result[index] = -1
            } else if (stack.peek() > item) {
                result[index] = stack.peek()
            } else {
                while (stack.isNotEmpty() && stack.peek() <= item) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    result[index] = -1
                } else {
                    result[index] = stack.peek()
                }
            }
            stack.push(item)
        }
        println(result)
    }

    // [4,5,2,25] -> [2,2,-1,-1]
    override fun nearestSmallerToRight(items: List<Int>) {
        val stack = Stack<Int>()
        val result = items.toMutableList()
        for (i in items.lastIndex downTo 0) {
            if (stack.isEmpty()) {
                result[i] = -1
            } else if (stack.peek() < items[i]) {
                result[i] = stack.peek()
            } else {
                while (stack.isNotEmpty() && stack.peek() >= items[i]) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    result[i] = -1
                } else {
                    result[i] = stack.peek()
                }
            }
            stack.push(items[i])
        }
        println(result)
    }

    // [4,5,2,25] -> [-1,-1,-1,2]
    override fun nearestSmallerToLeft(items: List<Int>) {
        val stack = Stack<Int>()
        val result = items.toMutableList()
        items.forEachIndexed { index, item ->
            if (stack.isEmpty()) {
                result[index] = -1
            } else if (stack.peek() < item) {
                result[index] = stack.peek()
            } else {
                while (stack.isNotEmpty() && stack.peek() >= item) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    result[index] = -1
                } else {
                    result[index] = stack.peek()
                }
            }
            stack.push(item)
        }
        println(result)
    }

    // [3, 0, 2, 0, 4]
    // [4, 4, 4, 4, 4]
    // [3, 3, 3, 3, 4]
    override fun rainWaterTrapping(items: List<Int>) {
        val stackForRight = Stack<Int>()
        val nearestGreaterToRight = items.toMutableList()
        for (i in items.lastIndex downTo 0) {
            if (stackForRight.isEmpty()) {
                nearestGreaterToRight[i] = items[i]
            } else if (stackForRight.peek() >= items[i]) {
                nearestGreaterToRight[i] = stackForRight.peek()
            } else {
                while (stackForRight.isNotEmpty() && stackForRight.peek() < items[i]) {
                    stackForRight.pop()
                }
                if (stackForRight.isEmpty()) {
                    nearestGreaterToRight[i] = items[i]
                } else {
                    nearestGreaterToRight[i] = stackForRight.peek()
                }
            }
            stackForRight.push(items[i])
            if (i < items.lastIndex) {
                nearestGreaterToRight[i] =
                    max(nearestGreaterToRight[i], nearestGreaterToRight[i + 1])
            }
        }

        val stackForLeft = Stack<Int>()
        val nearestGreaterToLeft = items.toMutableList()
        items.forEachIndexed { index, item ->
            if (stackForLeft.isEmpty()) {
                nearestGreaterToLeft[index] = item
            } else if (stackForLeft.peek() >= item) {
                nearestGreaterToLeft[index] = stackForLeft.peek()
            } else {
                while (stackForLeft.isNotEmpty() && stackForLeft.peek() < item) {
                    stackForLeft.pop()
                }
                if (stackForLeft.isEmpty()) {
                    nearestGreaterToLeft[index] = item
                } else {
                    nearestGreaterToLeft[index] = stackForLeft.peek()
                }
            }
            stackForLeft.push(item)
            if (index > 0) {
                nearestGreaterToLeft[index] =
                    max(nearestGreaterToLeft[index], nearestGreaterToLeft[index - 1])
            }
        }

        val waterHeight = items.toMutableList()
        for (i in 0..waterHeight.lastIndex) {
            waterHeight[i] = min(nearestGreaterToRight[i], nearestGreaterToLeft[i])
        }
        var result = 0
        for (i in 0..items.lastIndex) {
            result += (waterHeight[i] - items[i])
        }

        println(result)
    }

    // [6, 2, 5, 4, 5, 1, 6]
    // [2, 1, 4, 1, 1, -1, -1]
    // [-1, -1, 2, 2, 4, -1, 1]
    // -> 12
    override fun maximumAreaHistogram(items: List<Int>) {
        val stackForRightIndex = Stack<Int>()
        val nearestSmallerToRightIndex = items.toMutableList()
        for (i in items.lastIndex downTo 0) {
            if (stackForRightIndex.isEmpty()) {
                nearestSmallerToRightIndex[i] = items.size
            } else if (items[stackForRightIndex.peek()] <= items[i]) {
                nearestSmallerToRightIndex[i] = stackForRightIndex.peek()
            } else {
                while (stackForRightIndex.isNotEmpty() && items[stackForRightIndex.peek()] > items[i]) {
                    stackForRightIndex.pop()
                }
                if (stackForRightIndex.isEmpty()) {
                    nearestSmallerToRightIndex[i] = items.size
                } else {
                    nearestSmallerToRightIndex[i] = stackForRightIndex.peek()
                }
            }
            stackForRightIndex.push(i)
        }

        val stackForLeftIndex = Stack<Int>()
        val nearestSmallerToLeftIndex = items.toMutableList()
        items.forEachIndexed { index, item ->
            if (stackForLeftIndex.isEmpty()) {
                nearestSmallerToLeftIndex[index] = -1
            } else if (items[stackForLeftIndex.peek()] <= item) {
                nearestSmallerToLeftIndex[index] = stackForLeftIndex.peek()
            } else {
                while (stackForLeftIndex.isNotEmpty() && items[stackForLeftIndex.peek()] > item) {
                    stackForLeftIndex.pop()
                }
                if (stackForLeftIndex.isEmpty()) {
                    nearestSmallerToLeftIndex[index] = -1
                } else {
                    nearestSmallerToLeftIndex[index] = stackForLeftIndex.peek()
                }
            }
            stackForLeftIndex.push(index)
        }

        var result = Int.MIN_VALUE
        for (i in 0..items.lastIndex) {
            var tempResult = (nearestSmallerToRightIndex[i] - nearestSmallerToLeftIndex[i])
            tempResult--
            tempResult *= items[i]
            result = max(result, tempResult)
        }

        println(result)
    }

    // [100, 80, 60, 70, 60, 75, 85]
    override fun stockSpan(items: List<Int>) {
        val stack = Stack<Int>()
        val nearestGreaterToLeftIndex = items.toMutableList()
        items.forEachIndexed { index, item ->
            if (stack.isEmpty()) {
                nearestGreaterToLeftIndex[index] = index
            } else if (items[stack.peek()] >= item) {
                nearestGreaterToLeftIndex[index] = stack.peek()
            } else {
                while (stack.isNotEmpty() && items[stack.peek()] < item) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    nearestGreaterToLeftIndex[index] = index
                } else {
                    nearestGreaterToLeftIndex[index] = stack.peek()
                }
            }
            stack.push(index)
        }

        val result = items.toMutableList()
        for (i in 0..items.lastIndex) {
            result[i] = i - nearestGreaterToLeftIndex[i]
        }

        println(result)
    }

    override fun binaryMatrixMaximumAreaHistogram(items: List<List<Int>>) {
        return
        // TODO Sachin
    }

    // 53+62/*35*+ -> 39
    override fun postfixEvaluation(expression: String) {
        val stack = Stack<Int>()
        expression.forEach {
            if (it.isDigit()) {
                stack.push(it.digitToInt())
            } else {
                val b = stack.pop()
                val a = stack.pop()
                val c = if (it == '+') {
                    a + b
                } else if (it == '-') {
                    a - b
                } else if (it == '*') {
                    a * b
                } else if (it == '/') {
                    a / b
                } else if (it == '^') {
                    a.toDouble().pow(b).toInt()
                } else {
                    throw Exception("Unknown Operator")
                }
                stack.push(c)
            }
        }
        val result = stack.peek()
        println(result)
    }

    // [()]{}{[()()]()}
    override fun balancedParenthesis(expression: String) {
        val stack = Stack<Char>()
        expression.forEach {
            if (it == '{' || it == '[' || it == '(') {
                stack.push(it)
            } else if (stack.isNotEmpty()) {
                if (it == '}' && stack.peek() == '{') {
                    stack.pop()
                } else if (it == ']' && stack.peek() == '[') {
                    stack.pop()
                } else if (it == ')' && stack.peek() == '(') {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            } else {
                stack.push(it)
            }
        }
        val result = stack.isEmpty()
        println(result)
    }
}
