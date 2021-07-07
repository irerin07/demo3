package com.example.demo.util;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description point calc util
 **********************************************************************************************************************/

public class PointCalcUtil {

    public static int calcPoint(int amount) {
        double total = amount * 0.01;
        return total < 1.0? 0:(int)Math.round(total);
    }

}