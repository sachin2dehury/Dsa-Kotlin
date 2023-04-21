package heap

import java.util.PriorityQueue

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

    override fun sortKSortedList(items: List<Int>, k: Int) {
        TODO("Not yet implemented")
    }

    override fun kClosestElement(items: List<Int>, k: Int) {
        TODO("Not yet implemented")
    }

    override fun kClosestToOrigin(items: List<Pair<Int, Int>>, k: Int) {
        TODO("Not yet implemented")
    }

    override fun minimizeConnectingRopes(items: List<Int>, k: Int) {
        TODO("Not yet implemented")
    }

    override fun sumOfElementsBetweenK1andK2(items: List<Int>, k: Int) {
        TODO("Not yet implemented")
    }
}