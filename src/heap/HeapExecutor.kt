package heap

object HeapExecutor : HeapProblems by HeapSolutions() {

    operator fun invoke() {
        println("\nHeap :\n")

        print("kSmallestElement : ")
        kSmallestElement()

        print("kLargestElement : ")
        kLargestElement()

        print("topKFrequentNumbers : ")
        topKFrequentNumbers()

        print("frequencySortDescending : ")
        frequencySortDescending()

        print("sortKSortedList : ")
        sortKSortedList()

        print("kClosestElement : ")
        kClosestElement()

        print("kClosestToOrigin : ")
        kClosestToOrigin()

        print("minimizeConnectingRopes : ")
        minimizeConnectingRopes()

        print("sumOfElementsBetweenSmallestK1andK2 : ")
        sumOfElementsBetweenSmallestK1andK2()
    }
}
