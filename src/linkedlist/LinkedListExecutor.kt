package linkedlist

object LinkedListExecutor : LinkedListProblems by LinkedListSolutions() {

    operator fun invoke() {
        var head: Node? = Node(1)

        var currentNode: Node? = head

        (2..8).forEach {
            currentNode?.next = Node(it)
            currentNode = currentNode?.next
        }

        printLinkedList(head)

        head = deleteNode(head, 1)

        currentNode?.next = head
        detectCycle(head)

        currentNode?.next = null
        middleElement(head)

        head = insertAt(head, 9, 3)
        head = reverseLinkedList(head)

        printLinkedList(head)

        nthFromEnd(head,3)
    }
}