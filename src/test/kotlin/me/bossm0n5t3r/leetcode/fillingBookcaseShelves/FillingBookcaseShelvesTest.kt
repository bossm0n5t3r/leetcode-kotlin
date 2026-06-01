package me.bossm0n5t3r.leetcode.fillingBookcaseShelves

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FillingBookcaseShelvesTest {
    private val sut = FillingBookcaseShelves.Solution()

    private data class TestData(val books: Array<IntArray>, val shelfWidth: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!books.contentDeepEquals(other.books)) return false
            if (shelfWidth != other.shelfWidth) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = books.contentDeepHashCode()
            result1 = 31 * result1 + shelfWidth
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]".toArrayOfIntArray(), 4, 6),
                TestData("[[1,3],[2,4],[3,2]]".toArrayOfIntArray(), 6, 4),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.minHeightShelves(test.books, test.shelfWidth))
        }
    }
}
