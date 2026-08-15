package me.bossm0n5t3r.leetcode.peoplewhoselistoffavoritecompaniesisnotasubsetofanotherlist

class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    class Solution {
        fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
            val sets = favoriteCompanies.map { it.toSet() }
            return sets.indices.filter { index ->
                sets.indices.none { otherIndex ->
                    otherIndex != index &&
                        sets[otherIndex].size >= sets[index].size &&
                        sets[otherIndex].containsAll(sets[index])
                }
            }
        }
    }
}
