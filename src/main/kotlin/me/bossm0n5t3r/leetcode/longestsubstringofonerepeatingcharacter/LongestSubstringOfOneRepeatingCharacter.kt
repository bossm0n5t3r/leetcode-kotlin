package me.bossm0n5t3r.leetcode.longestsubstringofonerepeatingcharacter

class LongestSubstringOfOneRepeatingCharacter {
    class Solution {
        fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
            val n = s.length
            val arr = s.toCharArray()

            // 구간 맨 왼쪽 문자
            val lc = CharArray(4 * n)
            // 구간 맨 오른쪽 문자
            val rc = CharArray(4 * n)
            // 왼쪽에서 시작하는 동일 문자 연속 길이
            val pre = IntArray(4 * n)
            // 오른쪽에서 끝나는 동일 문자 연속 길이
            val suf = IntArray(4 * n)
            // 구간 안에서 같은 문자로만 이루어진 최대 연속 길이
            val best = IntArray(4 * n)

            fun pull(idx: Int, l: Int, r: Int) {
                val mid = (l + r) shr 1
                val left = idx shl 1
                val right = left or 1
                val leftSize = mid - l
                val rightSize = r - mid

                lc[idx] = lc[left]
                rc[idx] = rc[right]

                pre[idx] = pre[left]
                if (pre[left] == leftSize && rc[left] == lc[right]) {
                    pre[idx] = leftSize + pre[right]
                }

                suf[idx] = suf[right]
                if (suf[right] == rightSize && rc[left] == lc[right]) {
                    suf[idx] = rightSize + suf[left]
                }

                best[idx] = maxOf(best[left], best[right])
                if (rc[left] == lc[right]) {
                    best[idx] = maxOf(best[idx], suf[left] + pre[right])
                }
            }

            fun build(idx: Int, l: Int, r: Int) {
                if (r - l == 1) {
                    lc[idx] = arr[l]
                    rc[idx] = arr[l]
                    pre[idx] = 1
                    suf[idx] = 1
                    best[idx] = 1
                    return
                }
                val mid = (l + r) shr 1
                build(idx shl 1, l, mid)
                build(idx shl 1 or 1, mid, r)
                pull(idx, l, r)
            }

            fun update(idx: Int, l: Int, r: Int, pos: Int, c: Char) {
                if (r - l == 1) {
                    arr[pos] = c
                    lc[idx] = c
                    rc[idx] = c
                    return
                }
                val mid = (l + r) shr 1
                if (pos < mid) {
                    update(idx shl 1, l, mid, pos, c)
                } else {
                    update(idx shl 1 or 1, mid, r, pos, c)
                }
                pull(idx, l, r)
            }

            build(1, 0, n)

            val q = queryCharacters.length
            val answer = IntArray(q)
            for (i in 0 until q) {
                update(1, 0, n, queryIndices[i], queryCharacters[i])
                answer[i] = best[1]
            }
            return answer
        }
    }
}
