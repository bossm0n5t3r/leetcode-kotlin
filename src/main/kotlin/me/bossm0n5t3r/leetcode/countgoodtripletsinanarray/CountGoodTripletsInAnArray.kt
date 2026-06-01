package me.bossm0n5t3r.leetcode.countgoodtripletsinanarray

class CountGoodTripletsInAnArray {
    class Solution {
        class FenwickTree(size: Int) {
            private val tree = IntArray(size + 1)

            fun update(index: Int, delta: Int) {
                var tmpIndex = index
                tmpIndex++
                while (tmpIndex < tree.size) {
                    tree[tmpIndex] += delta
                    tmpIndex += tmpIndex and -tmpIndex
                }
            }

            fun query(index: Int): Int {
                var tmpIndex = index
                tmpIndex++
                var res = 0
                while (tmpIndex > 0) {
                    res += tree[tmpIndex]
                    tmpIndex -= tmpIndex and -tmpIndex
                }
                return res
            }
        }

        fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
            val n = nums1.size
            val pos2 = IntArray(n)
            val reversedIndexMapping = IntArray(n)
            for (i in 0 until n) {
                pos2[nums2[i]] = i
            }
            for (i in 0 until n) {
                reversedIndexMapping[pos2[nums1[i]]] = i
            }
            val tree = FenwickTree(n)
            var result = 0L
            for (value in 0 until n) {
                val pos = reversedIndexMapping[value]
                val left = tree.query(pos)
                tree.update(pos, 1)
                val right = (n - 1 - pos) - (value - left)
                result += left.toLong() * right
            }
            return result
        }
    }
}
