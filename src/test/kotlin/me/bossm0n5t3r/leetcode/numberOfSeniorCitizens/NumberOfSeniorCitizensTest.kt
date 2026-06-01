package me.bossm0n5t3r.leetcode.numberOfSeniorCitizens

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSeniorCitizensTest {
    private val sut = NumberOfSeniorCitizens.Solution()

    private data class TestData(val details: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!details.contentEquals(other.details)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = details.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(arrayOf("7868190130M7522", "5303914400F9211", "9273338290F4010"), 2),
                TestData(arrayOf("1313579440F2036", "2921522980M5644"), 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.countSeniors(test.details)) }
    }
}
