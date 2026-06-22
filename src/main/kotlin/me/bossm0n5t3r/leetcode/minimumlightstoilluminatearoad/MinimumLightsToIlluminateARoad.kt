package me.bossm0n5t3r.leetcode.minimumlightstoilluminatearoad

class MinimumLightsToIlluminateARoad {
    class Solution {
        fun minLights(lights: IntArray): Int {
            val n = lights.size
            val visible = BooleanArray(n)
            for (i in lights.indices) {
                val light = lights[i]
                if (light > 0) {
                    for (j in (i - light).coerceAtLeast(0)..(i + light).coerceAtMost(n - 1)) {
                        visible[j] = true
                    }
                }
            }
            var result = 0
            for (i in lights.indices) {
                if (visible[i]) continue
                if (i < n - 1 && !visible[i + 1]) {
                    result++
                    visible[i] = true
                    visible[i + 1] = true
                    if (i + 2 < n) visible[i + 2] = true
                    continue
                }
                visible[i] = true
                result++
            }
            return result
        }
    }
}
