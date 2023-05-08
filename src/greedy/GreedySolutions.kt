package greedy

import java.util.PriorityQueue

class GreedySolutions : GreedyProblems {

    override fun jobSchedulingProblem(items: List<Job>, time: Int) {
        val maxHeap = PriorityQueue<Job> { a, b -> b.profit - a.profit }

        maxHeap.addAll(items)

        val timeSet = mutableSetOf<Int>()
        val result = Array(time) { -1 }
        var profit = 0

        while (maxHeap.isNotEmpty()) {
            val currentJob = maxHeap.poll()

            var currentDeadline = currentJob.deadline
            while (timeSet.contains(currentDeadline)) {
                currentDeadline--
            }
            if (currentDeadline > 0) {
                timeSet.add(currentDeadline)
                profit += currentJob.profit
                result[currentDeadline - 1] = currentJob.id
            }
        }

        println(profit)
        println(result.toList())
    }
}