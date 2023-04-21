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
    }
}