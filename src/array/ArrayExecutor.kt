package array

object ArrayExecutor : ArrayProblems by ArraySolutions() {

    operator fun invoke() {
        pairSum()
        tripletSum()
        firstRepeatingElement()
        firstMissingElement()
        unionAndIntersectionOfSortedArray()
        minimizeTheMaximumDifference()
    }
}