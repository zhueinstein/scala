package com.learn.testing;
/**
 * Created by zcx on 2017/9/30.
 */
public class TypeInference {

    void invoke(Runnable r){
        r.run();
    }

    <T> T invoke(Callable<T> c){
        return c.call();
    }

    public static void main(String[] args) {
        TypeInference typeInference = new TypeInference();
        typeInference.invoke(() -> System.out.println("234"));
    }
}
