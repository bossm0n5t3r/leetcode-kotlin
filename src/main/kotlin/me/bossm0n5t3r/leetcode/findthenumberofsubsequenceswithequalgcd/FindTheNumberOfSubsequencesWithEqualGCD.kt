package me.bossm0n5t3r.leetcode.findthenumberofsubsequenceswithequalgcd

class FindTheNumberOfSubsequencesWithEqualGCD {
    class Solution {
        private companion object {
            const val MODULO = 1_000_000_007
        }

        fun subsequencePairCount(nums: IntArray): Int {
            val maxOfNums = nums.maxOrNull() ?: 0

            var dp = Array(maxOfNums + 1) { IntArray(maxOfNums + 1) }
            dp[0][0] = 1

            for (num in nums) {
                val ndp = Array(maxOfNums + 1) { IntArray(maxOfNums + 1) }
                val gcdWithNum = IntArray(maxOfNums + 1) { gcd(it, num) }
                for (i in 0..maxOfNums) {
                    val divisor1 = gcdWithNum[i]
                    val dpRow = dp[i]
                    val ndpRow = ndp[i]
                    val ndpDiv1Row = ndp[divisor1]
                    for (j in 0..maxOfNums) {
                        val tmp = dpRow[j]
                        if (tmp == 0) continue

                        val divisor2 = gcdWithNum[j]
                        ndpRow[j] = addMod(ndpRow[j], tmp)
                        ndpDiv1Row[j] = addMod(ndpDiv1Row[j], tmp)
                        ndpRow[divisor2] = addMod(ndpRow[divisor2], tmp)
                    }
                }
                dp = ndp
            }

            var result = 0
            for (i in 1..maxOfNums) {
                result = addMod(result, dp[i][i])
            }
            return result
        }

        private fun addMod(a: Int, b: Int): Int {
            val sum = a + b
            return if (sum >= MODULO) sum - MODULO else sum
        }

        private fun gcd(a: Int, b: Int): Int {
            var x = a
            var y = b
            while (y != 0) {
                val temp = x
                x = y
                y = temp % y
            }
            return x
        }
    }
}
