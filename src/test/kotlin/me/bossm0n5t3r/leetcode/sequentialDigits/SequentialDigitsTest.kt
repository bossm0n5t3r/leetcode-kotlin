package me.bossm0n5t3r.leetcode.sequentialDigits

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SequentialDigitsTest {
    private val sut = SequentialDigits.Solution()

    private data class TestData(val low: Int, val high: Int, val result: List<Int>)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(100, 300, listOf(123, 234)),
                TestData(1000, 13000, listOf(1234, 2345, 3456, 4567, 5678, 6789, 12345)),
                TestData(58, 155, listOf(67, 78, 89, 123)),
                TestData(8511, 23553, listOf(12345, 23456)),
            )

        tests.forEach { test ->
            assertThat(sut.sequentialDigits(test.low, test.high))
                .containsExactlyElementsOf(test.result)
        }
    }
}
