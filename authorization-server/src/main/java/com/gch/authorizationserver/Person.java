package com.gch.authorizationserver;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guchunhui
 * 2019-10-16 14:37
 **/
@Data
@AllArgsConstructor
public class Person {

    private String name;

    public static void test(String name) {
        test2(name);
    }

    public static void test2(String name) {
        System.out.println(name);
    }

}
