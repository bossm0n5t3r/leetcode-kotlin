package me.bossm0n5t3r.leetcode.xofakindinadeckofcards

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class XOfAKindInADeckOfCardsTest {
    private val sut = XOfAKindInADeckOfCards.Solution()

    private data class TestData(val deck: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!deck.contentEquals(other.deck)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = deck.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), true),
                TestData(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.hasGroupsSizeX(testData.deck))
        }
    }
}
