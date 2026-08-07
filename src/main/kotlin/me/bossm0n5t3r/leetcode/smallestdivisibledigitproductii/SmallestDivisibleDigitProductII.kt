package me.bossm0n5t3r.leetcode.smallestdivisibledigitproductii

class SmallestDivisibleDigitProductII {
    class Solution {
        /**
         * 1. t의 소인수가 2,3,5,7 외에 있으면 -1
         * 2. num과 같은 길이에서 조건을 만족하는 가장 작은 수 탐색
         * 3. 불가능하면 더 긴 길이에서 탐색
         */
        fun smallestNumber(num: String, t: Long): String {
            val (remainder, factorization) = t.factorization()
            if (remainder > 0) return "-1"

            val n = num.length

            // prefixNeed[i]: num[0..i-1]까지 소진했을 때 남은 2,3,5,7 개수
            val prefixNeed = Array(n + 1) { LongArray(4) }
            // hasZeroPrefix[i]: num[0..i-1] 중 0이 하나라도 있으면 true
            val hasZeroPrefix = BooleanArray(n + 1)
            prefixNeed[0] = factorization.copyOf()
            for (i in num.indices) {
                prefixNeed[i + 1] = prefixNeed[i].copyOf()
                prefixNeed[i + 1].subtract(DIGIT_FACTORS[num[i] - '0'])
                hasZeroPrefix[i + 1] = hasZeroPrefix[i] || num[i] == '0'
            }

            // num 자체가 유효하고(0이 없고) 조건을 만족하면 num 반환
            if (!hasZeroPrefix[n] && prefixNeed[n].all { it == 0L }) return num

            // 같은 길이: 오른쪽부터 증가 지점을 찾아 가장 작은 수 생성
            for (p in n - 1 downTo 0) {
                // 0이 포함된 prefix는 그대로 두면 곱이 0이 되므로 사용 불가
                if (hasZeroPrefix[p]) continue
                val curNeed = prefixNeed[p]
                val lower = num[p] - '0'
                for (d in lower + 1..9) {
                    val nextNeed = curNeed.copyOf()
                    nextNeed.subtract(DIGIT_FACTORS[d])
                    val remainingPositions = n - p - 1
                    if (feasible(nextNeed, remainingPositions)) {
                        val suffix = smallestSuffix(nextNeed, remainingPositions)
                        return num.substring(0, p) + d + suffix
                    }
                }
            }

            // 더 긴 길이: 앞에 1을 최대한 붙이고, 최소 길이의 접미사로 해결
            val minLen = generateSequence(1) { it + 1 }.first { feasible(factorization, it) }
            val totalLen = maxOf(n + 1, minLen)
            val leadingOnes = totalLen - minLen
            return "1".repeat(leadingOnes) + smallestSuffix(factorization, minLen)
        }

        /** k개의 1~9 자릿수로 need(2,3,5,7 필요 개수)를 커버할 수 있는지 판단 */
        private fun feasible(need: LongArray, k: Int): Boolean {
            val (a, b, c, d) = need // 필요한 2, 3, 5, 7의 개수

            // 5, 7은 한 자릿수당 하나씩만 제공 가능
            if (c + d > k) return false

            val m = k - c - d // 2, 3 전용 자릿수
            if (a == 0L && b == 0L) return true

            // 6은 2와 3을 동시에 하나씩 제공
            val max6 = minOf(m, a, b)
            for (x6 in 0L..max6) {
                val rem2 = maxOf(0L, a - x6)
                val rem3 = maxOf(0L, b - x6)
                val remDigits = m - x6
                // 2: 8이 3개, 4가 2개, 2가 1개 제공
                val min2Digits = if (rem2 == 0L) 0L else (rem2 + 2) / 3
                // 3: 9가 2개, 3이 1개 제공
                val min3Digits = if (rem3 == 0L) 0L else (rem3 + 1) / 2
                if (min2Digits + min3Digits <= remDigits) return true
            }
            return false
        }

        /** 길이가 정확히 length이면서 need를 커버하는 사전순으로 가장 작은 문자열 */
        private fun smallestSuffix(need: LongArray, length: Int): String {
            if (length == 0) return ""
            val cur = need.copyOf()
            val sb = StringBuilder(length)
            for (i in 0 until length) {
                // 각 위치에서 1부터 9까지, 남은 자리로 feasible한 가장 작은 수 선택
                for (d in 1..9) {
                    val next = cur.copyOf()
                    next.subtract(DIGIT_FACTORS[d])
                    if (feasible(next, length - i - 1)) {
                        sb.append('0' + d)
                        cur.subtract(DIGIT_FACTORS[d])
                        break
                    }
                }
            }
            return sb.toString()
        }

        /** need에서 digit의 소인수 개수를 뺄 때 0 이하로 낮아지면 0으로 고정 */
        private fun LongArray.subtract(factors: IntArray) {
            for (i in factors.indices) {
                this[i] = maxOf(0L, this[i] - factors[i])
            }
        }

        /** t를 2,3,5,7로 소인수 분해 first: 2,3,5,7 외의 남은 소인수 (없으면 0) second: [2,3,5,7]의 지수 */
        private fun Long.factorization(): Pair<Long, LongArray> {
            val result = LongArray(4) { 0 }
            var tmp = this
            while (tmp > 1) {
                when {
                    tmp % 2 == 0L -> {
                        result[0]++
                        tmp /= 2
                    }

                    tmp % 3 == 0L -> {
                        result[1]++
                        tmp /= 3
                    }

                    tmp % 5 == 0L -> {
                        result[2]++
                        tmp /= 5
                    }

                    tmp % 7 == 0L -> {
                        result[3]++
                        tmp /= 7
                    }

                    else -> break
                }
            }
            return if (tmp > 1) tmp to result else 0L to result
        }

        companion object {
            // 인덱스 = digit, 값 = [2의 개수, 3의 개수, 5의 개수, 7의 개수]
            private val DIGIT_FACTORS =
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(2, 0, 0, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(3, 0, 0, 0),
                    intArrayOf(0, 2, 0, 0),
                )
        }
    }
}
