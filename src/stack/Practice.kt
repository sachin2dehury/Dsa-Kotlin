package stack

import java.util.Stack
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class Practice : StackProblems {
    override fun nearestGreaterToRight(items: List<Int>) {
        val result = Array(items.size) { 0 }
        val stack = Stack<Int>()
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
                } else if (stack.peek() > items[i]) {
                    result[i] = stack.peek()
                }
            }
            stack.push(items[i])
        }
        println(result.toList())
    }

    override fun nearestGreaterToLeft(items: List<Int>) {
        val result = Array(items.size) { 0 }
        val stack = Stack<Int>()
        for (i in 0 until items.size) {
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
                } else if (stack.peek() > items[i]) {
                    result[i] = stack.peek()
                }
            }
            stack.push(items[i])
        }
        println(result.toList())
    }

    override fun nearestSmallerToRight(items: List<Int>) {
        val stack = Stack<Int>()
        val result = Array(items.size) { 0 }
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
                } else if (stack.peek() < items[i]) {
                    result[i] = stack.peek()
                }
            }
            stack.push(items[i])
        }
        println(result.toList())
    }

    override fun nearestSmallerToLeft(items: List<Int>) {
        val stack = Stack<Int>()
        val result = Array(items.size) { 0 }
        for (i in 0 until items.size) {
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
                } else if (stack.peek() < items[i]) {
                    result[i] = stack.peek()
                }
            }
            stack.push(items[i])
        }
        println(result.toList())
    }

    override fun rainWaterTrapping(items: List<Int>) {
        val stackRight = Stack<Int>()
        val resultRight = Array(items.size) { 0 }
        for (i in items.lastIndex downTo 0) {
            if (stackRight.isEmpty()) {
                resultRight[i] = items[i]
            } else if (stackRight.peek() > items[i]) {
                resultRight[i] = stackRight.peek()
            } else {
                while (stackRight.isNotEmpty() && stackRight.peek() <= items[i]) {
                    stackRight.pop()
                }
                if (stackRight.isEmpty()) {
                    resultRight[i] = items[i]
                } else if (stackRight.peek() > items[i]) {
                    resultRight[i] = stackRight.peek()
                }
            }
            stackRight.push(items[i])
            if (i < items.lastIndex) {
                resultRight[i] = max(resultRight[i], resultRight[i + 1])
            }
        }

        val stackLeft = Stack<Int>()
        val resultLeft = Array(items.size) { 0 }
        for (i in 0 until items.size) {
            if (stackLeft.isEmpty()) {
                resultLeft[i] = items[i]
            } else if (stackLeft.peek() > items[i]) {
                resultLeft[i] = stackLeft.peek()
            } else {
                while (stackLeft.isNotEmpty() && stackLeft.peek() <= items[i]) {
                    stackLeft.pop()
                }
                if (stackLeft.isEmpty()) {
                    resultLeft[i] = items[i]
                } else if (stackLeft.peek() > items[i]) {
                    resultLeft[i] = stackLeft.peek()
                }
            }
            stackLeft.push(items[i])
            if (i > 0) {
                resultLeft[i] = max(resultLeft[i], resultLeft[i - 1])
            }
        }

        val result = Array(items.size) { 0 }
        for (i in 0 until items.size) {
            result[i] = min(resultRight[i], resultLeft[i]) - items[i]
        }
        println(result.sum())
    }

    override fun maximumAreaHistogram(items: List<Int>) {
        val resultRight = Array(items.size) { 0 }
        val stackRight = Stack<Int>()

        for (i in items.lastIndex downTo 0) {
            if (stackRight.isEmpty()) {
                resultRight[i] = items.size
            } else if (items[stackRight.peek()] < items[i]) {
                resultRight[i] = stackRight.peek()
            } else {
                while (stackRight.isNotEmpty() && items[stackRight.peek()] >= items[i]) {
                    stackRight.pop()
                }
                if (stackRight.isEmpty()) {
                    resultRight[i] = i
                } else if (items[stackRight.peek()] < items[i]) {
                    resultRight[i] = stackRight.peek()
                }
            }
            stackRight.push(i)
        }

        val resultLeft = Array(items.size) { 0 }
        val stackLeft = Stack<Int>()

        for (i in 0..items.lastIndex) {
            if (stackLeft.isEmpty()) {
                resultLeft[i] = -1
            } else if (items[stackLeft.peek()] < items[i]) {
                resultLeft[i] = stackLeft.peek()
            } else {
                while (stackLeft.isNotEmpty() && items[stackLeft.peek()] >= items[i]) {
                    stackLeft.pop()
                }
                if (stackLeft.isEmpty()) {
                    resultLeft[i] = i
                } else if (items[stackLeft.peek()] < items[i]) {
                    resultLeft[i] = stackLeft.peek()
                }
            }
            stackLeft.push(i)
        }

        val result = Array(items.size) { 0 }
        for (i in result.indices) {
            result[i] = (abs(resultRight[i] - resultLeft[i]) - 1) * items[i]
        }
        println(result.max())
    }

    override fun stockSpan(items: List<Int>) {
        val stack = Stack<Int>()
        val result = Array(items.size) { 0 }
        for (i in 0..items.lastIndex) {
            if (stack.isEmpty()) {
                result[i] = 1
            } else if (items[stack.peek()] > items[i]) {
                result[i] = (i - stack.peek())
            } else {
                while (stack.isNotEmpty() && items[stack.peek()] <= items[i]) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    result[i] = 1
                } else if (items[stack.peek()] > items[i]) {
                    result[i] = (i - stack.peek())
                }
            }
            stack.push(i)
        }
        println(result.toList())
    }

    override fun binaryMatrixMaximumAreaHistogram(items: List<List<Int>>) {
        val result = Array(items.size) { 0 }

    }

    override fun postfixEvaluation(expression: String) {
        val stack = Stack<Int>()
        expression.forEach {
            if (it.isDigit()) {
                stack.push(it.digitToInt())
            } else {
                val a = stack.pop()
                val b = stack.pop()
                val c = when (it) {
                    '+' -> {
                        a + b
                    }

                    '*' -> {
                        a * b
                    }

                    '-' -> {
                        a - b
                    }

                    '/' -> {
                        a / b
                    }

                    '^' -> {
                        a.toFloat().pow(b).toInt()
                    }

                    else -> {
                        throw Exception("Unknown")
                    }
                }
                stack.push(c)
            }
        }
        println(stack.peek())
    }

    override fun balancedParenthesis(expression: String) {
        val stack = Stack<Char>()
        expression.forEach {
            if (it == ')' && stack.peek() == '(') {
                stack.pop()
            } else if (it == '}' && stack.peek() == '{') {
                stack.pop()
            } else if (it == ']' && stack.peek() == '[') {
                stack.pop()
            } else {
                stack.push(it)
            }
        }

        println(stack.isEmpty())
    }
}