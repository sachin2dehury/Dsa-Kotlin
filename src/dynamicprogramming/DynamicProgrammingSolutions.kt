package dynamicprogramming

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class DynamicProgrammingSolutions : DynamicProgrammingProblems {

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

    private var diameterOfBinaryTreeResult = Int.MIN_VALUE

    override fun diameterOfBinaryTree(node: Node?) {
        diameterOfBinaryTreeResult = 0
        diameterOfBinaryTreeInternal(node)
        println(diameterOfBinaryTreeResult)
    }

    private fun diameterOfBinaryTreeInternal(node: Node?): Int {
        if (node == null) return 0
        val right = diameterOfBinaryTreeInternal(node.right)
        val left = diameterOfBinaryTreeInternal(node.left)

        val diameterViaCurrent = right + left + 1
        diameterOfBinaryTreeResult = max(diameterOfBinaryTreeResult, diameterViaCurrent)

        return 1 + max(left, right)
    }

    override fun eggDroppingProblem(floorCount: Int, eggCount: Int) {
        val cache = Array(floorCount + 1) { Array(eggCount + 1) { Int.MAX_VALUE } }

        for (i in 0..floorCount) {
            for (j in 0..eggCount) {
                if (j <= 1) {
                    cache[i][j] = j
                } else if (i <= 1) {
                    cache[i][j] = i
                } else {
                    for (k in 1..i) {
                        val drops = max(cache[k - 1][j - 1], cache[i - k][j]) + 1
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

    // 10, 30, 5, 60
    override fun matrixChainMultiplication(items: List<Int>) {
        val cache = Array(items.lastIndex) { Array(items.lastIndex) { Int.MAX_VALUE } }

        for (l in 0 until items.lastIndex) {
            for (i in 0 until items.lastIndex - l) {
                val j = i + l
                if (l == 0) {
                    cache[i][j] = 0
                } else {
                    for (k in i until j) {
                        val temp = cache[i][k] + cache[k + 1][j] + items[i] * items[k + 1] * items[j + 1]
                        cache[i][j] = min(cache[i][j], temp)
                    }
                }
            }
        }

        val result = cache[0][items.lastIndex - 1]

        println(result)
    }

    override fun maximumNumberOfWaysToChangeCoins(items: List<Int>, sum: Int) {
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
                    cache[i][j] = cache[i][j - 1] + cache[i - items[j - 1]][j]
                }
            }
        }

        val result = cache[sum][items.size]
        println(result)
    }

    private var maximumPathSumOfBinaryTreeResult = 0

    override fun maximumPathSumOfBinaryTree(node: Node?) {
        maximumPathSumOfBinaryTreeResult = 0
        maximumPathSumOfBinaryTreeInternal(node)
        println(maximumPathSumOfBinaryTreeResult)
    }

    private var maximumPathSumOfBinaryTreeLeafNodeToLeafNode = 0
    override fun maximumPathSumOfBinaryTreeLeafToLeafNode(node: Node?) {
        maximumPathSumOfBinaryTreeLeafNodeToLeafNode = 0
        maximumPathSumOfBinaryTreeLeafNodeToLeafNodeInternal(node)
        println(maximumPathSumOfBinaryTreeLeafNodeToLeafNode)
    }

    private fun maximumPathSumOfBinaryTreeLeafNodeToLeafNodeInternal(node: Node?): Int {
        if (node == null) return 0

        val rightSum = maximumPathSumOfBinaryTreeLeafNodeToLeafNodeInternal(node.right)
        val leftSum = maximumPathSumOfBinaryTreeLeafNodeToLeafNodeInternal(node.left)

        return if (node.left == null && node.right == null) {
            node.data
        } else if (node.left == null) {
            node.data + rightSum
        } else if (node.right == null) {
            node.data + leftSum
        } else {
            val sumViaCurrent = leftSum + rightSum + node.data
            maximumPathSumOfBinaryTreeLeafNodeToLeafNode =
                max(maximumPathSumOfBinaryTreeLeafNodeToLeafNode, sumViaCurrent)
            node.data + max(leftSum, rightSum)
        }
    }

    private fun maximumPathSumOfBinaryTreeInternal(node: Node?): Int {
        if (node == null) return 0
        val right = maximumPathSumOfBinaryTreeInternal(node.right)
        val left = maximumPathSumOfBinaryTreeInternal(node.left)

        val pathSumViaCurrent = node.data + left + right
        maximumPathSumOfBinaryTreeResult = max(maximumPathSumOfBinaryTreeResult, pathSumViaCurrent)

        return node.data + max(left, right)
    }

    override fun minimumDifferenceOfSum(items: List<Int>) {
        val totalSum = items.sum()
        val maximumSubsetSum = totalSum / 2

        val cache = Array(items.size + 1) { Array(maximumSubsetSum + 1) { false } }
        var maxPossibleSum = Int.MIN_VALUE

        for (i in 0..items.size) {
            for (j in 0..maximumSubsetSum) {
                if (j == 0) {
                    cache[i][j] = true
                } else if (i == 0) {
                    cache[i][j] = false
                } else if (j < items[i - 1]) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = cache[i - 1][j] || cache[i - 1][j - items[i - 1]]
                }
                if (cache[i][j]) {
                    maxPossibleSum = max(j, maxPossibleSum)
                }
            }
        }

        val result = totalSum - 2 * maxPossibleSum

        println(result)
    }

    override fun minimumInsertionForPalindrome(string: String) {
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

        val lcs = cache[string.length][string.length]
        val result = string.length - lcs
        println(result)
    }

    // [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
    // [0, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3]
    override fun minimumJumpsToReachEnd(items: List<Int>) {
        var maxReach = items.first()
        var steps = if (maxReach > 0) 1 else 0
        var remaining = 0

        for (i in 1 until items.size) {
            if (i <= maxReach && maxReach < i + items[i]) {
                maxReach = i + items[i]
                if (remaining == 0) {
                    steps++
                    remaining = items[i]
                }
                remaining--
                if (maxReach >= items.lastIndex) {
                    break
                }
            }
        }
        println(steps)
    }


    override fun minimumNumberOfCoinsToChange(items: List<Int>, sum: Int) {
        val cache = Array(items.size + 1) { Array(sum + 1) { Int.MAX_VALUE } }

        for (i in 0..items.size) {
            for (j in 0..sum) {
                if (j == 0) {
                    cache[i][j] = 0
                } else if (i == 0) {
                    cache[i][j] = Int.MAX_VALUE
                } else if (j < items[i - 1]) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = min(cache[i - 1][j], 1 + cache[i][j - items[i - 1]])
                }
            }
        }

        val result = cache[items.size][sum]
        println(result)
    }


    override fun minimumNumberOfDeletionForPalindrome(string: String) {
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

        val lcs = cache[string.length][string.length]

        val result = string.length - lcs
        println(result)
    }

    override fun minimumNumberOfInsertAndDeleteToMatch(string1: String, string2: String) {
        val cache = Array(string1.length + 1) { Array(string2.length + 1) { 0 } }

        for (i in 0..string1.length) {
            for (j in 0..string2.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string1[i - 1] == string2[j - 1]) {
                    cache[i][j] = 1 + cache[i - 1][j - 1]
                } else {
                    cache[i][j] = max(cache[i - 1][j], cache[i][j - 1])
                }
            }
        }

        val lcs = cache[string1.length][string2.length]
        val insert = string2.length - lcs
        val delete = string1.length - lcs

        println(insert to delete)
    }

    // nitik
    override fun minimumNumberOfPalindromePartitioning(string: String) {
        val cache = Array(string.length) { Array(string.length) { Int.MAX_VALUE } }

        for (l in 0..string.lastIndex) {
            for (i in 0..string.lastIndex - l) {
                val j = i + l
                if (l <= 1 || string.isPalindrome(i, j)) {
                    cache[i][j] = 0
                } else {
                    for (k in i until j) {
                        val temp = cache[i][k] + cache[k + 1][j] + 1
                        cache[i][j] = min(cache[i][j], temp)
                    }
                }
            }
        }

        val result = cache[0][string.lastIndex]

        println(result)
    }

    private fun String.isPalindrome(start: Int, end: Int): Boolean {
        var i = start
        var j = end
        while (i < j) {
            if (this[i] != this[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }

    override fun printLongestCommonSubsequence(string1: String, string2: String) {
        val cache = Array(string1.length + 1) { Array(string2.length + 1) { 0 } }

        for (i in 0..string1.length) {
            for (j in 0..string2.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string1[i - 1] == string2[j - 1]) {
                    cache[i][j] = 1 + cache[i - 1][j - 1]
                } else {
                    cache[i][j] = max(cache[i][j - 1], cache[i - 1][j])
                }
            }
        }

        var i = string1.length
        var j = string2.length
        var result = ""
        while (i > 0 && j > 0) {
            if (string1[i - 1] == string2[j - 1]) {
                result = string1[i - 1] + result
                i--
                j--
            } else if (cache[i][j - 1] > cache[i - 1][j]) {
                j--
            } else {
                i--
            }
        }

        println(result)
    }

    override fun printShortestCommonSuperSequence(string1: String, string2: String) {
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

        var i = string1.length
        var j = string2.length
        var result = ""
        while (i > 0 && j > 0) {
            if (string1[i - 1] == string2[j - 1]) {
                result = string1[i - 1] + result
                i--
                j--
            } else if (cache[i - 1][j] > cache[i][j - 1]) {
                result = string1[i - 1] + result
                i--
            } else {
                result = string2[j - 1] + result
                j--
            }
        }

        while (i > 0) {
            result = string1[i - 1] + result
            i--
        }

        while (j > 0) {
            result = string2[j - 1] + result
            j--
        }

        println(result)
    }

    override fun rodCuttingProblem(items: List<Int>, length: Int) {
        val cache = Array(items.size + 1) { Array(length + 1) { 0 } }

        for (i in 0..items.size) {
            for (j in 0..length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (i > j) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = max(cache[i - 1][j], cache[i][j - i] + items[i - 1])
                }
            }
        }

        val result = cache[items.size][length]

        println(result)
    }

    override fun patternMatching(string: String, pattern: String) {
        val cache = Array(string.length + 1) { Array(pattern.length + 1) { 0 } }

        for (i in 0..string.length) {
            for (j in 0..pattern.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string[i - 1] == pattern[j - 1]) {
                    cache[i][j] = 1 + cache[i - 1][j - 1]
                } else {
                    cache[i][j] = max(cache[i][j - 1], cache[i - 1][j])
                }
            }
        }

        val result = cache[string.length][pattern.length] == pattern.length

        println(result)
    }

    override fun shortestCommonSuperSequence(string1: String, string2: String) {
        val cache = Array(string1.length + 1) { Array(string2.length + 1) { 0 } }

        for (i in 0..string1.length) {
            for (j in 0..string2.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string1[i - 1] == string2[j - 1]) {
                    cache[i][j] = 1 + cache[i - 1][j - 1]
                } else {
                    cache[i][j] = max(cache[i][j - 1], cache[i - 1][j])
                }
            }
        }

        val result = string1.length + string2.length - cache[string1.length][string2.length]

        println(result)
    }

    override fun subsetSum(items: List<Int>, sum: Int) {
        val cache = Array(items.size + 1) { Array(sum + 1) { false } }

        for (i in 0..items.size) {
            for (j in 0..sum + 1) {
                if (j == 0) {
                    cache[i][j] = true
                } else if (i == 0) {
                    cache[i][j] = false
                } else if (items[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = cache[i - 1][j] || cache[i - 1][j - items[i - 1]]
                }
            }
        }

        val result = cache[items.size][sum]

        println(result)
    }

    override fun targetSum(items: List<Int>, sum: Int) {
        val cache = Array(items.size + 1) { Array(sum + 1) { 0 } }

        for (i in 0..items.size) {
            for (j in 0..sum) {
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

        val result = cache[items.size][sum]

        println(result)
    }

    override fun unboundedKnapsack(items: List<Pair<Int, Int>>, weight: Int) {
        val cache = Array(items.size + 1) { Array(weight + 1) { 0 } }

        for (i in 0..items.size) {
            for (j in 0..weight) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (items[i - 1].second > j) {
                    cache[i][j] = cache[i - 1][j]
                } else {
                    cache[i][j] = max(cache[i - 1][j], items[i - 1].first + cache[i][j - items[i - 1].second])
                }
            }
        }

        val result = cache[items.size][weight]

        println(result)
    }

    override fun minimumEditDistance(string1: String, string2: String) {
        val cache = Array(string1.length + 1) { Array(string2.length + 1) { 0 } }

        for (i in 0..string1.length) {
            for (j in 0..string2.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (string1[i - 1] == string2[j - 1]) {
                    cache[i][j] = 1 + cache[i - 1][j - 1]
                } else {
                    cache[i][j] = max(cache[i][j - 1], cache[i - 1][j])
                }
            }
        }

        val insertOrDelete = abs(string1.length - string2.length)
        val replace = string1.length - cache[string1.length][string2.length]

        val result = insertOrDelete + replace

        println(result)
    }

    override fun longestIncreasingSubsequence(items: List<Int>) {
        val cache = Array(items.size) { 1 }

        for (i in 1..items.lastIndex) {
            for (j in i - 1 downTo 0) {
                if (items[j] < items[i]) {
                    cache[i] = max(cache[j] + 1, cache[i])
                }
            }
        }

        val result = cache[items.lastIndex]
        println(result)
    }

    override fun regularExpressionMatch(pattern: String, string: String) {
        val cache = Array(pattern.length + 1) { Array(string.length + 1) { 0 } }

        for (i in 0..pattern.length) {
            for (j in 0..string.length) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0
                } else if (pattern[i - 1] == string[j - 1] || pattern[i - 1] == '?') {
                    cache[i][j] = 1 + cache[i - 1][j - 1]
                } else if (pattern[i - 1] == '*') {
                    cache[i][j] = max(1 + cache[i - 1][j - 1], max(cache[i - 1][j], cache[i][j - 1]))
                } else {
                    cache[i][j] = max(cache[i - 1][j], cache[i][j - 1])
                }
            }
        }

        println(cache[pattern.length][string.length] == string.length)
    }

    override fun maximumSumRectangularMatrix(items: List<List<Int>>) {
        TODO("Not yet implemented")
    }

    override fun wordBreakProblem(dictionary: Set<String>, string: String) {
        val cache = Array(string.length + 1) { Array(string.length + 1) { false } }

        for (l in 0..string.length) {
            for (i in 0..string.length - l) {
                val j = i + l
                val substring = string.substring(i, j)
                if (dictionary.contains(substring)) {
                    cache[i][j] = true
                } else {
                    for (k in i until j) {
                        val temp = cache[i][k] && cache[k][j]
                        cache[i][j] = cache[i][j] || temp
                    }
                }
            }
        }

        val result = cache[0][string.length]

        println(result)
    }

    override fun countWaysToReachNthStair(n: Int) {
        val cache = Array(n + 1) { 0 }

        for (i in 1..n) {
            if (i <= 2) {
                cache[i] = i
            } else {
                cache[i] = cache[i - 1] + cache[i - 2]
            }
        }

        val result = cache[n]
        println(result)
    }

    override fun boxStackingProblem(boxes: List<Box>) {
        val maxHeap = PriorityQueue<Box> { a, b -> b.l * b.b - a.l * a.b }
        val boxStack = mutableListOf<Box>()

        boxes.forEach {
            maxHeap.add(it)
            maxHeap.add(Box(it.b, it.h, it.l))
            maxHeap.add(Box(it.h, it.l, it.b))
        }

        boxStack.add(maxHeap.poll())
        while (maxHeap.isNotEmpty()) {
            val prev = boxStack.last()
            val newBox = maxHeap.poll()
            if (newBox.b < prev.b && newBox.l < prev.l) {
                boxStack.add(newBox)
            }
        }

        val result = boxStack.sumOf { it.h }
        println(result)
    }

    override fun interleaveString(string1: String, string2: String, string3: String) {
        val cache1 = Array(string1.length + 1) { Array(string3.length + 1) { 0 } }
        val cache2 = Array(string2.length + 1) { Array(string3.length + 1) { 0 } }

        for (i in 0..string1.length) {
            for (j in 0..string3.length) {
                if (i == 0 || j == 0) {
                    cache1[i][j] = 0
                } else if (string1[i - 1] == string3[j - 1]) {
                    cache1[i][j] = cache1[i - 1][j - 1] + 1
                } else {
                    cache1[i][j] = max(cache1[i - 1][j], cache1[i][j - 1])
                }
            }
        }

        for (i in 0..string2.length) {
            for (j in 0..string3.length) {
                if (i == 0 || j == 0) {
                    cache2[i][j] = 0
                } else if (string1[i - 1] == string3[j - 1]) {
                    cache2[i][j] = cache2[i - 1][j - 1] + 1
                } else {
                    cache2[i][j] = max(cache2[i - 1][j], cache2[i][j - 1])
                }
            }
        }

        val match1 = cache1[string1.length][string3.length] == string1.length
        val match2 = cache2[string2.length][string3.length] == string2.length
        val lengthMatch = (string1.length + string2.length) == string3.length
        val result = match1 && match2 && lengthMatch

        println(result)
    }

    override fun totalNumberOfPathsInMatrix(m: Int, n: Int) {
        val cache = Array(m) { Array(n) { 0 } }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) {
                    cache[i][j] = 0
                } else if (i == 0 || j == 0) {
                    cache[i][j] = 1
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1]
                }
            }
        }

        val result = cache[m - 1][n - 1]

        println(result)
    }

    override fun numbersWithoutConsecutive1(n: Int) {
        val cache = Array(n + 1) { 0 }

        for (i in 0..n) {
            if (i <= 2) {
                cache[i] = i + 1
            } else {
                cache[i] = cache[i - 1] + cache[i - 2]
            }
        }

        val result = cache[n]
        println(result)
    }

    override fun longestBitonicSubsequence(items: List<Int>) {
        val increasingCache = Array(items.size) { 1 }
        val decreasingCache = Array(items.size) { 1 }

        for (i in 1..items.lastIndex) {
            for (j in i - 1 downTo 0) {
                if (items[j] < items[i]) {
                    increasingCache[i] = max(increasingCache[j] + 1, increasingCache[i])
                }
            }
        }

        for (i in items.lastIndex - 1 downTo 0) {
            for (j in i + 1..items.lastIndex) {
                if (items[j] < items[i]) {
                    decreasingCache[i] = max(decreasingCache[j] + 1, decreasingCache[i])
                }
            }
        }

        var result = 0

        for (i in items.indices) {
            result = max(result, increasingCache[i] + decreasingCache[i] - 1)
        }

        println(result)
    }
}