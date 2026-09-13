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
            for ((img1First, img1Second) in img1Ones) {
                for ((img2First, img2Second) in img2Ones) {
                    val dr = img2First - img1First
                    val dc = img2Second - img1Second
                    frequency[dr to dc] = frequency.getValue(dr to dc) + 1
                }
            }
            return frequency.values.maxOrNull() ?: 0
        }
    }
}
