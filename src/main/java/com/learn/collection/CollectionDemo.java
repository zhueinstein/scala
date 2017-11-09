package com.learn.collection;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zcx on 2017/9/23.
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList(new Person(1, "Tom", "BJ"), new Person(2, "Jim", "SH"),
                                                new Person(4, "Lily", "HZ"), new Person(3, "David", "GZ"),
                                                new Person(5, "Lily", "BJ"), new Person(6, "Lucy", "HZ"));

        List<SimpJava> jj = list.stream().map(p -> new SimpJava(p.getName(), p.getAddress())).collect(Collectors.toList());
        jj.forEach(d -> System.out.println(d.getName()));
        System.out.print(list.stream().collect(Collectors.toMap(Person::getUid, Person -> Person.getAddress(), (key1, key2) -> key2)));
    }
}
