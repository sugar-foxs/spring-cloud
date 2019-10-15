package com.gch.servicefeign.util;

import java.math.BigDecimal;

/**
 * @author guchunhui
 * 2019-10-15 16:01
 **/
public class BigDecimalUtil {

    public static double add(double value1, double value2){
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.add(b2).doubleValue();
    }

    public static double add(String value1, String value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    public static double subtract(double value1, double value2){
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.subtract(b2).doubleValue();
    }

    public static double subtract(String value1, String value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }

    public static double multiply(double value1, double value2){
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.multiply(b2).doubleValue();
    }

    public static double multiply(String value1, String value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }

    public static double divide(double value1, double value2, int scale, int roundingMode){
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.divide(b2, scale, roundingMode).doubleValue();
    }

    public static double divide(String value1, String value2, int scale, int roundingMode){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, scale, roundingMode).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(multiply("1", "2.1"));
        System.out.println(divide("1", "2", 2, BigDecimal.ROUND_HALF_EVEN));

        System.out.println(1.1d * 2.1d);
    }
}
