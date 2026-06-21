package me.bossm0n5t3r.leetcode.creategridwithexactlyonepath

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateGridWithExactlyOnePathTest {
    private val sut = CreateGridWithExactlyOnePath.Solution()

    private data class TestData(val m: Int, val n: Int, val result: Array<String>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (m != other.m) return false
            if (n != other.n) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = m
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(2, 3, "[\"...\",\"##.\"]".toArrayOfString()),
                TestData(3, 3, "[\"...\",\"##.\",\"##.\"]".toArrayOfString()),
                TestData(1, 4, "[\"....\"]".toArrayOfString()),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.createGrid(testData.m, testData.n).toList())
        }
    }
}
