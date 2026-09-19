package me.bossm0n5t3r.leetcode.circleandrectangleoverlapping

class CircleAndRectangleOverlapping {
    class Solution {
        fun checkOverlap(
            radius: Int,
            xCenter: Int,
            yCenter: Int,
            x1: Int,
            y1: Int,
            x2: Int,
            y2: Int,
        ): Boolean {
            return when {
                xCenter + radius < x1 -> false
                yCenter + radius < y1 -> false
                x2 < xCenter - radius -> false
                y2 < yCenter - radius -> false
                else -> {
                    val closestX = xCenter.coerceIn(x1, x2)
                    val closestY = yCenter.coerceIn(y1, y2)

                    val dx = (xCenter - closestX).toLong()
                    val dy = (yCenter - closestY).toLong()
                    val radius = radius.toLong()
                    dx * dx + dy * dy <= radius * radius
                }
            }
        }
    }
}
