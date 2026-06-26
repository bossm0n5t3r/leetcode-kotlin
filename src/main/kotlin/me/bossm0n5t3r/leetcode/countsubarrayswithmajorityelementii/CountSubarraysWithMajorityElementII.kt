package me.bossm0n5t3r.leetcode.countsubarrayswithmajorityelementii

class CountSubarraysWithMajorityElementII {
    class Solution {
        fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
            val n = nums.size
            val pref = IntArray(n + 1)
            for (i in 0 until n) {
                pref[i + 1] = pref[i] + if (nums[i] == target) 1 else -1
            }

            val tree = IntArray(2 * n + 2)
            fun update(idx: Int, delta: Int) {
                var i = idx
                while (i < tree.size) {
                    tree[i] += delta
                    i += i and -i
                }
            }

            fun query(idx: Int): Int {
                var sum = 0
                var i = idx
                while (i > 0) {
                    sum += tree[i]
                    i -= i and -i
                }
                return sum
            }

            val offset = n + 1
            var count = 0L

            for (value in pref) {
                count += query(value - 1 + offset)
                update(value + offset, 1)
            }

            return count
        }
    }
}
