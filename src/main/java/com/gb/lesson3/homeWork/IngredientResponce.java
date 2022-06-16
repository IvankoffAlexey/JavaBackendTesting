package com.gb.lesson3.homeWork;


import lombok.Data;

import java.util.List;


public class IngredientResponce {
    @Data
    public class IngredientResponse {

        private List<IngredientsById> ingredients;
    }
}
