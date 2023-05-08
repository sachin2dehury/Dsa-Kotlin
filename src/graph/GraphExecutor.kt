package graph

object GraphExecutor : GraphProblems by GraphSolutions() {

    operator fun invoke() {
        val directedGraph = Graph(
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

        val undirectedGraph = Graph(
            totalNodes = 4,
            edges = listOf(
                Graph.Edge(0, 1),
                Graph.Edge(0, 2),
                Graph.Edge(1, 2),
                Graph.Edge(2, 3),
            )
        )

        val weightedGraph = Graph(
            totalNodes = 5,
            edges = listOf(
                Graph.Edge(0, 1, 10),
                Graph.Edge(0, 4, 3),
                Graph.Edge(1, 2, 2),
                Graph.Edge(1, 4, 4),
                Graph.Edge(2, 3, 9),
                Graph.Edge(3, 2, 7),
                Graph.Edge(4, 1, 1),
                Graph.Edge(4, 2, 8),
                Graph.Edge(4, 3, 2)
            )
        )

        breadthFirstSearch(directedGraph)

        depthFirstSearch(directedGraph)

        detectCycleInUndirectionalGraph(undirectedGraph)

        // Todo Sachin
//        detectCycleInDirectionalGraph(directedGraph)

        dijkstraAlgo(weightedGraph)

        kruskalsMinimumSpanningTree(weightedGraph)

        floydWarshallAlgo(weightedGraph)

        bellmanFordAlgo(weightedGraph)

        val graph = Graph(
            totalNodes = 6,
            edges = listOf(
                Graph.Edge(5, 2),
                Graph.Edge(5, 0),
                Graph.Edge(4, 0),
                Graph.Edge(4, 1),
                Graph.Edge(2, 3),
                Graph.Edge(3, 1)
            )
        )

        topologicalSort(graph)

        numberOfIslands()

        minimumCostPath()
    }
}