package me.bossm0n5t3r.leetcode.spiralMatrix2

class SpiralMatrix2 {
    class Solution {
        fun generateMatrix(n: Int): Array<IntArray> {
            val result = Array(n) { IntArray(n) { 0 } }
            val element = Element()
            while (element.value <= n * n) {
                result[element.r][element.c] = element.value
                element.next(n, result)
            }
            return result
        }

        private data class Element(
            var value: Int = 1,
            var r: Int = 0,
            var c: Int = 0,
            var direction: Direction = Direction.RIGHT,
        ) {
            enum class Direction {
                LEFT,
                RIGHT,
                DOWN,
                UP,
            }

            fun next(
                n: Int,
                matrix: Array<IntArray>,
            ) {
                this.value++
                when (direction) {
                    Direction.LEFT -> {
                        if (this.c - 1 >= 0 && matrix[this.r][this.c - 1] == 0) {
                            this.c--
                        }
                        if (this.c - 1 == -1 || matrix[this.r][this.c - 1] != 0) {
                            this.direction = Direction.UP
                        }
                    }

                    Direction.RIGHT -> {
                        if (this.c + 1 < n && matrix[this.r][this.c + 1] == 0) {
                            this.c++
                        }
                        if (this.c + 1 == n || matrix[this.r][this.c + 1] != 0) {
                            this.direction = Direction.DOWN
                        }
                    }

                    Direction.DOWN -> {
                        if (this.r + 1 < n && matrix[this.r + 1][this.c] == 0) {
                            this.r++
                        }
                        if (this.r + 1 == n || matrix[this.r + 1][this.c] != 0) {
                            this.direction = Direction.LEFT
                        }
                    }

                    Direction.UP -> {
                        if (this.r - 1 >= 0 && matrix[this.r - 1][this.c] == 0) {
                            this.r--
                        }
                        if (this.r - 1 == -1 || matrix[this.r - 1][this.c] != 0) {
                            this.direction = Direction.RIGHT
                        }
                    }
                }
            }
        }
    }
}
