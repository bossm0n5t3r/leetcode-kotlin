package me.bossm0n5t3r.leetcode.maximizeactivesectionwithtradei

class MaximizeActiveSectionWithTradeI {
    class Solution {
        private data class Segment(val isOne: Boolean, val length: Int)

        fun maxActiveSectionsAfterTrade(s: String): Int {
            val segments = buildSegments(s)

            var totalOnes = 0
            var bestGain = 0
            for (i in segments.indices) {
                val (isOne, length) = segments[i]
                if (isOne) totalOnes += length

                if (i == 0 || i == segments.lastIndex) continue
                if (!segments[i - 1].isOne && !segments[i + 1].isOne) {
                    bestGain = maxOf(bestGain, segments[i - 1].length + segments[i + 1].length)
                }
            }

            return totalOnes + bestGain
        }

        private fun buildSegments(s: String): List<Segment> {
            if (s.isEmpty()) return emptyList()

            return buildList {
                var isOne = s[0] == '1'
                var length = 1
                for (i in 1..s.lastIndex) {
                    val cur = s[i] == '1'
                    if (cur == isOne) {
                        length++
                    } else {
                        add(Segment(isOne, length))
                        isOne = cur
                        length = 1
                    }
                }
                add(Segment(isOne, length))
            }
        }
    }
}
