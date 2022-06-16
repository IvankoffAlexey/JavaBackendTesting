
package com.gb.lesson4.homeWork.spoonaccular.recipesComplexSearchTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String image;
    private Boolean include;
    private String name;
}