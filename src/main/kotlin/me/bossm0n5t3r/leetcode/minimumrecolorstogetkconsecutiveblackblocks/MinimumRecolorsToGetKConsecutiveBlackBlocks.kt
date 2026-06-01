package me.bossm0n5t3r.leetcode.minimumrecolorstogetkconsecutiveblackblocks

import java.util.LinkedList
import java.util.Queue

class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    class Solution {
        fun minimumRecolors(blocks: String, k: Int): Int {
            val queue: Queue<Char> = LinkedList()
            var numWhites = 0
            repeat(k) {
                val cur = blocks[it]
                if (cur == 'W') numWhites++
                queue.offer(cur)
            }

            var numRecolors = numWhites
            for (i in k until blocks.length) {
                if (queue.poll() == 'W') numWhites--

                val cur = blocks[i]
                if (cur == 'W') numWhites++
                queue.offer(cur)

                numRecolors = minOf(numRecolors, numWhites)
            }

            return numRecolors
        }
    }
}
