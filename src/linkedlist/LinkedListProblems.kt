package linkedlist

interface LinkedListProblems {

    fun deleteNode(node: Node?, data: Int): Node?

    fun reverseLinkedList(node: Node?): Node?

    fun detectCycle(node: Node?)

    fun middleElement(node: Node?)

    fun nthFromEnd(node: Node?)

    fun insertAt(node: Node?, data: Int, position: Int): Node?

    fun printLinkedList(node: Node?)
}