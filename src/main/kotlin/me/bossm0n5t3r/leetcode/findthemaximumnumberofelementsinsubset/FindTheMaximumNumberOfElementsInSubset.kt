package me.bossm0n5t3r.leetcode.findthemaximumnumberofelementsinsubset

import kotlin.math.sqrt

class FindTheMaximumNumberOfElementsInSubset {
    class Solution {
        fun maximumLength(nums: IntArray): Int {
            val numToCount = mutableMapOf<Int, Int>()
            for (num in nums) {
                numToCount[num] = numToCount.getOrDefault(num, 0) + 1
            }

            // 1의 개수는 짝수일 경우 1을 뺀 홀수 개수만큼만 사용할 수 있도록 처리
            var result = numToCount[1]?.let { if (it % 2 == 0) it - 1 else it } ?: 1

            for ((key, count) in numToCount) {
                if (key == 1) continue
                if (count < 2) continue

                // 중복 탐색 방지:
                // key 가 어떤 수 y 의 제곱 (key = y^2) 이고 y 가 2개 이상 존재하면,
                // y 에서 시작하여 탐색할 때 key 도 탐색 범위에 포함되므로 중복 탐색을 건너뜀
                val sqrt = sqrt(key.toDouble()).toInt()
                if (sqrt * sqrt == key && numToCount.getOrDefault(sqrt, 0) >= 2) {
                    continue
                }

                var currentCount = 0
                var next: Long = key.toLong()
                while (true) {
                    if (next > Int.MAX_VALUE) break
                    val nextInt = next.toInt()
                    val c = numToCount[nextInt] ?: break

                    if (c >= 2) {
                        currentCount++
                        next *= next
                    } else {
                        // 마지막 원소는 1개만 있어도 subset의 가운데(가장 큰 수) 역할을 할 수 있음
                        currentCount++
                        break
                    }
                }
                result = maxOf(result, 2 * currentCount - 1)
            }
            return result
        }
    }
}
