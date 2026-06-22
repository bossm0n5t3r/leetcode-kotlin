package me.bossm0n5t3r.leetcode.minimumlightstoilluminatearoad

class MinimumLightsToIlluminateARoad {
    class Solution {
        fun minLights(lights: IntArray): Int {
            val n = lights.size
            // coverageChanges is a difference array:
            // +1 at the start of a lamp's range, -1 just after the end.
            // Its prefix sum tells whether the current position is lit by any existing lamp.
            //
            // Example: a lamp at index 3 with range 2 lights [1, 5].
            //
            // index:            0   1   2   3   4   5   6
            // lit by lamp:          <----------->
            // coverageChanges:  0  +1   0   0   0   0  -1
            // prefix sum:       0   1   1   1   1   1   0
            val coverageChanges = IntArray(n + 1)

            for (i in lights.indices) {
                val light = lights[i]
                if (light == 0) continue

                val left = (i - light).coerceAtLeast(0)
                val right = (i + light).coerceAtMost(n - 1)
                coverageChanges[left]++
                coverageChanges[right + 1]--
            }

            // addedCoverageUntil is the rightmost position lit by lamps we add.
            // When position i is not lit by existing lamps or added lamps,
            // adding one lamp at i + 1 is optimal because it covers i, i + 1, and i + 2.
            //
            // If i is the first dark position:
            //
            // index:       ...   i  i+1  i+2  ...
            // added lamp:       <----------->
            // covered until:              i+2
            var result = 0
            var existingCoverage = 0
            var addedCoverageUntil = -1

            for (i in lights.indices) {
                existingCoverage += coverageChanges[i]
                if (existingCoverage > 0 || i <= addedCoverageUntil) continue

                result++
                addedCoverageUntil = i + 2
            }

            return result
        }
    }
}
