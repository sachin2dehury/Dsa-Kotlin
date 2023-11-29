package backtracking

class BacktrackingSolutions : BacktrackingProblems {

    private fun permutationOfString(string: CharArray, start: Int = 0, end: Int = string.lastIndex) {
        if (start == end) {
            println(string)
        } else {
            for (i in start..end) {
                swap(string, start, i)
                permutationOfString(string, start + 1, end)
                swap(string, start, i)
            }
        }
    }

    private fun swap(string: CharArray, start: Int, i: Int) {
        val temp = string[start]
        string[start] = string[i]
        string[i] = temp
    }

    override fun permutationOfString(string: String) {
        permutationOfString(string.toCharArray())
    }

    override fun nQueenProblem(size: Int) {
        TODO("Not yet implemented")
    }
}