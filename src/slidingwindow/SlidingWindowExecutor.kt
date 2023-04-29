package slidingwindow

object SlidingWindowExecutor : SlidingWindowProblems by SlidingWindowSolutions() {

    operator fun invoke() {
        countOfOccurrencesOfAnagram()
        firstNegativeNumberInWindow()
        longestSubArrayOfSumK()
        longestSubStringWithKUniqueChar()
        longestSubStringWithoutRepeatingChar()
        maximumElementOfAllSubArray()
        maximumSumOfArrayOfSizeK()
        minimumWindowSubString()
        pickToys()
    }
}