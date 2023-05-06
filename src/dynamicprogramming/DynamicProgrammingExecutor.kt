package dynamicprogramming

object DynamicProgrammingExecutor: DynamicProgrammingProblems by DynamicProgrammingSolutions() {

    operator fun invoke() {

        largestSumContiguousSubArray()
        minimumJumpsToReachEnd()
    }
}