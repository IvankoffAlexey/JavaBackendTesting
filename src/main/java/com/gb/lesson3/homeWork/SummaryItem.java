
package com.gb.lesson3.homeWork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryItem {
    private Long id;
    private String summary;
    private String title;
}

