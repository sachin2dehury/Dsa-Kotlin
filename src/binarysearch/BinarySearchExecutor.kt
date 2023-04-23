package binarysearch

object BinarySearchExecutor : BinarySearchProblems by BinarySearchSolutions() {

    operator fun invoke() {
        println("\nBinarySearch :\n")

        print("")
        binarySearch()
        reverseBinarySearch()
        firstOccurrenceOfElement()
        lastOccurrenceOfElement()
        countOfAnElement()
        floorOfAnElement()
        ceilOfAnElement()
    }
}
