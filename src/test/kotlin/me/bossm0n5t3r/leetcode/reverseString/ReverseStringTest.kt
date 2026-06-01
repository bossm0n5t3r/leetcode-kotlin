package me.bossm0n5t3r.leetcode.reverseString

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ReverseStringTest {
    private val solution = ReverseString.Solution()

    data class ReverseStringTestData(val s: CharArray, val result: CharArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ReverseStringTestData

            if (!s.contentEquals(other.s)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = s.contentHashCode()
            result = 31 * result + this.result.contentHashCode()
            return result
        }
    }

    @Test
    fun reverseString() {
        val tests =
            listOf(
                ReverseStringTestData("hello".toCharArray(), "olleh".toCharArray()),
                ReverseStringTestData("Hannah".toCharArray(), "hannaH".toCharArray()),
                ReverseStringTestData(
                    "A man, a plan, a canal: Panama".toCharArray(),
                    "amanaP :lanac a ,nalp a ,nam A".toCharArray(),
                ),
            )
        tests.forEach { test ->
            assertTrue(solution.reverseString(test.s).contentEquals(test.result))
        }
    }
}
