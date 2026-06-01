package me.bossm0n5t3r.leetcode.sortThePeople

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SortThePeopleTest {
    private val sut = SortThePeople.Solution()

    private data class TestData(
        val names: Array<String>,
        val heights: IntArray,
        val result: Array<String>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!names.contentEquals(other.names)) return false
            if (!heights.contentEquals(other.heights)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = names.contentHashCode()
            result1 = 31 * result1 + heights.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[\"Mary\",\"John\",\"Emma\"]".toArrayOfString(),
                    "[180,165,170]".toIntArray(),
                    "[\"Mary\",\"Emma\",\"John\"]".toArrayOfString(),
                ),
                TestData(
                    "[\"Alice\",\"Bob\",\"Bob\"]".toArrayOfString(),
                    "[155,185,150]".toIntArray(),
                    "[\"Bob\",\"Alice\",\"Bob\"]".toArrayOfString(),
                ),
            )

        tests.forEach { test ->
            assertTrue { sut.sortPeople(test.names, test.heights).contentDeepEquals(test.result) }
        }
    }
}
