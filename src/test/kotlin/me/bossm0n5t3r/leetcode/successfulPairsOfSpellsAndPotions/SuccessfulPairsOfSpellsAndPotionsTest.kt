package me.bossm0n5t3r.leetcode.successfulPairsOfSpellsAndPotions

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SuccessfulPairsOfSpellsAndPotionsTest {
    private val sut = SuccessfulPairsOfSpellsAndPotions.Solution()

    private data class TestData(
        val spells: IntArray,
        val potions: IntArray,
        val success: Long,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!spells.contentEquals(other.spells)) return false
            if (!potions.contentEquals(other.potions)) return false
            if (success != other.success) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = spells.contentHashCode()
            result1 = 31 * result1 + potions.contentHashCode()
            result1 = 31 * result1 + success.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    spells = "[5,1,3]".toIntArray(),
                    potions = "[1,2,3,4,5]".toIntArray(),
                    success = 7L,
                    result = "[4,0,3]".toIntArray(),
                ),
                TestData(
                    spells = "[3,1,2]".toIntArray(),
                    potions = "[8,5,8]".toIntArray(),
                    success = 16L,
                    result = "[2,0,2]".toIntArray(),
                ),
            )

        tests.forEach { test ->
            assertThat(sut.successfulPairs(test.spells, test.potions, test.success))
                .isEqualTo(test.result)
        }
    }
}
