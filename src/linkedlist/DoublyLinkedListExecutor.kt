package linkedlist

object DoublyLinkedListExecutor : LinkedListProblems by DoublyLinkedListSolutions() {

    operator fun invoke() {
        var head: Node? = Node(1)

        var currentNode = head

        (2..8).forEach {
            currentNode?.next = Node(it, prev = currentNode)
            currentNode = currentNode?.next
        }

        printLinkedList(head)

        head = deleteNode(head, 1)

        currentNode?.next = head
        head?.prev = currentNode

        detectCycle(head)

        currentNode?.next = null
        head?.prev = null

        head = reverseLinkedList(head)

        head = insertAt(head, 9, 3)

        middleElement(head)
    }
}