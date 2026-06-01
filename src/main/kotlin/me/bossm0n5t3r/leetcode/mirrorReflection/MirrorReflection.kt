package me.bossm0n5t3r.leetcode.mirrorReflection

class MirrorReflection {
    class Solution {
        /**
         * @link
         *   https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation
         */
        fun mirrorReflection(p: Int, q: Int): Int {
            var m = 1
            var n = 1
            while (m * p != n * q) {
                n++
                m = n * q / p
            }
            if (m % 2 == 0 && n % 2 == 1) return 0
            if (m % 2 == 1 && n % 2 == 1) return 1
            return if (m % 2 == 1 && n % 2 == 0) 2 else -1
        }
    }
}
