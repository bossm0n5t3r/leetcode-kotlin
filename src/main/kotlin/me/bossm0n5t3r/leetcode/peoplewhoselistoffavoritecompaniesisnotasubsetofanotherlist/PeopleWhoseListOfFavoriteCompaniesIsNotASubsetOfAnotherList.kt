package me.bossm0n5t3r.leetcode.peoplewhoselistoffavoritecompaniesisnotasubsetofanotherlist

class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    class Solution {
        fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
            val deduplicatedFavoriteCompanies = favoriteCompanies.map { it.toSet() }
            return deduplicatedFavoriteCompanies.mapIndexedNotNull { index, strings ->
                for (i in deduplicatedFavoriteCompanies.indices) {
                    if (i == index) continue
                    if (deduplicatedFavoriteCompanies[i].containsAll(strings))
                        return@mapIndexedNotNull null
                }
                index
            }
        }
    }
}
