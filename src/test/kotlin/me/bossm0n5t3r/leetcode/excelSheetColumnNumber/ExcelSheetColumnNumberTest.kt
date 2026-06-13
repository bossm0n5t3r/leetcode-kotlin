package me.bossm0n5t3r.leetcode.excelSheetColumnNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExcelSheetColumnNumberTest {
    private val excelSheetColumnNumber = ExcelSheetColumnNumber.Solution()

    data class ExcelSheetColumnNumberTestData(val columnTitle: String, val result: Int)

    @Test
    fun titleToNumber() {
        val tests =
            listOf(
                ExcelSheetColumnNumberTestData("A", 1),
                ExcelSheetColumnNumberTestData("AB", 28),
                ExcelSheetColumnNumberTestData("ZY", 701),
                ExcelSheetColumnNumberTestData("FXSHRXW", 2147483647),
            )
        tests.forEach { test ->
            assertEquals(test.result, excelSheetColumnNumber.titleToNumber(test.columnTitle))
        }
    }
}
