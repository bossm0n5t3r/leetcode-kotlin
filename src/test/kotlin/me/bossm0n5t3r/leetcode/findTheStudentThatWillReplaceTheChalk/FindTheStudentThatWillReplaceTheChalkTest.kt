package me.bossm0n5t3r.leetcode.findTheStudentThatWillReplaceTheChalk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheStudentThatWillReplaceTheChalkTest {
    private val sut = FindTheStudentThatWillReplaceTheChalk.Solution()

    private data class TestData(val chalk: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!chalk.contentEquals(other.chalk)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = chalk.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(TestData(intArrayOf(5, 1, 5), 22, 0), TestData(intArrayOf(3, 4, 1, 2), 25, 1))

        tests.forEach { test -> assertEquals(test.result, sut.chalkReplacer(test.chalk, test.k)) }
    }
}
