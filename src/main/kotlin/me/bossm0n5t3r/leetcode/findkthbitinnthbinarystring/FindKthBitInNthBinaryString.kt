package me.bossm0n5t3r.leetcode.findkthbitinnthbinarystring

class FindKthBitInNthBinaryString {
    class Solution {
        fun findKthBit(n: Int, k: Int): Char {
            var invertCount = 0
            var len = (1 shl n) - 1

            var tmpK = k
            while (tmpK > 1) {
                if (tmpK == len / 2 + 1) {
                    return if (invertCount % 2 == 0) '1' else '0'
                }

                if (tmpK > len / 2) {
                    tmpK = len + 1 - tmpK
                    invertCount++
                }

                len /= 2
            }

            return if (invertCount % 2 == 0) '0' else '1'
        }
    }
}
