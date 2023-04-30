package recursion

import java.util.Stack

object RecursionExecutor : RecursionProblems by RecursionSolutions() {

    operator fun invoke() {
        val stack = Stack<Int>()
        val list = mutableListOf(2, 4, 3, 5, 8, 7, 6, 9)
        stack.addAll(list)
        println(stack)

        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left?.right = Node(4)
        root.right?.left = Node(5)
        root.right?.right = Node(6)
        root.right?.left?.left = Node(7)
        root.right?.left?.right = Node(8)

        val set = mutableSetOf<String>()

        deleteMiddleElementOfStack(stack)
        println(stack)

        println(heightOfBinaryTree(root))

        println(josephusProblem())

        println(kthElementInGrammar())

        println(nBitBinaryNumber())

        permutationWithCaseChange()

        permutationWithLetter()

        permutationWithSpaces()

        printAllSubSequences()

        printUniqueSubSequences(result = set)
        println(set)

        sortStack(stack)
        println(stack)

        reverseStack(stack)
        println(stack)

        sortList(list)
        println(list)

        sortStack(stack)
        println(stack)

    }
}