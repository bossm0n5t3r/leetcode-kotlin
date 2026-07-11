package me.bossm0n5t3r.leetcode.countthenumberofcompletecomponents

class CountTheNumberOfCompleteComponents {
    class Solution {
        fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
            val graph = Array(n) { mutableSetOf<Int>() }
            for (edge in edges) {
                val (u, v) = edge
                graph[u] += v
                graph[v] += u
            }
            var result = 0
            val visited = BooleanArray(n) { false }
            var cur = 0
            while (cur < n) {
                if (visited[cur]) {
                    cur++
                    continue
                }
                if (isCompleteComponents(graph, cur, visited)) {
                    result++
                }
                cur++
            }
            return result
        }

        private fun isCompleteComponents(
            graph: Array<MutableSet<Int>>,
            cur: Int,
            visited: BooleanArray,
        ): Boolean {
            val component = mutableSetOf<Int>()
            dfs(cur, visited, graph, component)
            val size = component.size
            val expectedEdges = size * (size - 1) / 2
            var actualEdges = 0
            for (u in component) {
                for (v in graph[u]) {
                    if (v in component) actualEdges++
                }
            }
            actualEdges /= 2
            return actualEdges == expectedEdges
        }

        private fun dfs(
            node: Int,
            visited: BooleanArray,
            graph: Array<MutableSet<Int>>,
            component: MutableSet<Int>,
        ) {
            visited[node] = true
            component += node
            for (neighbor in graph[node]) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, graph, component)
                }
            }
        }
    }
}
