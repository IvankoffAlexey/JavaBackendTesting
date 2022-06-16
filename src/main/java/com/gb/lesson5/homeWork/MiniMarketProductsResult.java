package com.gb.lesson5.homeWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniMarketProductsResult {
    private Integer id;
    private String title;
    private Integer price;
    private String categoryTitle;
}
