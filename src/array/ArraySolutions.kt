package array

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class ArraySolutions : ArrayProblems {
    override fun pairSum(items: ArrayList<Int>, sum: Int) {
        val map = mutableMapOf<Int, Int>()
        var result = 0

        items.forEach {
            if ((map[sum - it] ?: 0) > 0) {
                result += map[sum - it]!!
            }
            map[it] = (map[it] ?: 0) + 1
        }

        println(result)
    }

    override fun tripletSum(items: ArrayList<Int>, sum: Int) {
        val map = mutableMapOf<Int, Int>()
        var result = 0

        items.forEach {
            map[it] = (map[it] ?: 0) + 1
        }


        items.forEach {
            val pairSum = sum - it
            map[it] = map[it]!! - 1
            items.forEach { item ->
                if ((map[item] ?: 0) > 0) {
                    val diff = pairSum - item
                    map[item] = map[item]!! - 1
                    if ((map[diff] ?: 0) > 0) {
                        result += (map[diff] ?: 0)
                    }
                    map[item] = map[item]!! + 1
                }
            }
            map[it] = map[it]!! + 1
        }

        result /= 6

        println(result)
    }

    override fun firstRepeatingElement(items: ArrayList<Int>) {
        val map = mutableMapOf<Int, Int>()
        var resultIndex = Int.MAX_VALUE
        items.forEachIndexed { index, item ->
            if (map.contains(item)) {
                map[item] = min(map[item]!!, index)
                resultIndex = min(resultIndex, map[item]!!)
            } else {
                map[item] = index
            }
        }

        val result = items[resultIndex]
        println(result)
    }

    override fun firstMissingElement(items: ArrayList<Int>) {
        val set = items.toSet()
        var result = 1
        while (set.contains(result)) {
            result++
        }

        println(result)
    }

    override fun minimizeTheMaximumDifference(items: List<Int>, k: Int) {
        var maxHeight = Int.MIN_VALUE
        var minHeight = Int.MAX_VALUE
        items.forEach {
            maxHeight = max(maxHeight, it)
            minHeight = min(minHeight, it)
        }
        val diff = maxHeight - minHeight

        val avgHeight = (items.sum().toFloat() / items.size).roundToInt()


        maxHeight = Int.MIN_VALUE
        minHeight = Int.MAX_VALUE
        items.forEach {
            var newItem = it
            if (it < avgHeight) {
                newItem += k
            } else {
                newItem -= k
            }

            maxHeight = max(maxHeight, newItem)
            minHeight = min(minHeight, newItem)
        }

        val newDiff = maxHeight - minHeight

        val result = min(newDiff, diff)

        println(result)

    }

    override fun unionAndIntersectionOfSortedArray(array1: ArrayList<Int>, array2: ArrayList<Int>) {
        val union = mutableListOf<Int>()
        val intersection = mutableListOf<Int>()
        var i = 0
        var j = 0

        while (i < array1.size && j < array2.size) {
            if (array1[i] < array2[j]) {
                union.add(array1[i])
                i++
            } else if (array1[i] > array2[j]) {
                union.add(array2[j])
                j++
            } else {
                intersection.add(array1[i])
                union.add(array1[i])
                i++
                j++
            }
        }

        while (i < array1.size) {
            union.add(array1[i])
            i++
        }

        while (j < array2.size) {
            union.add(array2[j])
            j++
        }

        println(union)
        println(intersection)
    }

    override fun printMatrixSpirally(items: List<List<Int>>) {
        val result = mutableListOf<Int>()

        var leftIndex = 0
        var rightIndex = items.first().lastIndex
        var topIndex = 0
        var bottomIndex = items.lastIndex

        while (true) {
            if (leftIndex > rightIndex) break

            for (i in leftIndex..rightIndex) {
                result.add(items[topIndex][i])
            }
            topIndex++

            if (topIndex > bottomIndex) break

            for (i in topIndex..bottomIndex) {
                result.add(items[i][rightIndex])
            }
            rightIndex--

            if (leftIndex > rightIndex) break

            for (i in rightIndex downTo leftIndex) {
                result.add(items[bottomIndex][i])
            }
            bottomIndex--

            if (topIndex > bottomIndex) break
            for (i in bottomIndex downTo topIndex) {
                result.add(items[i][leftIndex])
            }
            leftIndex++
        }

        println(result)
    }

    override fun mergeOverlappingIntervals(items: List<Pair<Int, Int>>) {
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }

        minHeap.addAll(items)

        var counter = 0
        val result = mutableListOf<Pair<Int, Int>>()

        while (minHeap.size > 1 && counter < items.size) {
            counter++
            val firstInterval = minHeap.poll()
            val secondInterval = minHeap.poll()

            if (firstInterval.second >= secondInterval.first) {
                minHeap.add(firstInterval.first to max(firstInterval.second, secondInterval.second))
            } else {
                result.add(firstInterval)
                minHeap.add(secondInterval)
            }
        }

        while (minHeap.isNotEmpty()) {
            result.add(minHeap.poll())
        }

        println(result)
    }
}