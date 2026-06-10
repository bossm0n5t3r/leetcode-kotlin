package me.bossm0n5t3r.leetcode.maximumtotalsubarrayvalueii

class MaximumTotalSubarrayValueII {
    class Solution {
        /**
         * Complexity Analysis
         * - Time Complexity: O(n log V), where n is nums.size and V is max(nums) - min(nums).
         *   countAndSumLessThan runs in O(n), and it is called during binary search over range
         *   values.
         * - Space Complexity: O(n), for the monotonic block queues.
         */
        fun maxTotalValue(nums: IntArray, k: Int): Long {
            val totalCount = nums.size.toLong() * (nums.size + 1) / 2
            val maxRange = nums.max().toLong() - nums.min().toLong()

            // threshold = k 번째로 큰 subarray range 값
            // range >= mid 인 subarray 개수가 k 개 이상이면 mid 는 가능한 경계값
            var low = 0L
            var high = maxRange
            while (low < high) {
                val mid = (low + high + 1) / 2
                val countAtLeastMid = totalCount - countAndSumLessThan(nums, mid).count
                if (countAtLeastMid >= k) {
                    low = mid
                } else {
                    high = mid - 1
                }
            }

            val threshold = low

            // threshold 보다 큰 range 들은 전부 상위 k 개에 포함됨
            // 나머지 부족한 개수는 정확히 threshold 값을 가진 subarray 들로 채움
            val totalRangeSum = countAndSumLessThan(nums, maxRange + 1).sum
            val lessThanNext = countAndSumLessThan(nums, threshold + 1)
            val countGreaterThanThreshold = totalCount - lessThanNext.count
            val sumGreaterThanThreshold = totalRangeSum - lessThanNext.sum

            return sumGreaterThanThreshold + (k - countGreaterThanThreshold) * threshold
        }

        private data class CountAndSum(val count: Long, val sum: Long)

        private data class Block(val value: Long, var count: Int)

        /**
         * range(max - min)가 limit 보다 작은 subarray 들의 개수와 range 합을 구한다.
         *
         * right 를 하나씩 늘리면서, 현재 right 에서 끝나는 유효 suffix 들만 누적한다. 예를 들어 right = 2 일 때 [2], [1..2],
         * [0..2] 같은 suffix 들의 max 합과 min 합을 따로 관리하면 range 합은 `max 합 - min 합`으로 한 번에 구할 수 있다.
         */
        private fun countAndSumLessThan(nums: IntArray, limit: Long): CountAndSum {
            if (limit <= 0) return CountAndSum(0, 0)

            // maxBlocks / minBlocks 는 현재 window 에서 right 로 끝나는 모든 suffix 들의
            // 최댓값/최솟값을 block 단위로 압축해서 관리
            val maxBlocks = ArrayDeque<Block>()
            val minBlocks = ArrayDeque<Block>()
            var left = 0
            var count = 0L
            var sum = 0L
            var sumOfMaxEndingHere = 0L
            var sumOfMinEndingHere = 0L

            for (right in nums.indices) {
                val num = nums[right].toLong()

                var maxCount = 1
                // 새 값 num 이 더 크면, 기존의 작은 max 후보들은 num 으로 대체된다.
                // 제거된 block 의 suffix 개수는 num block 으로 합쳐준다.
                while (maxBlocks.isNotEmpty() && maxBlocks.last().value <= num) {
                    val last = maxBlocks.removeLast()
                    maxCount += last.count
                    sumOfMaxEndingHere -= last.value * last.count
                }
                maxBlocks.addLast(Block(num, maxCount))
                sumOfMaxEndingHere += num * maxCount

                var minCount = 1
                // 새 값 num 이 더 작으면, 기존의 큰 min 후보들은 num 으로 대체된다.
                while (minBlocks.isNotEmpty() && minBlocks.last().value >= num) {
                    val last = minBlocks.removeLast()
                    minCount += last.count
                    sumOfMinEndingHere -= last.value * last.count
                }
                minBlocks.addLast(Block(num, minCount))
                sumOfMinEndingHere += num * minCount

                // window 의 전체 range 가 limit 이상이면, left 를 줄여서
                // 현재 window 안의 모든 subarray range 가 limit 미만이 되게 만듦
                while (maxBlocks.first().value - minBlocks.first().value >= limit) {
                    sumOfMaxEndingHere -= maxBlocks.first().value
                    if (--maxBlocks.first().count == 0) maxBlocks.removeFirst()

                    sumOfMinEndingHere -= minBlocks.first().value
                    if (--minBlocks.first().count == 0) minBlocks.removeFirst()

                    left++
                }

                // while 이후 [left..right] 안의 suffix 들은 모두 range < limit 이다.
                count += (right - left + 1).toLong()

                // right 에서 끝나는 유효 suffix 들의 range 합 = max 합 - min 합.
                sum += sumOfMaxEndingHere - sumOfMinEndingHere
            }

            return CountAndSum(count, sum)
        }
    }
}
