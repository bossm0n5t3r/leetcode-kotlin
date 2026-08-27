package me.bossm0n5t3r.leetcode.lexicographicallysmallestpermutationgreaterthantarget

class LexicographicallySmallestPermutationGreaterThanTarget {
    class Solution {
        fun lexGreaterPermutation(s: String, target: String): String {
            val frequency = IntArray(26)
            for (c in s) {
                frequency[c - 'a']++
            }

            val result = StringBuilder()
            var matched = 0

            // target 과 가능한 만큼 동일하게 맞춘다.
            while (matched < target.length && frequency[target[matched] - 'a'] > 0) {
                val c = target[matched]
                frequency[c - 'a']--
                result.append(c)
                matched++
            }

            // 현재 위치에서 바로 target 보다 크게 만들 수 있는지 확인
            if (matched < target.length) {
                val greater = findGreater(frequency, target[matched])

                if (greater != null) {
                    frequency[greater - 'a']--
                    result.append(greater)
                    appendRemaining(result, frequency)
                    return result.toString()
                }
            }

            // 현재 위치에서 불가능하면 이전 자리로 돌아간다.
            for (i in matched - 1 downTo 0) {
                val removed = result[result.lastIndex]
                result.deleteCharAt(result.lastIndex)
                frequency[removed - 'a']++

                val greater = findGreater(frequency, target[i])

                if (greater != null) {
                    frequency[greater - 'a']--
                    result.append(greater)
                    appendRemaining(result, frequency)
                    return result.toString()
                }
            }

            return ""
        }

        private fun findGreater(frequency: IntArray, target: Char): Char? {
            for (i in target - 'a' + 1 until 26) {
                if (frequency[i] > 0) {
                    return 'a' + i
                }
            }
            return null
        }

        private fun appendRemaining(result: StringBuilder, frequency: IntArray) {
            for (i in 0 until 26) {
                repeat(frequency[i]) { result.append('a' + i) }
            }
        }
    }
}
