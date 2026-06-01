package me.bossm0n5t3r.leetcode.mostProfitAssigningWork

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostProfitAssigningWorkTest {
    private val sut = MostProfitAssigningWork.Solution()

    private data class TestData(
        val difficulty: IntArray,
        val profit: IntArray,
        val worker: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!difficulty.contentEquals(other.difficulty)) return false
            if (!profit.contentEquals(other.profit)) return false
            if (!worker.contentEquals(other.worker)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = difficulty.contentHashCode()
            result1 = 31 * result1 + profit.contentHashCode()
            result1 = 31 * result1 + worker.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[2,4,6,8,10]".toIntArray(),
                    "[10,20,30,40,50]".toIntArray(),
                    "[4,5,6,7]".toIntArray(),
                    100,
                ),
                TestData(
                    "[85,47,57]".toIntArray(),
                    "[24,66,99]".toIntArray(),
                    "[40,25,25]".toIntArray(),
                    0,
                ),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.maxProfitAssignment(test.difficulty, test.profit, test.worker),
            )
        }
    }
}
