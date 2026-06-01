package me.bossm0n5t3r.leetcode.canPlaceFlowers

class CanPlaceFlowers {
    class Solution {
        fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
            if (n == 0) return true
            val extendFlowerBed = intArrayOf(0) + flowerbed + 0
            var tmpN = n
            for (i in 1..flowerbed.size) {
                if (tmpN == 0) return true
                if (
                    extendFlowerBed[i] == 0 && extendFlowerBed[i - 1] + extendFlowerBed[i + 1] == 0
                ) {
                    extendFlowerBed[i] = 1
                    tmpN--
                }
            }
            return tmpN == 0
        }
    }
}
