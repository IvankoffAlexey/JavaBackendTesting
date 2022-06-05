package com.gb.lesson4.homeWork.spoonaccular.recipesComplexSearchTest;

import lombok.Data;

import java.util.List;

@Data
public class AnalyzeResponse {

    private List<Ingredient> ingredients;
    private List<Dish> dishes;
}