package me.bossm0n5t3r.leetcode.imageoverlap

class ImageOverlap {
    class Solution {
        fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
            val n = img1.size
            val img1Ones = mutableListOf<Pair<Int, Int>>()
            val img2Ones = mutableListOf<Pair<Int, Int>>()
            for (r in 0 until n) {
                for (c in 0 until n) {
                    if (img1[r][c] == 1) img1Ones += r to c
                    if (img2[r][c] == 1) img2Ones += r to c
                }
            }
            val frequency = mutableMapOf<Pair<Int, Int>, Int>().withDefault { 0 }
            for ((r1, c1) in img1Ones) {
                for ((r2, c2) in img2Ones) {
                    val shift = (r2 - r1) to (c2 - c1)
                    frequency[shift] = frequency.getValue(shift) + 1
                }
            }
            return frequency.values.maxOrNull() ?: 0
        }
    }
}
