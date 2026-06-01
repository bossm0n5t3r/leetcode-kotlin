package me.bossm0n5t3r.leetcode.sumOfTwoIntegers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SumOfTwoIntegersTest {
    private val sumOfTwoIntegers = SumOfTwoIntegers.Solution()

    data class SumOfTwoIntegersTestData(val a: Int, val b: Int, val result: Int)

    @Test
    fun getSumTest() {
        val tests =
            listOf(
                SumOfTwoIntegersTestData(1, 2, 3),
                SumOfTwoIntegersTestData(2, 3, 5),
                SumOfTwoIntegersTestData(20, 30, 50),
                SumOfTwoIntegersTestData(20, -30, -10),
            )
        tests.forEach { test ->
            assertThat(sumOfTwoIntegers.getSum(test.a, test.b)).isEqualTo(test.result)
        }
    }
}
