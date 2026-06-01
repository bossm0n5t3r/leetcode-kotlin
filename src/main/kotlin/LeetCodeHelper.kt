object LeetCodeHelper {
    private val regex = Regex("[^a-zA-Z0-9]")

    fun String.toLowerCase() = this.substringAfter(". ").replace(regex, "").lowercase()

    private fun String.replaceRomanNumeralsAndSpecialCharacters() =
        this.replace("IV", "I V").replace("III", "I I I").replace("II", "I I").replace(regex, " ")

    fun String.toPascalCase(): String {
        return this.substringAfter(". ")
            .replaceRomanNumeralsAndSpecialCharacters()
            .trim()
            .split(" ")
            .joinToString("") { s ->
                if (s.all { it.isUpperCase() }) {
                    return@joinToString s
                }
                s.lowercase().replaceFirstChar { it.uppercase() }
            }
    }

    fun String.makePrettyUrl() = this.substringBefore("submissions").substringBefore("?")
}
