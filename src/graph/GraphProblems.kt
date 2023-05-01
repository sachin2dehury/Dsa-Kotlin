package graph

interface GraphProblems {

    fun breadthFirstSearch(graph: Graph)

    fun depthFirstSearch(graph: Graph)

    fun detectCycleInUndirectionalGraph(graph: Graph)

    fun detectCycleInDirectionalGraph(graph: Graph)

    fun dijkstraAlgo(graph: Graph, startIndex: Int = 0)

    fun primsMinimumSpanningTree(graph: Graph)

    fun kruskalsMinimumSpanningTree(graph: Graph)

    fun bellmanFordAlgo(graph: Graph, startIndex: Int = 0)

    fun floydWarshallAlgo(graph: Graph)

    fun topologicalSort(graph: Graph)
}