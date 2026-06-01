package me.bossm0n5t3r.leetcode.searchSuggestionsSystem

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfStringList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SearchSuggestionsSystemTest {
    private val sut = SearchSuggestionsSystem.Solution()

    private data class TestData(
        val products: Array<String>,
        val searchWord: String,
        val result: List<List<String>>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!products.contentEquals(other.products)) return false
            if (searchWord != other.searchWord) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = products.contentHashCode()
            result1 = 31 * result1 + searchWord.hashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    products = arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
                    searchWord = "mouse",
                    result =
                        """
                        [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
                        """
                            .trimIndent()
                            .toListOfStringList(),
                ),
                TestData(
                    products = arrayOf("havana"),
                    searchWord = "havana",
                    result =
                        """
                        [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
                        """
                            .trimIndent()
                            .toListOfStringList(),
                ),
            )

        tests.forEach { test ->
            assertThat(sut.suggestedProducts(test.products, test.searchWord))
                .containsExactlyElementsOf(test.result)
        }
    }
}
