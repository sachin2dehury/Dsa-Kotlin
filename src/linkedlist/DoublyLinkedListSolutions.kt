package linkedlist

class DoublyLinkedListSolutions : LinkedListProblems {
    override fun deleteNode(node: Node?, data: Int): Node? {
        var head = node

        var current = node
        while (current != null) {
            if (current.data == data) {
                val prev = current.prev
                val next = current.next

                prev?.next = next
                next?.prev = prev

                if (current == head) {
                    head = next
                }
                break
            }
            current = current.next
        }

        printLinkedList(head)

        return head
    }

    override fun reverseLinkedList(node: Node?): Node? {
        var head = node
        var current = node

        while (current != null) {
            val prev = current.prev
            val next = current.next

            current.next = prev
            current.prev = next

            head = current
            current = next
        }

        printLinkedList(head)
        return head
    }

    override fun detectCycle(node: Node?) {
        var current = node
        var next = current?.next?.next

        var result = false

        while (current != null && next != null) {
            current = current.next
            next = next.next?.next

            if (current == next) {
                result = true
                break
            }
        }

        println(result)
    }

    override fun middleElement(node: Node?) {
        var current = node
        var next = node?.next?.next

        while (current != null && next != null) {
            current = current.next
            next = next.next?.next
        }

        println(current?.data)
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
        if (position == 1) {
            newNode.next = node
            node?.prev = newNode
            return newNode
        }
        var count = 0
        while (head != null && count < position) {
            count++
            head = head.next
        }
        newNode.prev = head?.prev
        newNode.next = head
        head?.prev = newNode
        return node
    }

    override fun printLinkedList(node: Node?) {
        var current = node
        var prev: Node? = null

        while (current != null) {
            print("${current.data} ")
            prev = current
            current = current.next
        }
        println()

        current = prev
        while (current != null) {
            print("${current.data} ")
            current = current.prev
        }
        println()
    }
}