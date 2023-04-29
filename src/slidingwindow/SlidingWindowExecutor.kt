package slidingwindow

object SlidingWindowExecutor : SlidingWindowProblems by SlidingWindowSolutions() {

    operator fun invoke() {
        println("\nSlidingWindow :\n")

        print("countOfOccurrencesOfAnagram : ")
        countOfOccurrencesOfAnagram()

        print("firstNegativeNumberInWindow : ")
        firstNegativeNumberInWindow()

        print("longestSubArrayOfSumK : ")
        longestSubArrayOfSumK()

        print("longestSubStringWithKUniqueChar : ")
        longestSubStringWithKUniqueChar()

        print("longestSubStringWithoutRepeatingChar : ")
        longestSubStringWithoutRepeatingChar()

        print("maximumElementOfAllSubArray : ")
        maximumElementOfAllSubArray()

        print("maximumSumOfArrayOfSizeK : ")
        maximumSumOfArrayOfSizeK()

        print("minimumWindowSubString : ")
        minimumWindowSubString()

        print("pickToys : ")
        pickToys()
    }
}