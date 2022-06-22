package com.gb.lesson4.classWork.spoonaccular.test;

import com.gb.lesson4.classWork.spoonaccular.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BaseTest extends AbstractTest {
    @Test
    @Disabled
    void test() throws IOException {
        System.out.println(getResource("/text.txt"));
    }
}
