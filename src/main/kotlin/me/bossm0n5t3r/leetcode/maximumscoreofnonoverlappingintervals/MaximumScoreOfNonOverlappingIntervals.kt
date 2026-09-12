package me.bossm0n5t3r.leetcode.maximumscoreofnonoverlappingintervals

class MaximumScoreOfNonOverlappingIntervals {
    class Solution {
        fun maximumWeight(intervals: List<List<Int>>): IntArray {
            val sorted =
                intervals
                    .mapIndexed { index, interval ->
                        Interval(
                            start = interval[0],
                            end = interval[1],
                            weight = interval[2],
                            originalIndex = index,
                        )
                    }
                    .sortedBy { it.start }

            val n = sorted.size
            val starts = IntArray(n) { sorted[it].start }
            val next = IntArray(n)

            for (i in 0 until n) {
                var left = i + 1
                var right = n
                while (left < right) {
                    val mid = left + (right - left) / 2

                    if (starts[mid] > sorted[i].end) {
                        right = mid
                    } else {
                        left = mid + 1
                    }
                }
                next[i] = left
            }

            val memo = Array(n) { arrayOfNulls<State>(5) }
            val answer = dfs(sorted, n, memo, next, 0, 4)

            return answer.indices
        }

        private fun dfs(
            intervals: List<Interval>,
            n: Int,
            memo: Array<Array<State?>>,
            next: IntArray,
            position: Int,
            remaining: Int,
        ): State {
            if (position == n || remaining == 0) return State()

            val cur = memo[position][remaining]
            if (cur != null) return cur

            val skip = dfs(intervals, n, memo, next, position + 1, remaining)
            val takeNext = dfs(intervals, n, memo, next, next[position], remaining - 1)

            val take =
                State(
                    score = intervals[position].weight + takeNext.score,
                    indices =
                        (intArrayOf(intervals[position].originalIndex) + takeNext.indices)
                            .sortedArray(),
                )

            val answer =
                when {
                    take.score > skip.score -> take
                    take.score < skip.score -> skip
                    else -> if (lexicographicallySmaller(take.indices, skip.indices)) take else skip
                }
            memo[position][remaining] = answer
            return answer
        }

        private fun lexicographicallySmaller(a: IntArray, b: IntArray): Boolean {
            val size = minOf(a.size, b.size)

            for (i in 0 until size) {
                if (a[i] != b[i]) {
                    return a[i] < b[i]
                }
            }

            return a.size < b.size
        }

        private data class Interval(
            val start: Int,
            val end: Int,
            val weight: Int,
            val originalIndex: Int,
        )

        private class State(val score: Long = 0L, val indices: IntArray = intArrayOf())
    }
}
