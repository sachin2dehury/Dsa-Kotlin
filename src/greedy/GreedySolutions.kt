package greedy

import java.util.PriorityQueue

class GreedySolutions : GreedyProblems {

    override fun jobSchedulingProblem(items: List<Job>, time: Int) {
        val priorityQueue = PriorityQueue<Job> { a, b -> b.profit - a.profit }
        val timeSlot = Array<Job?>(time) { null }

        priorityQueue.addAll(items)

        while (priorityQueue.isNotEmpty()) {
            val job = priorityQueue.poll()
            var deadline = job.deadline
            while (deadline > 0 && timeSlot[deadline - 1] != null) {
                deadline--
            }
            if (deadline > 0 && timeSlot[deadline - 1] == null) {
                timeSlot[deadline - 1] = job
            }
        }

        println(timeSlot.toList())
        println(timeSlot.sumOf { it?.profit ?: 0 })
    }
}