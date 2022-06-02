package com.gb.lesson3.homeWork;

import lombok.Data;

import java.util.List;

@Data
public class AnalyzeResponse {

    private List<Ingredient> ingredients;
    private List<Dish> dishes;
}