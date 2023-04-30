package graph

object GraphExecutor : GraphProblems by GraphSolutions() {

    operator fun invoke() {
        val graph = Graph(
            totalNodes = 4,
            edges = listOf(
                Graph.Edge(0, 1),
                Graph.Edge(0, 2),
                Graph.Edge(1, 2),
                Graph.Edge(2, 0),
                Graph.Edge(2, 3),
                Graph.Edge(3, 3)
            )
        )

        breadthFirstSearch(graph)

        depthFirstSearch(graph)
    }
}