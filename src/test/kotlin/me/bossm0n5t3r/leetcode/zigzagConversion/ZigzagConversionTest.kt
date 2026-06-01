package me.bossm0n5t3r.leetcode.zigzagConversion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ZigzagConversionTest {
    private val zigzagConversion = ZigzagConversion.Solution()

    private data class ZigzagConversionTestData(val s: String, val numRows: Int, val result: String)

    @Test
    fun convert() {
        val tests =
            listOf(
                ZigzagConversionTestData("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                ZigzagConversionTestData("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                ZigzagConversionTestData("A", 1, "A"),
                ZigzagConversionTestData("AB", 1, "AB"),
            )
        tests.forEach { test ->
            assertEquals(test.result, zigzagConversion.convert(test.s, test.numRows))
            assertEquals(test.result, zigzagConversion.convertAt20250110(test.s, test.numRows))
        }
    }
}
