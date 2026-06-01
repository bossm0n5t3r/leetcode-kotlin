package me.bossm0n5t3r.leetcode.convert1dArrayInto2dArray

class Convert1dArrayInto2dArray {
    class Solution {
        fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
            if (original.size != m * n) return emptyArray()
            return original.toList().chunked(n).map { it.toIntArray() }.toTypedArray()
        }
    }
}
