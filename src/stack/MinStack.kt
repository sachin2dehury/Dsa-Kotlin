package stack

import java.util.Stack

abstract class MinStack : Stack<Int>() {
    abstract fun min(): Int?

    operator fun invoke() {
        listOf(16, 29, 19, 15, 18).forEach {
            push(it)
        }
        for (i in 0..3) {
            pop()
        }
        println(min())
    }
}
