package me.bossm0n5t3r.leetcode.validSudoku

class ValidSudoku {
    class Solution {
        fun isValidSudokuFirstApproach(board: Array<CharArray>): Boolean {
            val convertedBoard = convertToListListInt(board)
            if (!checkSquare(convertedBoard)) return false
            if (!checkHorizontal(convertedBoard)) return false
            if (!checkVertical(convertedBoard)) return false
            return true
        }

        private fun convertToListListInt(board: Array<CharArray>): List<List<Int>> =
            board.map { row ->
                row.map { e ->
                    when (e) {
                        '.' -> {
                            0
                        }

                        else -> {
                            e - '0'
                        }
                    }
                }
            }

        private fun checkSquare(board: List<List<Int>>): Boolean {
            splitIntoSmallSquareList(board)
                .forEach { smallSquare ->
                    val filteredSmallSquare = smallSquare.filter { it != 0 }
                    if (filteredSmallSquare.size != filteredSmallSquare.toSet().size) return false
                }
            return true
        }

        private fun splitIntoSmallSquareList(board: List<List<Int>>): List<List<Int>> {
            val targetIdx = listOf(0, 3, 6)
            val result =
                listOf<MutableList<Int>>(
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                )
            var resultIdx = 0
            targetIdx.forEach { col ->
                targetIdx.forEach { row ->
                    board
                        .subList(col, col + 3)
                        .forEach { targetRow ->
                            result[resultIdx].addAll(targetRow.subList(row, row + 3))
                        }
                    resultIdx++
                }
            }
            return result
        }

        private fun checkHorizontal(board: List<List<Int>>): Boolean {
            board.forEach { row ->
                val filteredRowList = row.filter { it != 0 }
                if (filteredRowList.size != filteredRowList.toSet().size) return false
            }
            return true
        }

        private fun checkVertical(board: List<List<Int>>): Boolean = checkHorizontal(transpose(board))

        private fun transpose(board: List<List<Int>>): List<List<Int>> {
            val result =
                listOf<MutableList<Int>>(
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                    mutableListOf(),
                )
            board.forEach { row ->
                row.forEachIndexed { cIdx, e ->
                    result[cIdx].add(e)
                }
            }
            return result
        }

        fun isValidSudokuSecondApproach(board: Array<CharArray>): Boolean {
            val seen = mutableSetOf<String>()
            val sudokuIndex = 0 until 9
            sudokuIndex.forEach { r ->
                sudokuIndex.forEach { c ->
                    if (board[r][c] != '.') {
                        val element = "(${board[r][c]})"
                        if (!seen.add("$r$element") || !seen.add("$element$c") || !seen.add("${r / 3}$element${c / 3}")) {
                            return false
                        }
                    }
                }
            }
            return true
        }
    }
}
