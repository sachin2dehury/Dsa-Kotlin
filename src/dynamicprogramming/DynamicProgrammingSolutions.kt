package dynamicprogramming

import kotlin.math.max
import kotlin.math.min

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


    override fun countOfSubsetSum(items: List<Int>, sum: Int) {
        val cache = Array(sum + 1) { Array(items.size + 1) { 0 } }

        for (i in 0..sum) {
            for (j in 0..items.size) {
                if (i == 0) {
                    cache[i][j] = 1
                } else if (j == 0) {
                    cache[i][j] = 0
                } else if (items[j - 1] > i) {
                    cache[i][j] = cache[i][j - 1]
                } else {
                    cache[i][j] = cache[i][j - 1] + cache[i - items[j - 1]][j - 1]
                }
            }
        }

        println(cache[sum][items.size])
    }

    override fun countOfSubsetWithDifference(items: List<Int>, difference: Int) {
        val totalSum = items.sum()
        val targetSubsetSum = (totalSum - difference) / 2

        val cache = Array(items.size + 1) { Array(targetSubsetSum + 1) { 0 } }

        for (i in 0..items.size) {
            for (j in 0..targetSubsetSum) {
                if (j == 0) {
                    cache[i][j] = 1
                } else if (i == 0) {
                    cache[i][j] = 0
                } else if (items[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i - 1][j - items[i - 1]]
                }
            }
        }

        val result = cache[items.size][targetSubsetSum]

        println(result)
    }

    private var result = 0

    override fun diameterOfBinaryTree(node: Node?): Int {
        if (node == null) return 0
        val right = diameterOfBinaryTree(node.right)
        val left = diameterOfBinaryTree(node.left)

        val diameterViaCurrent = right + left + 1
        result = max(result, diameterViaCurrent)

        return 1 + max(left, right)
    }

    override fun eggDroppingProblem(floorCount: Int, eggCount: Int) {
        val cache = Array(floorCount + 1) { Array(eggCount + 1) { Int.MAX_VALUE } }

        for (i in 0..floorCount) {
            for (j in 0..eggCount) {
                if (j == 0) {
                    cache[i][j] = 0
                } else if (i <= 1 || j == 1) {
                    cache[i][j] = 1
                } else {
                    for (k in 0 until i) {
                        val drops = max(cache[k][j - 1], cache[i - (k + 1)][j]) + 1
                        cache[i][j] = min(cache[i][j], drops)
                    }
                }
            }
        }

        val result = cache[floorCount][eggCount]

        println(result)
    }

    override fun equalSum(items: List<Int>) {
        val totalSum = items.sum()
        var result = 0

        if (totalSum % 2 != 0) {
            println(result)
            return
        }

        val subsetSum = totalSum / 2
        val cache = Array(totalSum + 1) { Array(items.size + 1) { 0 } }

        for (i in 0..subsetSum) {
            for (j in 0..items.size) {
                if (i == 0) {
                    cache[i][j] = 1
                } else if (j == 0) {
                    cache[i][j] = 0
                } else if (i < items[j - 1]) {
                    cache[i][j] = cache[i][j - 1]
                } else {
                    cache[i][j] = cache[i][j - 1] + cache[i - items[j - 1]][j - 1]
                }
            }
        }

        result = cache[subsetSum][items.size]
        println(result)
    }

    override fun knapsack(items: List<Pair<Int, Int>>, weight: Int) {
        val cache = Array(items.size + 1) { Array(weight + 1) { Int.MIN_VALUE } }

        for (i in 0..items.size) {
            for (j in 0..weight) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (j < items[i - 1].second) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = max(cache[i - 1][j], items[i - 1].first + cache[i - 1][j - items[i - 1].second])
                }
            }
        }

        val result = cache[items.size][weight]

        println(result)
    }

    override fun longestCommonSubSequence(string1: String, string2: String) {
        val cache = Array(string1.length + 1) { Array(string2.length + 1) { 0 } }

        for (i in 0..string1.length) {
            for (j in 0..string2.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string1[i - 1] == string2[j - 1]) {
                    cache[i][j] = cache[i - 1][j - 1] + 1
                } else {
                    cache[i][j] = max(cache[i - 1][j], cache[i][j - 1])
                }
            }
        }

        val result = cache[string1.length][string2.length]
        println(result)
    }

    override fun longestCommonSubString(string1: String, string2: String) {
        val cache = Array(string1.length + 1) { Array(string2.length + 1) { 0 } }

        var result = Int.MIN_VALUE

        for (i in 0..string1.length) {
            for (j in 0..string2.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string1[i - 1] == string2[j - 1]) {
                    cache[i][j] = cache[i - 1][j - 1] + 1
                } else {
                    cache[i][j] = 0
                }
                result = max(result, cache[i][j])
            }
        }

        println(result)
    }

    override fun longestPalindromicSubsequence(string: String) {
        val cache = Array(string.length + 1) { Array(string.length + 1) { 0 } }

        for (i in 0..string.length) {
            for (j in 0..string.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string[i - 1] == string[string.length - j]) {
                    cache[i][j] = cache[i - 1][j - 1] + 1
                } else {
                    cache[i][j] = max(cache[i][j - 1], cache[i - 1][j])
                }
            }
        }

        val result = cache[string.length][string.length]
        println(result)
    }

    override fun longestRepeatingSubsequence(string: String) {
        val cache = Array(string.length + 1) { Array(string.length + 1) { 0 } }

        for (i in 0..string.length) {
            for (j in 0..string.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string[i - 1] == string[j - 1] && i != j) {
                    cache[i][j] = cache[i - 1][j - 1] + 1
                } else {
                    cache[i][j] = max(cache[i][j - 1], cache[i - 1][j])
                }
            }
        }

        val result = cache[string.length][string.length]
        println(result)
    }

    override fun matrixChainMultiplication(items: List<Int>) {
        TODO("Not yet implemented")
    }
}