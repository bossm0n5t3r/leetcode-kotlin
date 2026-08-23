package me.bossm0n5t3r.leetcodegen

import me.bossm0n5t3r.leetcodegen.LeetCodeHelper.toLowerCase

data class LeetCodeProblem(
    val name: String,
    val url: String,
    val sampleCodes: List<String>,
    val methodParametersAndResultAsString: String,
    val exampleTestcases: String,
) {
    val filePath: String
        get() = name.toLowerCase()
}
