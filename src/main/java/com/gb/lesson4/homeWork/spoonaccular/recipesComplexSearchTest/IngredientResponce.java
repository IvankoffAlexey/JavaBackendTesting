package com.gb.lesson4.homeWork.spoonaccular.recipesComplexSearchTest;


import lombok.Data;

import java.util.List;


public class IngredientResponce {
    @Data
    public class IngredientResponse {

        private List<IngredientsById> ingredients;
    }
}
