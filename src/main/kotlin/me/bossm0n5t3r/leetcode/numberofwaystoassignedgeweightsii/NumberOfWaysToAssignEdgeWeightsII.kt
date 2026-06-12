package me.bossm0n5t3r.leetcode.numberofwaystoassignedgeweightsii

class NumberOfWaysToAssignEdgeWeightsII {
    class Solution {
        fun assignEdgeWeights(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
            val treeInfo = getTreeInfo(edges)

            val result = IntArray(queries.size) { 0 }
            for (queryIndex in queries.indices) {
                val u = queries[queryIndex][0]
                val v = queries[queryIndex][1]
                result[queryIndex] = getResult(treeInfo, u, v)
            }

            return result
        }

        private data class TreeInfo(
            val depth: IntArray,
            val parents: Array<IntArray>,
            val dp: Array<IntArray>,
        ) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as TreeInfo

                if (!depth.contentEquals(other.depth)) return false
                if (!parents.contentDeepEquals(other.parents)) return false
                if (!dp.contentDeepEquals(other.dp)) return false

                return true
            }

            override fun hashCode(): Int {
                var result = depth.contentHashCode()
                result = 31 * result + parents.contentDeepHashCode()
                result = 31 * result + dp.contentDeepHashCode()
                return result
            }
        }

        private fun getTreeInfo(edges: Array<IntArray>): TreeInfo {
            val n = edges.size + 1
            val log = 32 - Integer.numberOfLeadingZeros(n)

            val graph = Array(n + 1) { mutableListOf<Int>() }
            for (edge in edges) {
                val u = edge[0]
                val v = edge[1]
                graph[u].add(v)
                graph[v].add(u)
            }

            val depth = IntArray(n + 1)
            val parents = Array(log) { IntArray(n + 1) }

            // DFS or stack BFS from root 1
            val stack = IntArray(n)
            var size = 1
            stack[0] = 1
            parents[0][1] = 0
            depth[1] = 0

            while (size > 0) {
                val node = stack[--size]

                for (next in graph[node]) {
                    if (next == parents[0][node]) continue

                    parents[0][next] = node
                    depth[next] = depth[node] + 1
                    stack[size++] = next
                }
            }

            // binary lifting table 채우기
            for (k in 1 until log) {
                for (node in 1..n) {
                    parents[k][node] = parents[k - 1][parents[k - 1][node]]
                }
            }

            val dp = Array(n) { IntArray(2) }
            dp[0][0] = 1
            dp[0][1] = 0
            for (length in 1 until n) {
                dp[length][0] = (dp[length - 1][0] + dp[length - 1][1]) % MOD
                dp[length][1] = (dp[length - 1][0] + dp[length - 1][1]) % MOD
            }

            return TreeInfo(depth, parents, dp)
        }

        private fun getResult(treeInfo: TreeInfo, u: Int, v: Int): Int {
            val depth = treeInfo.depth
            val parents = treeInfo.parents
            val dp = treeInfo.dp

            var a = u
            var b = v

            // 1. a가 더 깊도록 맞추기
            if (depth[a] < depth[b]) {
                val temp = a
                a = b
                b = temp
            }

            // 2. depth 차이만큼 a를 위로 올리기
            var diff = depth[a] - depth[b]
            var bit = 0
            while (diff > 0) {
                if (diff and 1 == 1) {
                    a = parents[bit][a]
                }
                diff = diff shr 1
                bit++
            }

            // 3. 이미 같으면 그게 LCA
            val lca =
                if (a == b) {
                    a
                } else {
                    // 4. 높은 bit부터 보면서 둘의 parent가 달라지는 지점까지 올리기
                    for (k in parents.indices.reversed()) {
                        if (parents[k][a] != parents[k][b]) {
                            a = parents[k][a]
                            b = parents[k][b]
                        }
                    }

                    // 5. 바로 위 부모가 LCA
                    parents[0][a]
                }

            val chainLength = depth[u] + depth[v] - 2 * depth[lca]
            return dp[chainLength][1]
        }

        private companion object {
            const val MOD = 1_000_000_007
        }
    }
}
