package stack

class MinStackUsingOtherVariable : MinStack() {
    private var minimumHolder: Int? = null
    override fun push(value: Int): Int? {
        return if (minimumHolder == null) {
            minimumHolder = value
            super.push(value)
        } else if (minimumHolder != null && minimumHolder!! > value) {
            val newValueToBePushed = 2 * minimumHolder!! - value
            minimumHolder = value
            super.push(newValueToBePushed)
        } else {
            super.push(value)
        }
    }

    override fun pop(): Int? {
        if (minimumHolder != null && isNotEmpty() && minimumHolder!! > peek()) {
            val previousMinValue = 2 * minimumHolder!! - peek()
            minimumHolder = previousMinValue
        }
        return super.pop()
    }

    override fun min(): Int? {
        return minimumHolder
    }
}
