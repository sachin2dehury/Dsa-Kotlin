package graph

import java.util.PriorityQueue
import java.util.Stack
import kotlin.math.min

class GraphSolutions : GraphProblems {
    override fun breadthFirstSearch(graph: Graph) {
        val queue = ArrayDeque<Int>()
        val visitedSet = mutableSetOf<Int>()
        val result = mutableListOf<Int>()

        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                queue.add(i)
                visitedSet.add(i)

                while (queue.isNotEmpty()) {
                    val currentIndex = queue.removeFirst()
                    result.add(currentIndex)

                    for (edge in graph.edges) {
                        if (edge.start == currentIndex && !visitedSet.contains(edge.destination)) {
                            visitedSet.add(edge.destination)
                            queue.add(edge.destination)
                        }
                    }
                }
            }
        }

        println(result)
    }

    override fun depthFirstSearch(graph: Graph) {
        val stack = Stack<Int>()
        val visitedSet = mutableSetOf<Int>()

        val result = mutableListOf<Int>()

        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                stack.push(i)

                while (stack.isNotEmpty()) {
                    val currentIndex = stack.pop()
                    if (currentIndex != i) {
                        result.add(currentIndex)
                    }
                    for (edge in graph.edges) {
                        if (edge.start == currentIndex && !visitedSet.contains(edge.destination)) {
                            visitedSet.add(edge.destination)
                            stack.push(edge.destination)
                        }
                    }
                }
                visitedSet.add(i)
                result.add(i)
            }
        }

        println(result)
    }

    override fun detectCycleInUndirectionalGraph(graph: Graph) {
        val stack = Stack<Int>()
        val visitedSet = mutableSetOf<Int>()

        var result = false

        stack.push(0)
        visitedSet.add(0)

        while (stack.isNotEmpty() && !result) {
            val currentIndex = stack.pop()

            for (edge in graph.edges) {
                if (edge.start == currentIndex) {

                    if (!visitedSet.contains(edge.destination)) {
                        visitedSet.add(edge.destination)
                        stack.push(edge.destination)
                    } else {
                        result = true
                        break
                    }
                }
            }
        }

        println(result)
    }

    override fun detectCycleInDirectionalGraph(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun dijkstraAlgo(graph: Graph, startIndex: Int) {
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
        val alreadyMinimised = mutableSetOf<Int>()
        val cost = Array(graph.totalNodes) { Int.MAX_VALUE }

        cost[startIndex] = 0
        minHeap.add(startIndex to cost[startIndex])

        while (minHeap.isNotEmpty()) {
            val current = minHeap.poll()
            val currentIndex = current.first
            val currentCost = current.second

            for (edge in graph.edges) {
                if (edge.start == currentIndex && !alreadyMinimised.contains(edge.destination)) {
                    if (cost[edge.destination] > currentCost + edge.cost) {
                        cost[edge.destination] = currentCost + edge.cost
                        minHeap.add(edge.destination to cost[edge.destination])
                    }
                }
            }

            alreadyMinimised.add(currentIndex)
        }

        println(cost.toList())
    }

    override fun primsMinimumSpanningTree(graph: Graph) {
        TODO("Not yet implemented")
    }

    override fun kruskalsMinimumSpanningTree(graph: Graph) {
        val minHeap = PriorityQueue<Graph.Edge> { a, b -> a.cost - b.cost }
        val parent = Array(graph.totalNodes) { it }

        val result = mutableListOf<Graph.Edge>()

        minHeap.addAll(graph.edges)

        while (minHeap.isNotEmpty()) {
            val currentEdge = minHeap.poll()
            val start = currentEdge.start
            val destination = currentEdge.destination
            if (getParentNode(parent, start) != getParentNode(parent, destination)) {
                assignParent(parent, start, destination)
                result.add(currentEdge)
            }
        }

        println(result)
    }

    private fun getParentNode(parent: Array<Int>, node: Int): Int {
        return if (parent[node] == node) {
            node
        } else {
            getParentNode(parent, parent[node])
        }
    }

    private fun assignParent(parent: Array<Int>, start: Int, destination: Int) {
        if (parent[destination] == destination) {
            parent[destination] = start
        } else {
            assignParent(parent, start, parent[destination])
            parent[destination] = start
        }
    }

    override fun bellmanFordAlgo(graph: Graph, startIndex: Int) {
        val cost = Array(graph.totalNodes) { Int.MAX_VALUE }
        cost[startIndex] = 0

        for (i in 0..graph.totalNodes) {
            for (edge in graph.edges) {

                if (cost[edge.start] < Int.MAX_VALUE) {

                    if (cost[edge.destination] > cost[edge.start] + edge.cost) {
                        cost[edge.destination] = cost[edge.start] + edge.cost

                        if (i == graph.totalNodes) {
                            println("Negative Cycle is Present")
                            return
                        }
                    }
                }
            }
        }

        println(cost.toList())
    }

    override fun floydWarshallAlgo(graph: Graph) {
        val result = Array(graph.totalNodes) {
            Array(graph.totalNodes) { Int.MAX_VALUE }
        }

        for (edge in graph.edges) {
            result[edge.start][edge.destination] = min(result[edge.start][edge.destination], edge.cost)
        }

        for (k in 0 until graph.totalNodes) {
            for (i in 0 until graph.totalNodes) {
                for (j in 0 until graph.totalNodes) {
                    if (i == j) {
                        result[i][j] = 0
                    } else if (result[i][k] < Int.MAX_VALUE && result[k][j] < Int.MAX_VALUE) {
                        result[i][j] = min(result[i][j], result[i][k] + result[k][j])
                    }
                }
            }
        }

        for (list in result) {
            println(list.toList())
        }
    }

    override fun topologicalSort(graph: Graph) {
        val stack = Stack<Int>()
        val visitedSet = mutableSetOf<Int>()

        val result = mutableListOf<Int>()

        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                stack.push(i)

                while (stack.isNotEmpty()) {
                    val currentIndex = stack.pop()
                    if (currentIndex != i) {
                        result.add(currentIndex)
                    }

                    for (edge in graph.edges) {
                        if (edge.start == currentIndex && !visitedSet.contains(edge.destination)) {
                            visitedSet.add(edge.destination)
                            stack.push(edge.destination)
                        }
                    }
                }

                visitedSet.add(i)
                result.add(i)
            }
        }

        println(result.asReversed())
    }

    override fun numberOfIslands(graph: List<List<Int>>) {

    }
}