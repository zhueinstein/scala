package com.learn.testing;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by zcx on 2017/9/29.
 */
public class Demo {
    public static void main(String[] args) {
        List<Book> bookStore = Lists.newArrayList(new Book("110011001", "西游记", "吴承恩", 17L,"Java娱乐有道出版社"),
                                                  new Book("110011002", "水浒传", "施耐庵",11L,"Java娱乐有道出版社"),
                                                  new Book("110011005", "水浒传", "施耐庵",112L,"Java娱乐有道出版社"),
                                                  new Book("110011003", "三国演义", "罗贯中", 14L,"Java娱乐有道出版社"),
                                                  new Book("110011004", "红楼梦", "曹雪芹", 11L,"Java娱乐有道出版社"));
       /* List<Book> testStore = Lists.newArrayList();
        for (int i = 1; i < 100; i ++){
            testStore.add(new Book(i + "", "西游记" + new Random(10), "吴承恩" + i, 11L,"Java娱乐有道出版社"));
        }
        Long start1 = System.currentTimeMillis();
        testStore.stream().mapToLong(Book::getPrice).sum();
        testStore.stream().collect(Collectors.groupingBy(Book::getBookName)).entrySet().stream()
                .filter(ds -> ds.getKey().contains("西游记")).findAny().get().getValue()
                .stream().mapToLong(Book::getPrice).sum();
        Long end1 = System.currentTimeMillis();*/
       /* Long start2 = System.currentTimeMillis();
        testStore.stream().parallel().collect(Collectors.groupingBy(Book::getBookName)).entrySet().stream().parallel().forEach(ds -> System.out.println(ds.getKey()));
        Long end2 = System.currentTimeMillis();*/
//        System.out.println("🚢行" + (end1 - start1) /*+ "    并行"+ (end2 -start2)*/ );

        /*bookStore.stream().forEach(ds -> {
            System.out.print (ds.getAuthor() + "  ");
            System.out.println(ds.getBookName());
        });

        List<Map<String, Object>> nl = bookStore.stream().map(ds -> {

                Map<String, Object> mp  = Maps.newHashMap();
                mp.put("bookName", ds.getBookName());
                mp.put("price", ds.getPrice());
                ds.setPrice(new BigDecimal(100));
                return mp;

        }).collect(Collectors.toList());
        nl.forEach(ds -> System.out.println(ds));*/
       /* Demo demo = new Demo();
        Set<Book> rosterSetLambda = Demo.transferElements(bookStore, HashSet::new);
        List<String> strings = Lists.newArrayList("Spark", "Scala", "hadoop", "Yarn");
        bookStore.stream().collect(ArrayList::new,
                    (objects, book) -> objects.add(book), ArrayList::addAll);*/
   /* Map<String, Long> ll = bookStore.stream().collect(Collectors.groupingBy(Book::getBookName, Collectors.summingLong(Book::getPrice)));
        List<Map.Entry<String, Long>> dsd = ll.entrySet().stream().collect(Collectors.toList());
        dsd.sort(Comparator.comparing(ds -> ds.getValue()));
        dsd.stream().skip(dsd.size() - 2);
        System.out.println(dsd.stream().skip(dsd.size() - 2).collect(Collectors.toList()));
*/
//        System.out.println(ll);
		Map<String, String> ts = Maps.newHashMap();
	    bookStore.stream().forEach(ds -> ts.put(ds.getAuthor(), ds.getBookName()));
	   ts.forEach((key,value) -> System.out.println(key + " : " + value));
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }
}
