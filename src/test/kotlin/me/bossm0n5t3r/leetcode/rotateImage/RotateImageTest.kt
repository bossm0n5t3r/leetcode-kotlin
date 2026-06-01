package me.bossm0n5t3r.leetcode.rotateImage

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RotateImageTest {
    private val rotateImage = RotateImage.Solution()

    data class RotateImageTestData(val matrix: Array<IntArray>, val resultMatrix: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as RotateImageTestData

            if (!matrix.contentDeepEquals(other.matrix)) return false
            if (!resultMatrix.contentDeepEquals(other.resultMatrix)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = matrix.contentDeepHashCode()
            result = 31 * result + resultMatrix.contentDeepHashCode()
            return result
        }
    }

    @Test
    fun rotateMyFirstSolution() {
        val tests =
            listOf(
                RotateImageTestData(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                    arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3)),
                ),
                RotateImageTestData(
                    arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16),
                    ),
                    arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9),
                        intArrayOf(16, 7, 10, 11),
                    ),
                ),
                RotateImageTestData(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1))),
                RotateImageTestData(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                    arrayOf(intArrayOf(3, 1), intArrayOf(4, 2)),
                ),
            )
        tests.forEach { test ->
            val inputMatrix = test.matrix
            inputMatrix.forEach { println(it.toList()) }
            rotateImage.rotateMyFirstSolution(inputMatrix)
        }
    }

    @Test
    fun rotateApproachFirst() {
        val tests =
            listOf(
                RotateImageTestData(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                    arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3)),
                ),
                RotateImageTestData(
                    arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16),
                    ),
                    arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9),
                        intArrayOf(16, 7, 10, 11),
                    ),
                ),
                RotateImageTestData(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1))),
                RotateImageTestData(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                    arrayOf(intArrayOf(3, 1), intArrayOf(4, 2)),
                ),
            )
        tests.forEach { test ->
            val inputMatrix = test.matrix.copyOf()
            inputMatrix.forEach { println(it.toList()) }
            rotateImage.rotateApproachFirst(inputMatrix)
            assertThat(inputMatrix).isEqualTo(test.resultMatrix)
        }
    }

    @Test
    fun rotateApproachSecond() {
        val tests =
            listOf(
                RotateImageTestData(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                    arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3)),
                ),
                RotateImageTestData(
                    arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16),
                    ),
                    arrayOf(
                        intArrayOf(15, 13, 2, 5),
                        intArrayOf(14, 3, 4, 1),
                        intArrayOf(12, 6, 8, 9),
                        intArrayOf(16, 7, 10, 11),
                    ),
                ),
                RotateImageTestData(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1))),
                RotateImageTestData(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
                    arrayOf(intArrayOf(3, 1), intArrayOf(4, 2)),
                ),
            )
        tests.forEach { test ->
            val inputMatrix = test.matrix.copyOf()
            inputMatrix.forEach { println(it.toList()) }
            rotateImage.rotateApproachSecond(inputMatrix)
            assertThat(inputMatrix).isEqualTo(test.resultMatrix)
        }
    }
}
