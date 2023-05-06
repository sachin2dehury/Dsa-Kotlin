package dynamicprogramming

import kotlin.math.max

class DynamicProgrammingSolutions : DynamicProgrammingProblems {

    // [2, -1, 4, -1, -2, 1, 5, -3]
    // [2,  1, 5,  4,  2, 3, 8,  5]
    override fun largestSumContiguousSubArray(items: List<Int>) {
        val cache = Array(items.size) { Int.MIN_VALUE }

        var windowStartIndex = 0
        var windowEndIndex = 0

        cache[0] = items.first()
        var result = cache.first()

        for (i in 1 until items.size) {
            if (cache[i - 1] < 0) {
                windowStartIndex = i
                cache[i] = items[i]
            } else {
                cache[i] = cache[i - 1] + items[i]
            }
            if (cache[i] > result) {
                result = cache[i]
                windowEndIndex = i
            }
        }

        println(result)
        println(items.subList(windowStartIndex, windowEndIndex + 1))
    }

    // [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
    // [0, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3]
    override fun minimumJumpsToReachEnd(items: List<Int>) {
        var maxReached = 0
        var minSteps = 0
        val cache = Array(items.size) { it }

        for (i in 1 until items.size) {
            cache[i] = max(i + items[i], cache[i - 1])
            if (maxReached < cache[i]) {
                maxReached = cache[i]
                minSteps++
            }

            if (maxReached <= i) {
                println("Can't Reach")
                return
            }

            if (maxReached >= items.lastIndex) {
                break
            }

        }

        println(minSteps)
    }
}