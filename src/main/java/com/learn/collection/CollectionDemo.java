package com.learn.collection;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zcx on 2017/9/23.
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList(new Person(1, "Tom", "BJ"), new Person(2, "Jim", "SH"),
                                                new Person(4, "Lily", "HZ"), new Person(3, "David", "GZ"),
                                                new Person(5, "Lily", "BJ"), new Person(6, "Lucy", "HZ"));

        System.out.println(list.stream().collect(Collectors.groupingBy(dd -> dd.getAddress())));

    }
}
