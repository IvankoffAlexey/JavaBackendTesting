package com.gb.lesson3.classWork;

import lombok.Data;

import java.util.List;

public class EquipmentResponce {

    @Data
    public class EquipmentResponse {

        private List<EquipmentItem> equipment;
    }
}
