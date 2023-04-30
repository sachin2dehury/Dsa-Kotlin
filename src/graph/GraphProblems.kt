package graph

interface GraphProblems {

    fun breadthFirstSearch(graph: Graph, startIndex: Int = 0)

    fun depthFirstSearch(graph: Graph, startIndex: Int = 0)

    fun detectCycleInUniDirectionalGraph(graph: Graph)

    fun detectCycleInDirectionalGraph(graph: Graph)

    fun dijkstraAlgo(graph: Graph)

    fun primsMinimumSpanningTree(graph: Graph)

    fun kruskalsMinimumSpanningTree(graph: Graph)

    fun bellmanFordAlgo(graph: Graph)

    fun floydWarshallAlgo(graph: Graph)


}