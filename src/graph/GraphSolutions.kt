package graph

import java.util.ArrayDeque
import java.util.PriorityQueue
import java.util.Stack
import kotlin.math.min

class GraphSolutions : GraphProblems {
    override fun breadthFirstSearch(graph: Graph) {
        val queue = kotlin.collections.ArrayDeque<Int>()
        val visitedSet = mutableSetOf<Int>()
        val path = mutableSetOf<Int>()
        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                queue.add(i)
                while (queue.isNotEmpty()) {
                    val node = queue.removeFirst()
                    visitedSet.add(node)
                    path.add(node)
                    for (edge in graph.edges) {
                        if (edge.start == node && !visitedSet.contains(edge.destination)) {
                            queue.add(edge.destination)
                        }
                    }
                }
            }
        }

        println(path)
    }

    override fun depthFirstSearch(graph: Graph) {
        val stack = Stack<Int>()
        val visitedSet = mutableSetOf<Int>()
        val path = mutableListOf<Int>()
        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                stack.push(i)
                while (stack.isNotEmpty()) {
                    val node = stack.pop()
                    visitedSet.add(node)
                    path.add(node)
                    for (edge in graph.edges) {
                        if (edge.start == node && !visitedSet.contains(edge.destination)) {
                            stack.push(edge.destination)
                        }
                    }
                }
            }
        }

        println(path)
    }

    override fun detectCycleInUndirectionalGraph(graph: Graph) {
        val stack = Stack<Int>()
        val visitedSet = mutableSetOf<Int>()
        val parent = Array(graph.totalNodes) { -1 }

        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                stack.push(i)
                while (stack.isNotEmpty()) {
                    val node = stack.pop()
                    visitedSet.add(node)
                    for (edge in graph.edges) {
                        if (edge.start == node && !visitedSet.contains(edge.destination)) {
                            stack.push(edge.destination)
                            parent[edge.destination] = node
                        } else if (edge.start == node && parent[node] == edge.destination) {
                            //
                        } else if (edge.start == node && visitedSet.contains(edge.destination)) {
                            println(true)
                            return
                        }
                    }
                }
            }
        }
        println(false)
        return
    }

    override fun detectCycleInDirectionalGraph(graph: Graph) {
        val stack = Stack<Int>()
        val visitedSet = mutableSetOf<Int>()

        val currentStackSet = mutableSetOf<Int>()

        for (i in 0 until graph.totalNodes) {
            if (!visitedSet.contains(i)) {
                stack.push(i)
                currentStackSet.clear()
                while (stack.isNotEmpty()) {
                    val node = stack.pop()
                    visitedSet.add(node)
                    currentStackSet.add(node)
                    for (edge in graph.edges) {
                        if (edge.start == node && !visitedSet.contains(edge.destination)) {
                            stack.push(edge.destination)
                        } else if (edge.start == node && currentStackSet.contains(edge.destination)) {
                            println(edge)
                            println(true)
                            return
                        }
                    }
                }
            }
        }
        println(false)
    }

    override fun dijkstraAlgo(graph: Graph, startIndex: Int) {
        val distance = Array(graph.totalNodes) { Int.MAX_VALUE }
        val minimisedSet = mutableSetOf<Int>()
        distance[startIndex] = 0
        val priorityQueue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
        priorityQueue.add(startIndex to 0)
        while (priorityQueue.isNotEmpty()) {
            val node = priorityQueue.poll()
            minimisedSet.add(node.first)
            for (edge in graph.edges) {
                if (node.first == edge.start && !minimisedSet.contains(edge.destination)) {
                    if (node.second + edge.cost < distance[edge.destination]) {
                        distance[edge.destination] = node.second + edge.cost
                        priorityQueue.add(edge.destination to distance[edge.destination])
                    }
                }
            }
        }

        println(distance.toList())
    }

    override fun primsMinimumSpanningTree(graph: Graph) {
        val stack = Stack<Int>()
        val minimisedSet = mutableSetOf<Int>()
        val result = mutableListOf<Graph.Edge>()
        stack.push(0)
        val priorityQueue = PriorityQueue<Graph.Edge> { a, b -> a.cost - b.cost }

        while (stack.isNotEmpty() && minimisedSet.size != graph.totalNodes) {
            val node = stack.pop()
            minimisedSet.add(node)
            for (edge in graph.edges) {
                if (edge.start == node && !minimisedSet.contains(edge.destination)) {
                    priorityQueue.add(edge)
                }
            }
            val edge = priorityQueue.poll()
            if (!minimisedSet.contains(edge.destination)) {
                result.add(edge)
                stack.push(edge.destination)
            }
        }

        println(result)
        println(result.sumOf { it.cost })
    }

    override fun kruskalsMinimumSpanningTree(graph: Graph) {
        val priorityQueue = PriorityQueue<Graph.Edge> { a, b -> a.cost - b.cost }
        val parent = Array(graph.totalNodes) { it }
        val path = mutableSetOf<Graph.Edge>()
        priorityQueue.addAll(graph.edges)
        while (priorityQueue.isNotEmpty() && path.size < graph.totalNodes) {
            val edge = priorityQueue.poll()
            val startParent = getParent(parent, edge.start)
            val endParent = getParent(parent, edge.destination)
            if (startParent != endParent) {
                if (startParent == edge.start) {
                    parent[edge.start] = endParent
                } else if (endParent == edge.destination) {
                    parent[edge.destination] = startParent
                } else {
                    assignParent(parent, edge.start, edge.destination)
                }
                path.add(edge)
            }
        }

        println(path)
        println(path.sumOf { it.cost })
    }

    private fun assignParent(parent: Array<Int>, start: Int, destination: Int) {
        if (parent[start] == destination) return
        assignParent(parent, parent[start], destination)
        parent[start] = destination
    }

    private fun getParent(parent: Array<Int>, node: Int): Int {
        return if (parent[node] == node) node
        else getParent(parent, parent[node])
    }

    override fun bellmanFordAlgo(graph: Graph, startIndex: Int) {
        val cost = Array(graph.totalNodes) { Int.MAX_VALUE }
        cost[startIndex] = 0
        for (i in 0..graph.totalNodes) {
            for (edge in graph.edges) {
                if (cost[edge.start] < Int.MAX_VALUE && (cost[edge.start] + edge.cost < cost[edge.destination])) {
                    cost[edge.destination] = cost[edge.start] + edge.cost
                    if (i == graph.totalNodes) {
                        println("Negative Cycle")
                        return
                    }
                }
            }
        }

        println(cost.toList())
    }

    override fun floydWarshallAlgo(graph: Graph) {
        val cost = Array(graph.totalNodes) { Array(graph.totalNodes) { Int.MAX_VALUE } }
        for (i in 0 until graph.totalNodes) {
            cost[i][i] = 0
        }
        for (edge in graph.edges) {
            cost[edge.start][edge.destination] = edge.cost
        }
        for (k in 0 until graph.totalNodes) {
            for (i in 0 until graph.totalNodes) {
                for (j in 0 until graph.totalNodes) {
                    if (cost[i][k] < Int.MAX_VALUE && cost[k][j] < Int.MAX_VALUE && (cost[i][j] > cost[i][k] + cost[k][j])) {
                        cost[i][j] = cost[i][k] + cost[k][j]
                    }
                }
            }
        }
        for (list in cost) {
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
                    val currentIndex = stack.peek()
                    visitedSet.add(currentIndex)

                    var allAdjacentVisited = true
                    for (edge in graph.edges) {
                        if (edge.start == currentIndex && !visitedSet.contains(edge.destination)) {
                            stack.push(edge.destination)
                            allAdjacentVisited = false
                        }
                    }

                    if (allAdjacentVisited) {
                        stack.pop()
                        result.add(currentIndex)
                    }
                }
            }
        }

        println(result.asReversed())
    }

    override fun numberOfIslands(graph: List<List<Int>>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visitedSet = mutableSetOf<Pair<Int, Int>>()
        val totalNodes = graph.size

        val allowedPaths = listOf(0 to 1, 1 to 0, 1 to 1, 0 to -1, -1 to 0, -1 to 1, 1 to -1, -1 to -1)

        var count = 0

        for (i in 0 until totalNodes) {
            for (j in 0 until totalNodes) {
                if (graph[i][j] == 1 && !visitedSet.contains(i to j)) {
                    queue.add(i to j)
                    count++
                }

                while (queue.isNotEmpty()) {
                    val currentPosition = queue.first()
                    visitedSet.add(currentPosition)

                    allowedPaths.forEach {
                        val x = currentPosition.first + it.first
                        val y = currentPosition.second + it.second

                        val isValidPosition = x in 0 until totalNodes && y in 0 until totalNodes

                        if (isValidPosition && graph[x][y] == 1 && !visitedSet.contains(x to y)) {
                            queue.add(x to y)
                            visitedSet.add(x to y)
                        }
                    }

                    queue.removeFirst()
                }
            }
        }

        println(count)
    }

    override fun minimumCostPath(graph: List<List<Int>>) {
        val cache = Array(graph.size + 1) { Array(graph.size + 1) { Int.MAX_VALUE } }

        cache[0][0] = graph[0][0]

        for (i in 0 until graph.size) {
            for (j in 0 until graph.first().size) {
                if (i == 0 && j == 0) {
                    cache[i][j] = graph[i][j]
                } else if (i == 0) {
                    cache[i][j] = graph[i][j] + cache[i][j - 1]
                } else if (j == 0) {
                    cache[i][j] = graph[i][j] + cache[i - 1][j]
                } else {
                    cache[i][j] = graph[i][j] + min(min(cache[i][j - 1], cache[i - 1][j]), cache[i - 1][j - 1])
                }
            }
        }

        val result = cache[graph.lastIndex][graph.first().lastIndex]
        println(result)
    }
}