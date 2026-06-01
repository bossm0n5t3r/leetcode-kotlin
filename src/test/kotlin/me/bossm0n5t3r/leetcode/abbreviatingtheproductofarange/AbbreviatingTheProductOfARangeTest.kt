package me.bossm0n5t3r.leetcode.abbreviatingtheproductofarange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AbbreviatingTheProductOfARangeTest {
    private val sut = AbbreviatingTheProductOfARange.Solution()

    private data class TestData(val left: Int, val right: Int, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(1, 4, "24e0"),
                TestData(2, 11, "399168e2"),
                TestData(371, 375, "7219856259e3"),
                TestData(1, 10000, "28462...79008e2499"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.abbreviateProduct(testData.left, testData.right))
        }
    }
}
