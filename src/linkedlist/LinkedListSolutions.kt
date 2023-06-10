package linkedlist

class LinkedListSolutions : LinkedListProblems {
    override fun deleteNode(node: Node?, data: Int): Node? {
        var head = node
        var prevNode: Node? = null
        var currentNode = node
        while (currentNode != null) {
            if (currentNode.data == data) {
                prevNode?.next = currentNode.next
                if (head == currentNode) {
                    head = currentNode.next
                }
            }
            prevNode = currentNode
            currentNode = currentNode.next
        }

        printLinkedList(head)
        return head
    }

    override fun reverseLinkedList(node: Node?): Node? {
        var current = node
        var prevNode: Node? = null
        var head = node

        while (current != null) {
            val currentNode = current
            current = current.next
            currentNode.next = prevNode
            prevNode = currentNode
        }

        head = prevNode
        printLinkedList(head)

        return head
    }

    override fun detectCycle(node: Node?) {
        var currentNode = node
        var nextNode = currentNode?.next?.next

        var result = false

        while (currentNode != null && nextNode != null) {
            currentNode = currentNode.next
            nextNode = nextNode.next?.next

            if (currentNode == nextNode) {
                result = true
                break
            }
        }

        println(result)
    }

    override fun middleElement(node: Node?) {
        var currentNode = node
        var nextNode = currentNode?.next?.next

        while (currentNode != null && nextNode != null) {
            currentNode = currentNode.next
            nextNode = nextNode.next?.next
        }

        println(currentNode?.data)
    }

    override fun nthFromEnd(node: Node?) {
        TODO("Not yet implemented")
    }

    override fun insertAt(node: Node?, data: Int, position: Int): Node? {
        var head = node
        val newNode = Node(data)
        var count = 0

        if (position == 0) {
            newNode.next = head
            head = newNode
        } else {
            var currentNode = node
            while (currentNode != null) {
                count++
                if (count == position - 1) {
                    newNode.next = currentNode.next
                    currentNode.next = newNode
                }
                currentNode = currentNode.next
            }
        }

        printLinkedList(head)
        return head
    }

    override fun printLinkedList(node: Node?) {
        var currentNode = node
        while (currentNode != null) {
            print("${currentNode.data} ")
            currentNode = currentNode.next
        }
        println()
    }
}