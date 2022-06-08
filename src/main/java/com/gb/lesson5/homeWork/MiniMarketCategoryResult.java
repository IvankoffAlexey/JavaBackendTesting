package com.gb.lesson5.homeWork;

import lombok.Data;

import java.util.List;

@Data
public class MiniMarketCategoryResult {
    private Integer id;
    private String title;
    private List<MiniMarketProductsResult> products;

}
