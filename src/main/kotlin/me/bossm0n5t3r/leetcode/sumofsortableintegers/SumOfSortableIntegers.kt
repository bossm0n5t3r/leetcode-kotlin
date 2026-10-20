package me.bossm0n5t3r.leetcode.sumofsortableintegers

class SumOfSortableIntegers {
    class Solution {
        fun sortableIntegers(nums: IntArray): Int {
            val n = nums.size

            // 1. 감소 지점의 누적합
            // dropPrefix[i] = 0..i 사이에서 nums[j-1] > nums[j]인 횟수
            val dropPrefix = IntArray(n)

            for (i in 1 until n) {
                dropPrefix[i] = dropPrefix[i - 1]
                if (nums[i - 1] > nums[i]) dropPrefix[i]++
            }

            // 2. Prefix Maximum
            // prefixMax[i] = nums[0..i-1]의 최댓값
            val prefixMax = IntArray(n + 1)
            prefixMax[0] = Int.MIN_VALUE

            for (i in 0 until n) prefixMax[i + 1] = maxOf(prefixMax[i], nums[i])

            // 3. Suffix Minimum
            // suffixMin[i] = nums[i..n-1]의 최솟값
            val suffixMin = IntArray(n + 1)
            suffixMin[n] = Int.MAX_VALUE

            for (i in n - 1 downTo 0) suffixMin[i] = minOf(suffixMin[i + 1], nums[i])

            // 4. n의 모든 약수 구하기
            val divisors = mutableListOf<Int>()

            var k = 1
            while (k <= n / k) {
                if (n % k == 0) {
                    divisors += k
                    if (k != n / k) divisors += n / k
                }
                k++
            }

            // 5. 각 k가 sortable인지 검사
            var answer = 0

            for (k in divisors) {

                var sortable = true

                // 길이 k씩 블록 분할
                for (start in 0 until n step k) {
                    var end = start + k - 1

                    // 블록 내부 감소 횟수
                    var drops = dropPrefix[end] - dropPrefix[start]

                    // 마지막 -> 처음의 원형 경계 검사
                    if (nums[end] > nums[start]) drops++

                    // 원형 감소 지점이 2개 이상이면
                    // 회전으로 오름차순 정렬할 수 없음
                    if (drops > 1) {
                        sortable = false
                        break
                    }

                    // 앞쪽 블록들과 뒤쪽 블록들의 값 범위 검사
                    // 전체 배열이 정렬되려면 반드시 만족해야 함
                    if (start > 0) {
                        if (prefixMax[start] > suffixMin[start]) {
                            sortable = false
                            break
                        }
                    }
                }
                if (sortable) answer += k
            }
            return answer
        }
    }
}
