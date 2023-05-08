package greedy

interface GreedyProblems {

    fun jobSchedulingProblem(
        items: List<Job> = listOf(
            Job(1, 9, 15),
            Job(2, 2, 2),
            Job(3, 5, 18),
            Job(4, 7, 1),
            Job(5, 4, 25),
            Job(6, 2, 20),
            Job(7, 5, 8),
            Job(8, 7, 10),
            Job(9, 4, 12),
            Job(10, 3, 5)
        ), time: Int = 15
    )
}