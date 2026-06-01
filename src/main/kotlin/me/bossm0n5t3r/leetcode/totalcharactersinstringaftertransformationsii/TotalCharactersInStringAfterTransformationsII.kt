package me.bossm0n5t3r.leetcode.totalcharactersinstringaftertransformationsii

class TotalCharactersInStringAfterTransformationsII {
    class Solution {
        fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
            val modulo = 1_000_000_007
            val countArray = LongArray(26)

            // 초기 문자 카운트
            for (c in s) {
                countArray[c - 'a']++
            }

            // 변환 매트릭스 미리 계산
            val transformMatrix = Array(26) { LongArray(26) }
            for (i in 0..25) {
                for (j in 0 until nums[i]) {
                    transformMatrix[i][(i + j + 1) % 26] = 1L
                }
            }

            // t번의 변환을 행렬 거듭제곱으로 계산
            val finalMatrix = matrixPower(transformMatrix, t, modulo)

            // 최종 결과 계산
            val result = LongArray(26)
            for (i in 0..25) {
                for (j in 0..25) {
                    result[i] = (result[i] + (countArray[j] * finalMatrix[j][i]) % modulo) % modulo
                }
            }

            return result.sum().rem(modulo).toInt()
        }

        // 행렬 거듭제곱으로 t번의 변환 한번에 계산
        private fun multiplyMatrix(
            a: Array<LongArray>,
            b: Array<LongArray>,
            modulo: Int,
        ): Array<LongArray> {
            val result = Array(26) { LongArray(26) }
            for (i in 0..25) {
                for (j in 0..25) {
                    for (k in 0..25) {
                        result[i][j] = (result[i][j] + (a[i][k] * b[k][j]) % modulo) % modulo
                    }
                }
            }
            return result
        }

        private fun matrixPower(
            matrix: Array<LongArray>,
            power: Int,
            modulo: Int,
        ): Array<LongArray> {
            if (power == 0) {
                val identity = Array(26) { i -> LongArray(26) { j -> if (i == j) 1L else 0L } }
                return identity
            }
            if (power == 1) return matrix

            val half = matrixPower(matrix, power / 2, modulo)
            val result = multiplyMatrix(half, half, modulo)
            return if (power % 2 == 0) result else multiplyMatrix(result, matrix, modulo)
        }
    }
}
