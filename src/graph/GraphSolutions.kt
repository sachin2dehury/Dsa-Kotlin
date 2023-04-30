package graph

import java.util.Stack

class GraphSolutions : GraphProblems {
    override fun breadthFirstSearch(graph: Graph, startIndex: Int) {
        val queue = ArrayDeque<Int>()
        val visited = Array(graph.totalNodes) { false }
        val result = mutableListOf<Int>()

        queue.add(startIndex)
        visited[startIndex] = true

        while (queue.isNotEmpty()) {
            val currentIndex = queue.removeFirst()
            result.add(currentIndex)

            for (edge in graph.edges) {
                if (edge.start == currentIndex && !visited[edge.destination]) {
                    visited[edge.destination] = true
                    queue.add(edge.destination)
                }
            }
        }

        println(result)
    }

    override fun depthFirstSearch(graph: Graph, startIndex: Int) {
        val stack = Stack<Int>()
        val visited = Array(graph.totalNodes) { false }
        val result = mutableListOf<Int>()

        stack.push(startIndex)
        visited[startIndex] = true

        while (stack.isNotEmpty()) {
            val currentIndex = stack.pop()
            result.add(currentIndex)

            for (edge in graph.edges) {
                if (edge.start == currentIndex && !visited[edge.destination]) {
                    visited[edge.destination] = true
                    stack.push(edge.destination)
                }
            }
        }

        println(result)
    }

    override fun detectCycleInUniDirectionalGraph(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun detectCycleInDirectionalGraph(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun dijkstraAlgo(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun primsMinimumSpanningTree(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun kruskalsMinimumSpanningTree(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun bellmanFordAlgo(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun floydWarshallAlgo(graph: Graph) {
        TODO("Not yet implemented")
    }
}