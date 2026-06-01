package me.bossm0n5t3r.leetcode.dota2Senate

import java.util.LinkedList

class Dota2Senate {
    class Solution {
        fun predictPartyVictory(senate: String): String {
            var bannedRadiant = 0
            var bannedDire = 0
            var totalRadiants = senate.count { it == 'R' }
            var totalDires = senate.count { it == 'D' }
            val queue = LinkedList<Char>().apply { this.addAll(senate.toList()) }
            while (totalRadiants != 0 && totalDires != 0) {
                val cur = queue.poll()
                if (cur == 'R') {
                    if (bannedRadiant > 0) {
                        bannedRadiant--
                        totalRadiants--
                    } else {
                        queue.add(cur)
                        bannedDire++
                    }
                } else {
                    if (bannedDire > 0) {
                        bannedDire--
                        totalDires--
                    } else {
                        queue.add(cur)
                        bannedRadiant++
                    }
                }
            }
            return if (queue.poll() == 'R') "Radiant" else "Dire"
        }
    }
}
