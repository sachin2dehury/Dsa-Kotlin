package binarysearch

object BinarySearchExecutor : BinarySearchProblems by BinarySearchSolutions() {

    operator fun invoke() {
        println("\nBinarySearch :\n")

        print("binarySearch : ")
        binarySearch()

        print("reverseBinarySearch : ")
        reverseBinarySearch()

        print("firstOccurrenceOfElement : ")
        firstOccurrenceOfElement()

        print("lastOccurrenceOfElement : ")
        lastOccurrenceOfElement()

        print("countOfAnElement : ")
        countOfAnElement()

        print("floorOfAnElement : ")
        floorOfAnElement()

        print("ceilOfAnElement : ")
        ceilOfAnElement()

        print("minimumDifferenceElement : ")
        minimumDifferenceElement()

        print("nextAlphabetInList : ")
        nextAlphabetInList()

        print("numberOfRotation : ")
        numberOfRotation()

        print("binarySearchInRotatedList : ")
        binarySearchInRotatedList()

        print("peakElement : ")
        peakElement()

        print("firstOccurrenceOfOne : ")
        firstOccurrenceOfOne()

        print("maximumElementInBitonicList : ")
        maximumElementInBitonicList()

        print("binarySearchInBitonicList : ")
        binarySearchInBitonicList()

        print("binarySearchInInfiniteList : ")
        binarySearchInInfiniteList()

        print("binarySearchInNearlySortedList : ")
        binarySearchInNearlySortedList()

        print("binarySearchInUnknownOrder : ")
        binarySearchInUnknownOrder()

        print("binarySearchInMatrix : ")
        binarySearchInMatrix()
    }
}
