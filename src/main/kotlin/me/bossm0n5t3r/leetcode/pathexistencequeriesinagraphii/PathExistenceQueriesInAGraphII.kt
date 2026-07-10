package me.bossm0n5t3r.leetcode.pathexistencequeriesinagraphii

class PathExistenceQueriesInAGraphII {
    class Solution {
        fun pathExistenceQueries(
            n: Int,
            nums: IntArray,
            maxDiff: Int,
            queries: Array<IntArray>,
        ): IntArray {
            // 1. (value, originalIndex) 쌍을 값 기준 정렬
            val sorted = nums.withIndex().sortedBy { it.value }
            val sortedVals = IntArray(n) { sorted[it].value }
            val posInSorted = IntArray(n) // posInSorted[원래 노드] = 정렬 후 위치
            for (i in 0 until n) {
                posInSorted[sorted[i].index] = i
            }

            // 2. 정렬 순서상 컴포넌트 ID (인접 간격 > maxDiff -> 새 컴포넌트)
            val comp = IntArray(n)
            for (i in 1 until n) {
                comp[i] =
                    if (sortedVals[i] - sortedVals[i - 1] > maxDiff) {
                        comp[i - 1] + 1
                    } else {
                        comp[i - 1]
                    }
            }

            // 3. jump[0][i] = i에서 한 번 점프해 도달 가능한 가장 먼 위치 (투 포인터)
            val maxK = 17 // 2^17 = 131072 > 10^5
            val jump = Array(maxK + 1) { IntArray(n) }
            var r = 0
            for (i in 0 until n) {
                while (r + 1 < n && sortedVals[r + 1] - sortedVals[i] <= maxDiff) {
                    r++
                }
                jump[0][i] = maxOf(i, r)
            }

            // 4. Binary Lifting: jump[k][i] = 2^k번 점프 후 위치
            for (k in 1..maxK) {
                for (i in 0 until n) {
                    jump[k][i] = jump[k - 1][jump[k - 1][i]]
                }
            }

            // 5. 쿼리 처리
            val result = IntArray(queries.size)
            for ((k, q) in queries.withIndex()) {
                val u = q[0]
                val v = q[1]
                if (u == v) {
                    result[k] = 0
                    continue
                }
                val pu = posInSorted[u]
                val pv = posInSorted[v]
                if (comp[pu] != comp[pv]) {
                    result[k] = -1
                    continue
                }
                // 항상 작은 위치 -> 큰 위치로 점프 (무향 그래프이므로 거리 대칭)
                var lo = minOf(pu, pv)
                val hi = maxOf(pu, pv)
                var jumps = 0
                for (bit in maxK downTo 0) {
                    if (jump[bit][lo] < hi) {
                        lo = jump[bit][lo]
                        jumps += (1 shl bit)
                    }
                }
                result[k] = jumps + 1
            }
            return result
        }
    }
}
