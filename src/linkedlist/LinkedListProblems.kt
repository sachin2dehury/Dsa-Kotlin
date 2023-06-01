package linkedlist

interface LinkedListProblems {

    fun deleteNode(node: Node?, data: Int)

    fun reverseLinkedList(node: Node?)

    fun detectCycle(node: Node?)

    fun middleElement(node: Node?)

    fun nthFromEnd(node: Node?)

    fun insertAt(node: Node?, data: Int, position: Int)
}