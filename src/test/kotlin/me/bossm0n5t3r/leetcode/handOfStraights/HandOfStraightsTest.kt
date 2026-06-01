package me.bossm0n5t3r.leetcode.handOfStraights

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HandOfStraightsTest {
    private val sut = HandOfStraights.Solution()

    private data class TestData(val hand: IntArray, val groupSize: Int, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!hand.contentEquals(other.hand)) return false
            if (groupSize != other.groupSize) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = hand.contentHashCode()
            result1 = 31 * result1 + groupSize
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[1,2,3,6,2,3,4,7,8]".toIntArray(), 3, true),
                TestData("[1,2,3,4,5]".toIntArray(), 4, false),
                TestData("[5,1,0,6,4,5,3,0,8,9]".toIntArray(), 2, false),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.isNStraightHand(test.hand, test.groupSize))
        }
    }
}
