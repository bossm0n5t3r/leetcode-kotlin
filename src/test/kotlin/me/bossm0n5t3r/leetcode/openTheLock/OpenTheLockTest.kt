package me.bossm0n5t3r.leetcode.openTheLock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OpenTheLockTest {
    private val sut = OpenTheLock.Solution()

    private data class TestData(val deadends: Array<String>, val target: String, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!deadends.contentEquals(other.deadends)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = deadends.contentHashCode()
            result1 = 31 * result1 + target.hashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202", 6),
                TestData(arrayOf("8888"), "0009", 1),
                TestData(
                    arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"),
                    "8888",
                    -1,
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.openLock(test.deadends, test.target))
        }
    }
}
