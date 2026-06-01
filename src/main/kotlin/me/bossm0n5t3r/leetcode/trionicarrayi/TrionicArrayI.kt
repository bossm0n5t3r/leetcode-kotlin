package me.bossm0n5t3r.leetcode.trionicarrayi

class TrionicArrayI {
    class Solution {
        fun isTrionic(nums: IntArray): Boolean {
            if (nums.size < 4) return false

            var phase = 0 // 0: 초기 증가 대기, 1: 증가 중, 2: 감소 중, 3: 다시 증가 중

            for (i in 1 until nums.size) {
                if (nums[i] == nums[i - 1]) return false

                val isIncreasing = nums[i] > nums[i - 1]

                when (phase) {
                    0,
                    1 -> {
                        phase =
                            if (isIncreasing) {
                                1
                            } else if (phase == 1) {
                                2
                            } else {
                                return false
                            }
                    }

                    2 -> {
                        if (isIncreasing) phase = 3 else continue
                    }

                    3 -> {
                        if (!isIncreasing) return false
                    }
                }
            }

            return phase == 3
        }
    }
}
