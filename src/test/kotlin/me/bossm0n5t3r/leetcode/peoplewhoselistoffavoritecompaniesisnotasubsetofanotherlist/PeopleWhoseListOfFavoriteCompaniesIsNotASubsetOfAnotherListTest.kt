package me.bossm0n5t3r.leetcode.peoplewhoselistoffavoritecompaniesisnotasubsetofanotherlist

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfStringList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherListTest {
    private val sut = PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList.Solution()

    private data class TestData(val favoriteCompanies: List<List<String>>, val result: List<Int>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[\"leetcode\",\"google\",\"facebook\"],[\"google\",\"microsoft\"],[\"google\",\"facebook\"],[\"google\"],[\"amazon\"]]"
                        .toListOfStringList(),
                    listOf(0, 1, 4),
                ),
                TestData(
                    "[[\"leetcode\",\"google\",\"facebook\"],[\"leetcode\",\"amazon\"],[\"facebook\",\"google\"]]"
                        .toListOfStringList(),
                    listOf(0, 1),
                ),
                TestData(
                    "[[\"leetcode\"],[\"google\"],[\"facebook\"],[\"amazon\"]]"
                        .toListOfStringList(),
                    listOf(0, 1, 2, 3),
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.peopleIndexes(testData.favoriteCompanies))
        }
    }
}
