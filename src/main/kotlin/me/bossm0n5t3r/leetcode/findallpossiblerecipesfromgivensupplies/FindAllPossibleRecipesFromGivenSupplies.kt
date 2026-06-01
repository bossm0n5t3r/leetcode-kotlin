package me.bossm0n5t3r.leetcode.findallpossiblerecipesfromgivensupplies

class FindAllPossibleRecipesFromGivenSupplies {
    class Solution {
        fun findAllRecipes(
            recipes: Array<String>,
            ingredients: List<List<String>>,
            supplies: Array<String>,
        ): List<String> {
            val suppliesSet = supplies.toMutableSet()
            val result = mutableListOf<String>()
            val recipeAndIngredientMap: Map<String, List<String>> = recipes.zip(ingredients).toMap()
            for ((recipe, _) in recipeAndIngredientMap) {
                if (canMakeRecipe(recipe, suppliesSet, recipeAndIngredientMap, setOf(recipe))) {
                    result += recipe
                    suppliesSet += recipe
                }
            }
            return result
        }

        private fun canMakeRecipe(
            recipe: String,
            supplies: Set<String>,
            recipeAndIngredientMap: Map<String, List<String>>,
            visited: Set<String>,
        ): Boolean {
            val ingredient = recipeAndIngredientMap[recipe] ?: return false
            var canMake = true
            for (i in ingredient) {
                if (visited.contains(i)) {
                    canMake = false
                    break
                }
                if (
                    !supplies.contains(i) &&
                        !canMakeRecipe(i, supplies, recipeAndIngredientMap, visited + i)
                ) {
                    canMake = false
                    break
                }
            }
            return canMake
        }
    }
}
