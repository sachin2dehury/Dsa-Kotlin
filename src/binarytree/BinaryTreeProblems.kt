package binarytree

interface BinaryTreeProblems {

    fun preorderTraversal(node: Node?)

    fun inorderTraversal(node: Node?)

    fun postorderTraversal(node: Node?)

    fun levelOrderTraversal(node: Node?)

    fun binaryTreeSearch(node: Node?, key: Int): Boolean

    fun isSameBinaryTree(node1: Node?, node2: Node?): Boolean

    fun sizeOfBinaryTree(node: Node?)

    fun heightOfBinaryTree(node: Node?): Int

    fun isBinarySearchTree(node: Node?)

    fun reverseLevelOrderTraversal(node: Node?)

    fun spiralOrderTraversal(node: Node?)

    fun lowestCommonAncestorBinarySearchTree(node: Node?)
}