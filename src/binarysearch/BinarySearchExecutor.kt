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
        minimumDifferenceElement()
        nextAlphabetInList()

        numberOfRotation(listOf(  2, 3, 6, 12).reversed())
    }
}
