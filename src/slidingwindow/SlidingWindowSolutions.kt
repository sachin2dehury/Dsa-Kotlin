package slidingwindow

import java.util.PriorityQueue
import kotlin.math.max

class SlidingWindowSolutions : SlidingWindowProblems {

    override fun countOfOccurrencesOfAnagram(string: String, pattern: String) {
        val patternMap = mutableMapOf<Char, Int>()
        pattern.forEach {
            patternMap[it] = (patternMap[it] ?: 0) + 1
        }

        var result = 0

        string.forEachIndexed { index, char ->

            if (index >= string.length) {
                val windowChar = string[index - string.length]
                patternMap[windowChar]?.let {
                    patternMap[char] = it + 1
                }
            }

            patternMap[char]?.let {
                patternMap[char] = it - 1
            }

            if (patternMap.values.all { it == 0 }) {
                result++
            }
        }

        println(result)
    }

    override fun firstNegativeNumberInWindow(items: List<Int>, windowSize: Int) {
        val queue = ArrayDeque<Int>(windowSize)
        val result = mutableListOf<Int>()

        items.forEachIndexed { index, item ->

            val windowStartIndex = index - windowSize

            if (windowStartIndex >= 0) {
                if (queue.firstOrNull() == windowStartIndex) {
                    queue.removeFirst()
                }
            }

            if (item < 0) {
                queue.add(index)
            }

            if (index + 1 >= windowSize) {
                if (queue.isNotEmpty()) {
                    result.add(items[queue.first()])
                } else {
                    result.add(0)
                }
            }
        }

        println(result)
    }

    override fun longestSubArrayOfSumK(items: List<Int>, k: Int) {
        val sumMap = mutableMapOf<Int, Int>()
        var sum = 0
        var result = 0
        sumMap[sum] = -1
        items.forEachIndexed { index, item ->
            sum += item

            if (sumMap[sum] == null) {
                sumMap[sum] = index
            }

            sumMap[sum - k]?.let {
                result = max(result, (index - it))
            }
        }

        println(result)
    }

    override fun longestSubStringWithKUniqueChar(string: String, k: Int) {
        val charMap = mutableMapOf<Char, Int>()
        var result = 0
        var windowStartIndex = 0
        string.forEachIndexed { index, char ->
            charMap[char] = (charMap[char] ?: 0) + 1

            while (charMap.size > k) {
                val windowChar = string[windowStartIndex]
                charMap[windowChar]?.let {
                    charMap[windowChar] = it - 1
                }

                windowStartIndex++

                if (charMap[windowChar] == 0) {
                    charMap.remove(windowChar)
                }
            }

            if (charMap.size == k) {
                result = max(result, 1 + index - windowStartIndex)
            }
        }

        println(result)
    }

    override fun longestSubStringWithoutRepeatingChar(string: String) {
        val charSet = mutableSetOf<Char>()
        var result = 0
        var windowStartIndex = 0

        string.forEachIndexed { index, char ->
            if (charSet.contains(char)) {
                charSet.clear()
                result = max(result, index - windowStartIndex)
                windowStartIndex = index
            }

            charSet.add(char)
            result = max(result, 1 + index - windowStartIndex)
        }

        println(result)
    }

    override fun maximumElementOfAllSubArray(items: List<Int>, windowSize: Int) {
        val maxHeap = PriorityQueue<Int>(windowSize) { a, b -> b - a }
        val result = mutableListOf<Int>()

        items.forEachIndexed { index, item ->
            maxHeap.add(item)

            val windowStartIndex = index - windowSize
            if (windowStartIndex >= 0) {
                maxHeap.remove(items[windowStartIndex])
            }

            if (index + 1 >= windowSize) {
                result.add(maxHeap.peek())
            }
        }

        println(result)
    }

    override fun maximumSumOfArrayOfSizeK(items: List<Int>, windowSize: Int) {
        var result = 0
        var sum = 0

        items.forEachIndexed { index, item ->
            sum += item

            val windowStartIndex = index - windowSize
            if (windowStartIndex >= 0) {
                sum -= items[windowStartIndex]
            }

            if (index + 1 > windowSize) {
                result = max(result, sum)
            }
        }

        println(result)
    }

    override fun minimumWindowSubString(string: String, pattern: String) {
        val patternMap = mutableMapOf<Char, Int>()
        pattern.forEach {
            patternMap[it] = (patternMap[it] ?: 0) + 1
        }

        var windowStartIndex = 0
        var maxLength = Int.MAX_VALUE
        var result = ""

        string.forEachIndexed { index, char ->
            patternMap[char]?.let {
                patternMap[char] = it - 1
            }

            while (patternMap.values.all { it <= 0 }) {
                if (maxLength >= 1 + index - windowStartIndex) {
                    maxLength = 1 + index - windowStartIndex
                    result = string.substring(windowStartIndex, index + 1)
                }
                val windowChar = string[windowStartIndex]
                patternMap[windowChar]?.let {
                    patternMap[windowChar] = it + 1
                }
                windowStartIndex++
            }
        }

        println(result)
    }

    override fun pickToys(string: String, toysWindowSize: Int) {
        val toyMap = mutableMapOf<Char, Int>()
        var windowStartIndex = 0
        var result = 0
        string.forEachIndexed { index, toy ->
            toyMap[toy] = (toyMap[toy] ?: 0) + 1

            while (toyMap.size > toysWindowSize) {
                val windowStartToy = string[windowStartIndex]
                toyMap[windowStartToy]?.let {
                    toyMap[windowStartToy] = it - 1
                }

                windowStartIndex++

                if (toyMap[windowStartToy] == 0) {
                    toyMap.remove(windowStartToy)
                }
            }

            result = max(result, 1 + index - windowStartIndex)
        }

        println(result)
    }
}