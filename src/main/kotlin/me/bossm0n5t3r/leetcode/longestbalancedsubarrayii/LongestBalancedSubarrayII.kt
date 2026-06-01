package me.bossm0n5t3r.leetcode.longestbalancedsubarrayii

import kotlin.math.max
import kotlin.math.min

class LongestBalancedSubarrayII {
    class Solution {
        // Segment Tree over an array of size n
        class SegmentTree(private var n: Int) {
            var size: Int = 4 * n
            var sum: IntArray = IntArray(size)
            var mn: IntArray = IntArray(size)
            var mx: IntArray = IntArray(size)

            fun pull(node: Int) {
                // Helper to recompute information of node by it's children

                val l = node * 2
                val r = node * 2 + 1

                sum[node] = sum[l] + sum[r]
                mn[node] = min(mn[l], sum[l] + mn[r])
                mx[node] = max(mx[l], sum[l] + mx[r])
            }

            /** Update value by index idx in an original array */
            fun update(idx: Int, `val`: Int) {
                var node = 1
                var l = 0
                var r = n - 1
                val path = IntArray(32) // enough for n up to 2^31
                var ps = 0

                while (l != r) {
                    path[ps++] = node
                    val m = l + (r - l) / 2
                    if (idx <= m) {
                        node *= 2
                        r = m
                    } else {
                        node = node * 2 + 1
                        l = m + 1
                    }
                }

                sum[node] = `val`
                mn[node] = `val`
                mx[node] = `val`

                while (ps > 0) {
                    pull(path[--ps])
                }
            }

            /** Find the rightmost index r with the prefix sum (r) = target */
            fun findRightmostPrefix(target: Int): Int {
                var node = 1
                var l = 0
                var r = n - 1
                var sumBefore = 0

                if (target !in mn[node]..mx[node]) return -1

                while (l != r) {
                    val m = l + (r - l) / 2
                    val lchild = node * 2
                    val rchild = node * 2 + 1

                    // Check the right half first
                    val sumBeforeRight = sum[lchild] + sumBefore
                    val needRight = target - sumBeforeRight

                    if (mn[rchild] <= needRight && needRight <= mx[rchild]) {
                        node = rchild
                        l = m + 1
                        sumBefore = sumBeforeRight
                    } else {
                        node = lchild
                        r = m
                    }
                }

                return l
            }
        }

        fun longestBalanced(nums: IntArray): Int {
            val n = nums.size

            val stree = SegmentTree(n) // SegmentTree over balance array for current l
            val first = mutableMapOf<Int, Int>() // val -> first occurrence idx for current l

            var result = 0
            for (l in n - 1 downTo 0) {
                val num = nums[l]

                // If x already had a first occurrence to the right, remove that old marker.
                val old = first[num]
                if (old != null) stree.update(old, 0)

                // Now x becomes the first occurrence at l.
                first[num] = l
                stree.update(l, if (num % 2 == 0) 1 else -1)

                // Find rightmost r >= l such that sum(w[l..r]) == 0
                val r = stree.findRightmostPrefix(0)
                if (r >= l) result = max(result, r - l + 1)
            }

            return result
        }
    }
}
