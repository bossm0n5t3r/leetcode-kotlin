package me.bossm0n5t3r.leetcode.freedomTrail

import kotlin.math.abs

class FreedomTrail {
    class Solution {
        fun findRotateSteps(ring: String, key: String): Int =
            dp(ring, 0, key, 0, Array(ring.length) { IntArray(key.length) { -1 } })

        private fun dp(
            ring: String,
            ringIndex: Int,
            key: String,
            keyIndex: Int,
            memo: Array<IntArray>,
        ): Int {
            if (keyIndex == key.length) return 0
            if (memo[ringIndex][keyIndex] != -1) return memo[ringIndex][keyIndex]

            var result = Int.MAX_VALUE
            for (i in ring.indices) {
                if (ring[i] == key[keyIndex]) {
                    val stepsForward = abs(i - ringIndex)
                    val stepsBackward = ring.length - stepsForward

                    val minSteps =
                        minOf(stepsForward, stepsBackward) +
                            dp(ring, i, key, keyIndex + 1, memo) +
                            1

                    if (result > minSteps) {
                        result = minSteps
                    }
                }
            }

            memo[ringIndex][keyIndex] = result
            return result
        }
    }
}
