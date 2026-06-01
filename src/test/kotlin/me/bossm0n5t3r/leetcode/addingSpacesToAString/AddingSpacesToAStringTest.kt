package me.bossm0n5t3r.leetcode.addingSpacesToAString

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddingSpacesToAStringTest {
    private val sut = AddingSpacesToAString.Solution()

    private data class TestData(val s: String, val spaces: IntArray, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s != other.s) return false
            if (!spaces.contentEquals(other.spaces)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s.hashCode()
            result1 = 31 * result1 + spaces.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "LeetcodeHelpsMeLearn",
                    "[8,13,15]".toIntArray(),
                    "Leetcode Helps Me Learn",
                ),
                TestData("icodeinpython", "[1,5,7,9]".toIntArray(), "i code in py thon"),
                TestData("spacing", "[0,1,2,3,4,5,6]".toIntArray(), " s p a c i n g"),
            )

        tests.forEach { test -> assertEquals(test.result, sut.addSpaces(test.s, test.spaces)) }
    }
}
