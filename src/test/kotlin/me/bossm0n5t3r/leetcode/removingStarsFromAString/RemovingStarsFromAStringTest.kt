package me.bossm0n5t3r.leetcode.removingStarsFromAString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovingStarsFromAStringTest {
    private val sut = RemovingStarsFromAString.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(s = "leet**cod*e", result = "lecoe"),
                TestData(s = "erase*****", result = ""),
            )

        tests.forEach { test ->
            assertEquals(sut.removeStars(test.s), test.result)
            assertEquals(sut.removeStarsWithoutUsingStack(test.s), test.result)
        }
    }
}
