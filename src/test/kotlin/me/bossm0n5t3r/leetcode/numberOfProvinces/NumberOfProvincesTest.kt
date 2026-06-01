package me.bossm0n5t3r.leetcode.numberOfProvinces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfProvincesTest {
    private val sut = NumberOfProvinces.Solution()

    private data class TestData(val isConnected: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!isConnected.contentDeepEquals(other.isConnected)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = isConnected.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    isConnected =
                        arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)),
                    result = 2,
                ),
                TestData(
                    isConnected =
                        arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1)),
                    result = 3,
                ),
                TestData(
                    isConnected =
                        arrayOf(
                            intArrayOf(1, 0, 0, 1),
                            intArrayOf(0, 1, 1, 0),
                            intArrayOf(0, 1, 1, 1),
                            intArrayOf(1, 0, 1, 1),
                        ),
                    result = 1,
                ),
            )

        tests.forEach { test -> assertEquals(sut.findCircleNum(test.isConnected), test.result) }
    }
}
