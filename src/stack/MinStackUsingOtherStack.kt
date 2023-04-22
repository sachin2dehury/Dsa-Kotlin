package stack

import java.util.Stack

class MinStackUsingOtherStack : MinStack() {
    private val minimumHolderStack = Stack<Int>()
    override fun push(value: Int): Int? {
        if (minimumHolderStack.isEmpty()) {
            minimumHolderStack.push(value)
        } else {
            minimumHolderStack.push(minOf(minimumHolderStack.peek(), value))
        }
        return super.push(value)
    }

    override fun pop(): Int? {
        minimumHolderStack.pop()
        return super.pop()
    }

    override fun min(): Int? {
        return minimumHolderStack.peek()
    }
}
