package array

import kotlin.math.min

class ArraySolutions : ArrayProblems {
    override fun pairSum(items: ArrayList<Int>, sum: Int) {
        val map = mutableMapOf<Int, Int>()
        var result = 0

        items.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        items.forEach {
            val diff = sum - it
            map[it] = map[it]!! - 1
            if ((map[diff] ?: 0) > 0) {
                result += map[diff]!!
            }
            map[it] = map[it]!! + 1
        }
        result /= 2

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
        val sortedList = items.sorted()
        var result = 1
        sortedList.forEach {
            if (it == result) {
                result ++
            }
        }

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
}