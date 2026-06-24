package me.bossm0n5t3r.leetcode.numberofzigzagarraysii

class NumberOfZigzagArraysII {
    class Solution {
        private companion object {
            const val MOD = 1_000_000_007L
        }

        fun zigZagArrays(n: Int, l: Int, r: Int): Int {
            val m = r - l + 1
            if (n == 1) return m
            // 길이 2인 경우: 인접한 값이 서로 다른(a != b) 모든 쌍의 수 = m * (m - 1)
            if (n == 2) return ((m.toLong() * (m - 1)) % MOD).toInt()

            // [알고리즘: 행렬 거듭제곱]
            // 1. 값의 대소관계만 중요하므로 [0, m-1] 인덱스로 치환.
            // 2. 대칭성 활용: down[i] = up[m-1-i] (예: m=3, up=[0,1,2] -> down=[2,1,0])
            // 3. 전이 행렬 T 구성: newUp[i] = sum_{k=m-i}^{m-1} up[k]
            //    (예: m=3, i=1 => newUp[1] = up[2] = 2)
            // 4. 결과는 양방향(up/down) 합산: 2 * sum(up_n)
            // 5. 제약 n <= 10^9, m <= 75 이므로 O(m³ log n) 시간 복잡도.

            val size = m
            // 전이 행렬 T: T[i][k] = 1 (k >= m-i) else 0
            var base = Array(size) { i -> LongArray(size) { j -> if (j >= size - i) 1L else 0L } }
            // 단위 행렬 I
            var result = Array(size) { i -> LongArray(size) { j -> if (i == j) 1L else 0L } }

            // 행렬 거듭제곱 (result = T^(n-2))
            var e = n - 2
            while (e > 0) {
                if (e and 1 == 1) result = matMul(result, base, size)
                base = matMul(base, base, size)
                e = e shr 1
            }

            // up_n = result * up_initial (up_initial[k] = k)
            var sumUp = 0L
            for (i in 0 until size) {
                val row = result[i]
                var v = 0L
                for (k in 0 until size) {
                    v = (v + row[k] * k) % MOD
                }
                sumUp = (sumUp + v) % MOD
            }

            return ((sumUp * 2) % MOD).toInt()
        }

        private fun matMul(a: Array<LongArray>, b: Array<LongArray>, size: Int): Array<LongArray> {
            val c = Array(size) { LongArray(size) }
            for (i in 0 until size) {
                val ai = a[i]
                val ci = c[i]
                for (k in 0 until size) {
                    val aik = ai[k]
                    if (aik == 0L) continue // 희소 행렬 최적화
                    val bk = b[k]
                    for (j in 0 until size) {
                        ci[j] = (ci[j] + aik * bk[j]) % MOD
                    }
                }
            }
            return c
        }
    }
}
