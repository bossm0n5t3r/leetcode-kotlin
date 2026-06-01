package me.bossm0n5t3r.leetcode.longesthappystring

import java.util.PriorityQueue

class LongestHappyString {
    class Solution {
        fun longestDiverseString(a: Int, b: Int, c: Int): String {
            val pq = PriorityQueue { x: IntArray, y: IntArray -> y[0] - x[0] }
            if (a > 0) pq.offer(intArrayOf(a, 'a'.code))
            if (b > 0) pq.offer(intArrayOf(b, 'b'.code))
            if (c > 0) pq.offer(intArrayOf(c, 'c'.code))

            val result = StringBuilder()

            while (pq.isNotEmpty()) {
                val first = pq.poll()

                if (
                    result.length >= 2 &&
                        result[result.length - 1].code == first[1] &&
                        result[result.length - 2].code == first[1]
                ) {
                    if (pq.isEmpty()) break

                    val second = pq.poll()
                    result.append(second[1].toChar())
                    second[0]--

                    if (second[0] > 0) pq.offer(second)
                    pq.offer(first)
                    continue
                }

                result.append(first[1].toChar())
                first[0]--
                if (first[0] > 0) pq.offer(first)
            }

            return result.toString()
        }
    }
}
