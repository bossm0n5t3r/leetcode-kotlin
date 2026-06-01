package me.bossm0n5t3r.leetcode.furthestBuildingYouCanReach

import java.util.PriorityQueue

class FurthestBuildingYouCanReach {
    class Solution {
        fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
            val pq = PriorityQueue<Int>()
            var bricksLeft = bricks
            for (i in 0 until heights.size - 1) {
                val diff = heights[i + 1] - heights[i]
                if (diff > 0) {
                    pq.add(diff)
                }
                if (pq.size > ladders) {
                    bricksLeft -= pq.poll()
                }
                if (bricksLeft < 0) {
                    return i
                }
            }
            return heights.size - 1
        }
    }
}
