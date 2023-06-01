package binarytree

object BinaryTreeExecutor : BinaryTreeProblems by BinaryTreeSolutions() {

    operator fun invoke() {
        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left?.left = Node(4)
        root.left?.right = Node(5)

        println()
        preorderTraversal(root)
        println()
        inorderTraversal(root)
        println()
        postorderTraversal(root)
        println()
        levelOrderTraversal(root)
        println()
        println(binaryTreeSearch(root, 3))
        println(isSameBinaryTree(null, null))
        println(heightOfBinaryTree(root))
        println(sizeOfBinaryTree(root))

        reverseLevelOrderTraversal(root)
        println()
        spiralOrderTraversal(root)
        println()
        println(isBinarySearchTree(root))

        iterativePreorder(root)
        iterativeInorder(root)
    }
}