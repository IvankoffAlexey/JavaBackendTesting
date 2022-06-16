package com.gb.lesson5.classWork.clients;

import lombok.Data;

import java.util.List;

@Data
public class YandexPredictorResult {
    private boolean endOfWord;
    private Integer pos;
    private List<String> text;
}
