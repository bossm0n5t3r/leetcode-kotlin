package me.bossm0n5t3r.leetcode.utils

class MatrixUtil {
    fun generateMatrixFrom(raw: String): Array<IntArray> {
        val trimmedRaw = raw.replace(" ", "")
        val length = trimmedRaw.length
        return trimmedRaw
            .substring(2, length - 2)
            .split("],[")
            .map { it.split(",").map { str -> str.toInt() }.toIntArray() }
            .toTypedArray()
    }
}
