package me.bossm0n5t3r.leetcode.kthSmallestElementInASortedMatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestElementInASortedMatrixTest {
    private val kthSmallestElementInASortedMatrix = KthSmallestElementInASortedMatrix.Solution()

    data class KthSmallestElementInASortedMatrixTestData(
        val matrix: Array<IntArray>,
        val k: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as KthSmallestElementInASortedMatrixTestData

            if (!matrix.contentDeepEquals(other.matrix)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = matrix.contentDeepHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun kthSmallest() {
        val tests =
            listOf(
                KthSmallestElementInASortedMatrixTestData(
                    arrayOf(intArrayOf(1, 5, 9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15)),
                    8,
                    13,
                ),
                KthSmallestElementInASortedMatrixTestData(arrayOf(intArrayOf(-5)), 1, -5),
            )
        tests.forEach { test ->
            assertEquals(
                test.result,
                kthSmallestElementInASortedMatrix.kthSmallest(test.matrix, test.k),
            )
            assertEquals(
                test.result,
                kthSmallestElementInASortedMatrix.kthSmallestByUsingBiSect(test.matrix, test.k),
            )
        }
    }
}
