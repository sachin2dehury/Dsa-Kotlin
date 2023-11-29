package backtracking

object BacktrackingExecutor : BacktrackingProblems by BacktrackingSolutions() {

    operator fun invoke() {
        permutationOfString()
        nQueenProblem()
    }
}