package graph

data class Graph(val totalNodes: Int, val edges: List<Edge>) {
    data class Edge(val start: Int, val destination: Int, val cost: Int = 0)
}
