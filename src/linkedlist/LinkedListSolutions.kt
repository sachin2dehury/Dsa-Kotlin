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

    override fun nthFromEnd(node: Node?, position: Int) {
        var head = node
        var count = 0
        while (head != null) {
            count++
            head = head.next
        }
        val newPosition = (count - position)
        head = node
        for (i in 0 until newPosition) {
            head = head?.next
        }
        println(head?.data)
    }

    override fun insertAt(node: Node?, data: Int, position: Int): Node? {
        var head = node
        val newNode = Node(data)
        var count = 0

        if (position == 1) {
            newNode.next = head
            head = newNode
        } else {
            var currentNode = node
            var prev: Node? = null
            while (currentNode != null && count < position) {
                count++
                prev = currentNode
                currentNode = currentNode.next
            }
            newNode.next = currentNode
            prev?.next = newNode
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