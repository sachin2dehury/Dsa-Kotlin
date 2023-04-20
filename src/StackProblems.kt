import java.util.Stack
import kotlin.math.max

object StackProblems {

    // [4,5,2,25] -> [5,25,25,-1]
    fun nearestGreaterToRight(items: List<Int> = listOf(4, 5, 2, 25)) {
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
    fun nearestGreaterToLeft(items: List<Int> = listOf(4, 5, 2, 25)) {
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
    fun nearestSmallerToRight(items: List<Int> = listOf(4, 5, 2, 25)) {
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
    fun nearestSmallerToLeft(items: List<Int> = listOf(4, 5, 2, 25)) {
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
    fun rainWaterTrapping(items: List<Int> = listOf(3, 0, 2, 0, 4)) {

    }

    // [6, 2, 5, 4, 5, 1, 6]
    // [2, 1, 4, 1, 1, -1, -1]
    // [-1, -1, 2, 2, 4, -1, 1]
    // -> 12
    fun maximumAreaHistogram(items: List<Int> = listOf(6, 2, 5, 4, 5, 1, 6)) {
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

}

fun main() {
    StackProblems.nearestGreaterToRight()
    StackProblems.nearestGreaterToLeft()
    StackProblems.nearestSmallerToRight(listOf(6, 2, 5, 4, 5, 1, 6))
    StackProblems.nearestSmallerToLeft(listOf(6, 2, 5, 4, 5, 1, 6))
    StackProblems.maximumAreaHistogram()
}