package me.bossm0n5t3r.leetcode.dailytemperatures

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DailyTemperaturesTest {
    private val sut = DailyTemperatures.Solution()

    private data class TestData(val temperatures: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!temperatures.contentEquals(other.temperatures)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = temperatures.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    intArrayOf(73, 74, 75, 71, 69, 72, 76, 73),
                    intArrayOf(1, 1, 4, 2, 1, 1, 0, 0),
                ),
                TestData(intArrayOf(30, 40, 50, 60), intArrayOf(1, 1, 1, 0)),
                TestData(intArrayOf(30, 60, 90), intArrayOf(1, 1, 0)),
            )

        tests.forEach { test ->
            assertThat(sut.dailyTemperatures(test.temperatures))
                .containsExactly(test.result.toTypedArray())
        }
    }
}
