package linkedlist

object LinkedListExecutor : LinkedListProblems by LinkedListSolutions() {

    operator fun invoke() {
        val head = Node(1)

        var currentNode: Node? = head

        (2..8).forEach {
            currentNode?.next = Node(it)
            currentNode = currentNode?.next
        }

        deleteNode(head, 4)
        println()

        currentNode?.next = head
        detectCycle(head)

        currentNode?.next = null
        middleElement(head)

        insertAt(head, 9, 3)
        println()
        reverseLinkedList(head)
    }
}