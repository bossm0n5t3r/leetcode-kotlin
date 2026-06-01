package me.bossm0n5t3r.leetcode.countthenumberoffairpairs

class CountTheNumberOfFairPairs {
    class Solution {
        fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
            nums.sort() // 원본 배열을 직접 정렬하여 추가 메모리 사용 줄임
            var count = 0L

            for (i in nums.indices) {
                // upperBound와 lowerBound를 이진 탐색으로 찾기
                val minTarget = lower - nums[i]
                val maxTarget = upper - nums[i]

                val leftIndex = findLowerBound(nums, i + 1, minTarget)
                val rightIndex = findUpperBound(nums, i + 1, maxTarget)

                if (leftIndex < nums.size && rightIndex >= leftIndex) {
                    count += (rightIndex - leftIndex + 1)
                }
            }
            return count
        }

        private fun findLowerBound(nums: IntArray, start: Int, target: Int): Int {
            var left = start
            var right = nums.size

            while (left < right) {
                val mid = left + (right - left) / 2
                if (nums[mid] < target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        private fun findUpperBound(nums: IntArray, start: Int, target: Int): Int {
            var left = start
            var right = nums.size - 1

            while (left <= right) {
                val mid = left + (right - left) / 2
                if (nums[mid] <= target) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
            return right
        }
    }
}
