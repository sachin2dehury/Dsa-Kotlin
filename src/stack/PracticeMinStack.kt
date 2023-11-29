package stack

import java.util.Stack
import kotlin.math.min

class PracticeMinStack : MinStack() {
    private val stack = Stack<Int>()
    override fun min(): Int? {
        return stack.peek()
    }

    override fun push(p0: Int): Int {
        if (stack.isEmpty()) {
            stack.push(p0)
        } else {
            stack.push(min(p0, stack.peek()))
        }
        return super.push(p0)
    }

    override fun pop(): Int {
        stack.pop()
        return super.pop()
    }
}