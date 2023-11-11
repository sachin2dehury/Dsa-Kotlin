package binarytree

import java.util.Stack
import kotlin.math.max

class BinaryTreeSolutions : BinaryTreeProblems {
    override fun preorderTraversal(node: Node?) {
        if (node == null) return
        print("${node.data} ")
        preorderTraversal(node.left)
        preorderTraversal(node.right)
    }

    override fun inorderTraversal(node: Node?) {
        if (node == null) return
        inorderTraversal(node.left)
        print("${node.data} ")
        inorderTraversal(node.right)
    }

    override fun postorderTraversal(node: Node?) {
        if (node == null) return
        postorderTraversal(node.left)
        postorderTraversal(node.right)
        print("${node.data} ")
    }

    override fun levelOrderTraversal(node: Node?) {
        val queue = ArrayDeque<Node?>()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (current != null) {
                print("${current.data} ")
                queue.add(current.left)
                queue.add(current.right)
            }
        }
    }

    override fun binaryTreeSearch(node: Node?, key: Int): Boolean {
        return if (node == null) {
            false
        } else if (node.data == key) {
            true
        } else {
            val left = binaryTreeSearch(node.left, key)
            val right = binaryTreeSearch(node.right, key)
            left || right
        }
    }

    override fun isSameBinaryTree(node1: Node?, node2: Node?): Boolean {
        return if (node1 == null && node2 == null) {
            true
        } else if (node1 == null || node2 == null) {
            false
        } else {
            val left = isSameBinaryTree(node1.left, node2.left)
            val right = isSameBinaryTree(node1.right, node2.right)
            (node1.data == node2.data) && left && right
        }
    }

    override fun sizeOfBinaryTree(node: Node?): Int {
        if (node == null) return 0
        val right = sizeOfBinaryTree(node.right)
        val left = sizeOfBinaryTree(node.left)
        return 1 + right + left
    }

    override fun heightOfBinaryTree(node: Node?): Int {
        if (node == null) return 0
        val left = heightOfBinaryTree(node.left)
        val right = heightOfBinaryTree(node.right)
        return 1 + max(left, right)
    }

    override fun isBinarySearchTree(node: Node?): Boolean {
        if (node == null) return true

        val left = isBinarySearchTree(node.left)
        val right = isBinarySearchTree(node.right)

        var result = true

        if (node.left != null) {
            result = result && (node.data > node.left!!.data)
        }

        if (node.right != null) {
            result = result && (node.data < node.right!!.data)
        }
        return result && left && right
    }

    override fun reverseLevelOrderTraversal(node: Node?) {
        val queue = ArrayDeque<Node?>()
        queue.add(node)

        val stack = Stack<Int>()

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (current != null) {
                stack.push(current.data)
                queue.add(current.left)
                queue.add(current.right)
            }
        }

        while (stack.isNotEmpty()) {
            print("${stack.pop()} ")
        }
    }

    override fun spiralOrderTraversal(node: Node?) {
        if (node == null) return

        val queue = ArrayDeque<Pair<Node, Boolean>>()
        queue.add(node to false)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val currentNode = current.first
            val direction = current.second

            print("${currentNode.data} ")

            if (direction) {
                currentNode.left?.let {
                    queue.add(it to false)
                }
                currentNode.right?.let {
                    queue.add(it to false)
                }
            } else {
                currentNode.right?.let {
                    queue.add(it to true)
                }
                currentNode.left?.let {
                    queue.add(it to true)
                }
            }
        }
    }

    override fun lowestCommonAncestorBinarySearchTree(node: Node?) {
        TODO("Not yet implemented")
    }

    override fun iterativePreorder(node: Node?) {
        if (node == null) return

        var root = node
        val stack = Stack<Node>()

        println()
        while (stack.isNotEmpty() || root != null) {
            if (root != null) {
                stack.push(root)
                print("${root.data} ")
                root = root.left
            } else {
                val current = stack.pop()
                root = current.right
            }
        }
    }

    override fun iterativeInorder(node: Node?) {
        if (node == null) return

        var root = node
        val stack = Stack<Node>()

        println()
        while (stack.isNotEmpty() || root != null) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                val current = stack.pop()
                print("${current.data} ")
                root = current.right
            }
        }
    }

    override fun iterativePostorder(node: Node?) {
        TODO("Not yet implemented")
    }
}