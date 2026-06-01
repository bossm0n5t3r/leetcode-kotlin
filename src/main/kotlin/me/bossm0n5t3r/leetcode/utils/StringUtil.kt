package me.bossm0n5t3r.leetcode.utils

object StringUtil {
    fun String.toArrayOfIntArray(): Array<IntArray> =
        runCatching {
                this.drop(2)
                    .dropLast(2)
                    .takeIf { it.isNotBlank() }
                    ?.split("],[")
                    ?.map {
                        if (it.isBlank()) {
                            return@map intArrayOf()
                        }
                        it.split(",").map { c -> c.toInt() }.toIntArray()
                    }
                    ?.toTypedArray() ?: emptyArray()
            }
            .getOrElse { emptyArray() }

    fun String.toIntArray(): IntArray =
        this.takeIf { it.isNotBlank() }
            ?.drop(1)
            ?.dropLast(1)
            ?.takeIf { it.isNotBlank() }
            ?.split(",")
            ?.map { it.toInt() }
            ?.toIntArray() ?: IntArray(0)

    fun String.toArrayOfCharArray(): Array<CharArray> =
        this.drop(2)
            .dropLast(2)
            .split("],[")
            .map { it.replace("\"", "").split(",").map { c -> c.first() }.toCharArray() }
            .toTypedArray()

    fun String.toArrayOfString(): Array<String> =
        this.drop(1).dropLast(1).replace("\"", "").split(",").toTypedArray()

    fun String.toListOfStringList(): List<List<String>> =
        this.drop(2).dropLast(2).split("],[").map { it.replace("\"", "").split(",") }

    fun String.toListOfIntList(): List<List<Int>> {
        if (this == "[]") return emptyList()
        return this.drop(2).dropLast(2).split("],[").map {
            val stringList = it.replace("\"", "").split(",")

            if (stringList.isEmpty() || stringList.all { s: String -> s.isBlank() }) {
                return@map emptyList()
            }
            stringList.map { string -> string.toInt() }
        }
    }
}
