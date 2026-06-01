package me.bossm0n5t3r.leetcode.compareVersionNumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CompareVersionNumbersTest {
    private val sut = CompareVersionNumbers.Solution()

    private data class TestData(val version1: String, val version2: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("1.01", "1.001", 0),
                TestData("1.0", "1.0.0", 0),
                TestData("0.1", "1.1", -1),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.compareVersion(test.version1, test.version2))
        }
    }
}
