package me.bossm0n5t3r.leetcodegen

import java.io.File

object SolvedProblemListGenerator {
    fun generate() {
        readAllREADMEFiles()
            .map { it.toSolvedProblem() }
            .sortedBy { it.number }
            .toREADME()
            .writeToREADME()
        println("Succeeded SolvedProblemListGenerator.generate()")
    }

    private fun readAllREADMEFiles(): List<File> =
        File("src/main/kotlin/me/bossm0n5t3r/leetcode")
            .walk()
            .filter { it.isFile && it.name.contains("README") }
            .toList()

    private data class SolvedProblem(
        val number: Int,
        val title: String,
        val url: String,
        val fileName: String,
    )

    private fun File.toSolvedProblem(): SolvedProblem {
        val titleLine = readLines().first()
        val number = titleLine.substringAfter("# ").substringBefore(". ").toInt()
        val title = titleLine.substringAfter(". ")
        val urlLine =
            readLines().find { it.contains("https://leetcode.com/problems/") }
                ?: error("Not found URL in $this")
        val url = urlLine.substringAfter("- [").substringBefore("](")
        return SolvedProblem(number, title, url, this.parentFile.name)
    }

    private fun List<SolvedProblem>.toREADME(): String {
        val readme = StringBuilder()
        val maxWidths =
            fold(listOf(0, 0, 0)) { acc, problem ->
                val widths = problem.toWidths()
                acc.zip(widths).map { maxOf(it.first, it.second) }
            }
        readme.append("# LeetCode\n\n")
        readme.append("- LeetCode solutions in `Kotlin`\n\n")
        readme.append("## Solved Problems\n\n")
        readme.append(maxWidths.toTableHeader()).append("\n")
        readme.append(maxWidths.toTableSeparator()).append("\n")
        forEach { readme.append(it.toMarkdownRow(maxWidths)).append("\n") }
        return readme.toString()
    }

    private fun List<Int>.toTableHeader(): String =
        "| ${"#".padEnd(this[0])} | ${"Title".padEnd(this[1])} | ${"Solution".padEnd(this[2])} |"

    private fun List<Int>.toTableSeparator(): String =
        "|-${"-".repeat(this[0])}-|-${"-".repeat(this[1])}-|-${"-".repeat(this[2])}-|"

    private fun SolvedProblem.toWidths(): List<Int> =
        listOf(
            number.toString().length,
            "[$title]($url)".length,
            "[Solution](src/main/kotlin/me/bossm0n5t3r/leetcode/$fileName)".length,
        )

    private fun SolvedProblem.toMarkdownRow(maxWidths: List<Int>): String {
        val index = number.toString().padEnd(maxWidths[0])
        val problemName = "[$title]($url)".padEnd(maxWidths[1])
        val location =
            "[Solution](src/main/kotlin/me/bossm0n5t3r/leetcode/$fileName)".padEnd(maxWidths[2])
        return "| $index | $problemName | $location |"
    }

    private fun String.writeToREADME() {
        File("README.md").writeText(this)
    }
}
