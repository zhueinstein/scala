package com.learn.testing;

import java.util.Arrays;

/**
 * Created by zcx on 2017/9/30.
 */
public class Calculator {
    interface IntegerMath{
        int operation(int a, int b);
//        String operationString(String a, String b);
    }

    interface Str {
        String op(String s1, String s2);
    }
    public int operateBinary(int a, int b, IntegerMath op){
        return op.operation(a, b);
    }

    public String operateBinaryStr(String a, String b, Str op){
        return op.op(a, b);
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.operateBinary(14, 13, (a, b) -> a * b));
        System.out.println(calculator.operateBinaryStr("Spark", "Scala", (a, b) -> a));
    }
}
