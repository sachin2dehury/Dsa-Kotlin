package duplicates

object DuplicateExecutor : DuplicatesProblems by DuplicateSolutions() {

    operator fun invoke() {
        println("\nDuplicateAndMissing :\n")

        print("findDuplicateAndMissingElement : ")
        findDuplicateAndMissingElement()
    }
}