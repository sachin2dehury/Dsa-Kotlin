package stack

object StackExecutor : StackProblems by StackSolutions() {

    operator fun invoke() {
        println("\nStack :\n")

        print("nearestGreaterToRight : ")
        nearestGreaterToRight()

        print("nearestGreaterToLeft : ")
        nearestGreaterToLeft()

        print("nearestSmallerToRight : ")
        nearestSmallerToRight()

        print("nearestSmallerToLeft : ")
        nearestSmallerToLeft()

        print("rainWaterTrapping : ")
        rainWaterTrapping()

        print("maximumAreaHistogram : ")
        maximumAreaHistogram()

        print("stockSpan : ")
        stockSpan()

        print("minStack using other stack : ")
        MinStackUsingOtherStack()()

        print("minStack using other variable : ")
        MinStackUsingOtherVariable()()

        print("postfixEvaluation : ")
        postfixEvaluation()

        print("balancedParenthesis : ")
        balancedParenthesis()

        print("binaryMatrixMaximumAreaHistogram : ")
        binaryMatrixMaximumAreaHistogram()
    }
}

fun main() {
    StackSolutions().balancedParenthesis()
}