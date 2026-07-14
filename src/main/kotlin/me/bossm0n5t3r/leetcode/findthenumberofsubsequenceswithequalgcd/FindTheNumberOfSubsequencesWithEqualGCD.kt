package me.bossm0n5t3r.leetcode.findthenumberofsubsequenceswithequalgcd

class FindTheNumberOfSubsequencesWithEqualGCD {
    class Solution {
        private companion object {
            const val MODULO = 1_000_000_007
        }

        fun subsequencePairCount(nums: IntArray): Int {
            var maxOfNums = 0
            for (num in nums) {
                maxOfNums = maxOf(maxOfNums, num)
            }

            var dp = Array(maxOfNums + 1) { IntArray(maxOfNums + 1) { 0 } }
            dp[0][0] = 1

            for (num in nums) {
                val ndp = Array(maxOfNums + 1) { IntArray(maxOfNums + 1) { 0 } }
                for (i in 0..maxOfNums) {
                    val divisor1 = gcd(i, num)
                    for (j in 0..maxOfNums) {
                        val tmp = dp[i][j]
                        if (tmp == 0) {
                            continue
                        }
                        val divisor2 = gcd(j, num)
                        ndp[i][j] = (ndp[i][j] + tmp) % MODULO
                        ndp[divisor1][j] = (ndp[divisor1][j] + tmp) % MODULO
                        ndp[i][divisor2] = (ndp[i][divisor2] + tmp) % MODULO
                    }
                }
                dp = ndp
            }

            var result = 0
            for (i in 1..maxOfNums) {
                result = (result + dp[i][i]) % MODULO
            }
            return result
        }

        private fun gcd(a: Int, b: Int): Int {
            var a = a
            var b = b
            while (b != 0) {
                val temp = a
                a = b
                b = temp % b
            }
            return a
        }
    }
}
