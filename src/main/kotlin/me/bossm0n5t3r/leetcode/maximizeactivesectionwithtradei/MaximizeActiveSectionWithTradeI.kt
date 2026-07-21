package me.bossm0n5t3r.leetcode.maximizeactivesectionwithtradei

import java.util.PriorityQueue

class MaximizeActiveSectionWithTradeI {
    class Solution {
        private data class Segment(val section: Int, val length: Int)

        fun maxActiveSectionsAfterTrade(s: String): Int {
            val segments = mutableListOf<Segment>()
            var section = -1
            var length = 0
            for (c in s) {
                val curSection = c.digitToInt()
                if (section == -1) {
                    section = curSection
                    length++
                    continue
                }
                if (curSection != section) {
                    segments += Segment(section, length)
                    section = curSection
                    length = 1
                    continue
                }
                length++
            }
            segments += Segment(section, length)
            var totalNumberOfOnes = 0
            val pq =
                PriorityQueue(
                    compareByDescending<Pair<Int, Int>> { it.first }.thenComparing { it.second }
                )
            for (i in segments.indices) {
                val (section, length) = segments[i]
                if (section == 1) totalNumberOfOnes += length
                if (i == 0 || i == segments.lastIndex) continue
                if (segments[i - 1].section != 0 || segments[i + 1].section != 0) continue
                val delta = length + segments[i - 1].length + segments[i + 1].length
                pq.offer(delta to length)
            }
            var result = totalNumberOfOnes
            while (pq.isNotEmpty()) {
                val (maxDelta, targetOnes) = pq.poll()
                val tmp = maxDelta + totalNumberOfOnes - targetOnes
                if (result < tmp) result = tmp
            }
            return result
        }
    }
}
