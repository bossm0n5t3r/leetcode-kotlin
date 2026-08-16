package me.bossm0n5t3r.leetcode.validsudoku

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidSudokuTest {
    private val validSudoku = ValidSudoku.Solution()

    data class ValidSudokuTestData(val board: Array<CharArray>, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ValidSudokuTestData

            if (!board.contentDeepEquals(other.board)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = board.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun isValidSudokuTest() {
        val tests =
            listOf(
                ValidSudokuTestData(
                    getSudoku(
                        """
                        [["5","3",".",".","7",".",".",".","."]
                        ,["6",".",".","1","9","5",".",".","."]
                        ,[".","9","8",".",".",".",".","6","."]
                        ,["8",".",".",".","6",".",".",".","3"]
                        ,["4",".",".","8",".","3",".",".","1"]
                        ,["7",".",".",".","2",".",".",".","6"]
                        ,[".","6",".",".",".",".","2","8","."]
                        ,[".",".",".","4","1","9",".",".","5"]
                        ,[".",".",".",".","8",".",".","7","9"]]
                        """
                            .trimIndent()
                    ),
                    true,
                ),
                ValidSudokuTestData(
                    getSudoku(
                        """
                        [["8","3",".",".","7",".",".",".","."]
                        ,["6",".",".","1","9","5",".",".","."]
                        ,[".","9","8",".",".",".",".","6","."]
                        ,["8",".",".",".","6",".",".",".","3"]
                        ,["4",".",".","8",".","3",".",".","1"]
                        ,["7",".",".",".","2",".",".",".","6"]
                        ,[".","6",".",".",".",".","2","8","."]
                        ,[".",".",".","4","1","9",".",".","5"]
                        ,[".",".",".",".","8",".",".","7","9"]]
                        """
                            .trimIndent()
                    ),
                    false,
                ),
                ValidSudokuTestData(
                    getSudoku(
                        """
                        [[".",".",".",".","5",".",".","1","."]
                        ,[".","4",".","3",".",".",".",".","."]
                        ,[".",".",".",".",".","3",".",".","1"]
                        ,["8",".",".",".",".",".",".","2","."]
                        ,[".",".","2",".","7",".",".",".","."]
                        ,[".","1","5",".",".",".",".",".","."]
                        ,[".",".",".",".",".","2",".",".","."]
                        ,[".","2",".","9",".",".",".",".","."]
                        ,[".",".","4",".",".",".",".",".","."]]
                        """
                            .trimIndent()
                    ),
                    false,
                ),
            )
        tests.forEach { test ->
            assertThat(validSudoku.isValidSudokuFirstApproach(test.board)).isEqualTo(test.result)
            assertThat(validSudoku.isValidSudokuSecondApproach(test.board)).isEqualTo(test.result)
        }
    }

    private fun getSudoku(rawData: String): Array<CharArray> =
        rawData
            .lines()
            .map { row ->
                row.replace("]]", "]")
                    .substring(3, row.length - 2)
                    .split("\",\"")
                    .map { it[0] }
                    .toCharArray()
            }
            .toTypedArray()
}
