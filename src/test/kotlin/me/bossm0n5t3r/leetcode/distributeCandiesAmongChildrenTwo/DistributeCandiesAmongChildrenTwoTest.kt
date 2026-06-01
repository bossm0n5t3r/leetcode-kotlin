package me.bossm0n5t3r.leetcode.distributeCandiesAmongChildrenTwo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeCandiesAmongChildrenTwoTest {
    private val sut = DistributeCandiesAmongChildrenTwo.Solution()

    private data class TestData(val n: Int, val limit: Int, val result: Long)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(5, 2, 3),
                TestData(3, 3, 10),
                TestData(10001, 20001, 50025003),
                TestData(10006, 20008, 50075028),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.distributeCandies(test.n, test.limit))
        }
    }
}
