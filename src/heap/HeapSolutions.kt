package heap

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class HeapSolutions : HeapProblems {
    override fun kSmallestElement(items: List<Int>, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(k) { a, b -> b - a }
        items.forEach {
            maxHeap.add(it)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        val result = maxHeap.peek()
        println(result)
        return result
    }

    override fun kLargestElement(items: List<Int>, k: Int): Int {
        val minHeap = PriorityQueue<Int>(k) { a, b -> a - b }
        items.forEach {
            minHeap.add(it)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        val result = minHeap.peek()
        println(result)
        return result
    }

    override fun topKFrequentNumbers(items: List<Int>, k: Int): List<Int> {
        val minHeap = PriorityQueue<Pair<Int, Int>>(k) { a, b -> a.second - b.second }
        val frequencyMap = mutableMapOf<Int, Int>()

        items.forEach {
            frequencyMap[it] = (frequencyMap[it] ?: 0) + 1
        }

        frequencyMap.forEach {
            minHeap.add(it.toPair())
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        val result = mutableListOf<Int>()
        while (minHeap.isNotEmpty()) {
            val item = minHeap.poll().first
            result.add(item)
        }

        println(result)
        return result
    }

    override fun frequencySortDescending(items: List<Int>, k: Int): List<Int> {
        val maxHeap = PriorityQueue<Pair<Int, Int>>(k) { a, b -> b.second - a.second }
        val frequencyMap = mutableMapOf<Int, Int>()

        items.forEach {
            frequencyMap[it] = (frequencyMap[it] ?: 0) + 1
        }

        frequencyMap.forEach {
            maxHeap.add(it.toPair())
        }

        val result = mutableListOf<Int>()
        while (maxHeap.isNotEmpty()) {
            val item = maxHeap.poll().first
            result.add(item)
        }

        println(result)
        return result
    }

    override fun sortKSortedList(items: List<Int>, k: Int): List<Int> {
        val minHeap = PriorityQueue<Int>(k) { a, b -> a - b }
        val result = mutableListOf<Int>()

        items.forEach {
            minHeap.add(it)
            if (minHeap.size > k) {
                val item = minHeap.poll()
                result.add(item)
            }
        }

        while (minHeap.isNotEmpty()) {
            val item = minHeap.poll()
            result.add(item)
        }

        println(result)
        return result
    }

    override fun kClosestElement(items: List<Int>, k: Int, item: Int): List<Int> {
        val max = PriorityQueue<Pair<Int, Int>>(k) { a, b -> b.second - a.second }
        val tempItems = items.map { it to abs(it - item) }

        tempItems.forEach {
            if (it.first != item) {
                max.add(it)
            }
            if (max.size > k) {
                max.poll()
            }
        }

        val result = mutableListOf<Int>()
        while (max.isNotEmpty()) {
            val tempItem = max.poll().first
            result.add(tempItem)
        }

        println(result)
        return result
    }

    override fun kClosestToOrigin(items: List<Pair<Int, Int>>, k: Int): List<Pair<Int, Int>> {
        val maxHeap = PriorityQueue<Pair<Int, Int>>(k) { a, b -> b.second - a.second }
        val tempItems = items.map { it.second * it.second + it.first * it.first }

        tempItems.forEachIndexed { index, item ->
            maxHeap.add(index to item)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        val result = mutableListOf<Pair<Int, Int>>()
        while (maxHeap.isNotEmpty()) {
            val item = items[maxHeap.poll().first]
            result.add(item)
        }

        println(result)
        return result
    }

    override fun minimizeConnectingRopes(items: List<Int>): Int {
        val minHeap = PriorityQueue<Int> { a, b -> a - b }
        var result = 0

        items.forEach {
            minHeap.add(it)
        }

        while (minHeap.size > 1) {
            val item1 = minHeap.poll()
            val item2 = minHeap.poll()
            val newItem = item1 + item2
            minHeap.add(newItem)
            result += newItem
        }

        println(result)
        return result
    }

    override fun sumOfElementsBetweenSmallestK1andK2(items: List<Int>, k1: Int, k2: Int): Int {
        val maxHeapK1 = PriorityQueue<Int>(k1) { a, b -> b - a }
        val maxHeapK2 = PriorityQueue<Int>(k2) { a, b -> b - a }

        items.forEach {
            maxHeapK1.add(it)
            maxHeapK2.add(it)
            if (maxHeapK1.size > k1) {
                maxHeapK1.poll()
            }
            if (maxHeapK2.size > k2) {
                maxHeapK2.poll()
            }
        }

        val smallestK1 = maxHeapK1.peek()
        val smallestK2 = maxHeapK2.peek()

        val minValue = min(smallestK1, smallestK2)
        val maxValue = max(smallestK1, smallestK2)

        var result = 0

        items.forEach {
            if (it > minValue && it < maxValue) {
                result += it
            }
        }

        println(result)
        return result
    }
}
