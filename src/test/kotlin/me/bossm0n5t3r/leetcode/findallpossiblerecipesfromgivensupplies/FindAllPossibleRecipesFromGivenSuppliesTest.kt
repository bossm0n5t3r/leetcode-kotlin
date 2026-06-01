package me.bossm0n5t3r.leetcode.findallpossiblerecipesfromgivensupplies

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfStringList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FindAllPossibleRecipesFromGivenSuppliesTest {
    private val sut = FindAllPossibleRecipesFromGivenSupplies.Solution()

    private data class TestData(
        val recipes: Array<String>,
        val ingredients: List<List<String>>,
        val supplies: Array<String>,
        val result: List<String>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!recipes.contentEquals(other.recipes)) return false
            if (ingredients != other.ingredients) return false
            if (!supplies.contentEquals(other.supplies)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = recipes.contentHashCode()
            result1 = 31 * result1 + ingredients.hashCode()
            result1 = 31 * result1 + supplies.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[\"bread\"]".toArrayOfString(),
                    "[[\"yeast\",\"flour\"]]".toListOfStringList(),
                    "[\"yeast\",\"flour\",\"corn\"]".toArrayOfString(),
                    listOf("bread"),
                ),
                TestData(
                    "[\"bread\",\"sandwich\"]".toArrayOfString(),
                    "[[\"yeast\",\"flour\"],[\"bread\",\"meat\"]]".toListOfStringList(),
                    "[\"yeast\",\"flour\",\"meat\"]".toArrayOfString(),
                    listOf("bread", "sandwich"),
                ),
                TestData(
                    "[\"bread\",\"sandwich\",\"burger\"]".toArrayOfString(),
                    "[[\"yeast\",\"flour\"],[\"bread\",\"meat\"],[\"sandwich\",\"meat\",\"bread\"]]"
                        .toListOfStringList(),
                    "[\"yeast\",\"flour\",\"meat\"]".toArrayOfString(),
                    listOf("bread", "sandwich", "burger"),
                ),
                TestData(
                    "[\"ju\",\"fzjnm\",\"x\",\"e\",\"zpmcz\",\"h\",\"q\"]".toArrayOfString(),
                    "[[\"d\"],[\"hveml\",\"f\",\"cpivl\"],[\"cpivl\",\"zpmcz\",\"h\",\"e\",\"fzjnm\",\"ju\"],[\"cpivl\",\"hveml\",\"zpmcz\",\"ju\",\"h\"],[\"h\",\"fzjnm\",\"e\",\"q\",\"x\"],[\"d\",\"hveml\",\"cpivl\",\"q\",\"zpmcz\",\"ju\",\"e\",\"x\"],[\"f\",\"hveml\",\"cpivl\"]]"
                        .toListOfStringList(),
                    "[\"f\",\"hveml\",\"cpivl\",\"d\"]".toArrayOfString(),
                    listOf("ju", "fzjnm", "q"),
                ),
            )

        for (testData in testDataList) {
            assertThat(
                    sut.findAllRecipes(testData.recipes, testData.ingredients, testData.supplies)
                )
                .containsExactlyElementsOf(testData.result)
        }
    }
}
