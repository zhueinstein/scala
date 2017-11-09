package com.learn;

import com.google.common.collect.Lists;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 2017/6/15.
 */
public class HelloWorldJ {
    public static void main(String[] args) throws Exception{
        /*System.out.println("HelloWorld, Java!");
        List<String> list = new ArrayList<>(0);
        int[] s = {123123,312312,32131,321321,31231,2,3123,12312,312312,312312,3213,12312,12312,321,3,12312,3};
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        Calendar c2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        c2.setTime(sdf.parse("2017-08-11"));
        System.out.println(c2.MONTH);*/
    /*    Map<String, Object> map = new HashMap<>();
        String s = null;
        System.out.println(((String) map.get("ssss")).isEmpty());*/
        /*String reg = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(reg);
        System.out.println("".toString());
        MongoOperator mongoOperator = new MongoOperator();

       mongoOperator.drugInfo();*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 01);
        List<String> monthlySaleList = Lists.newArrayList();
        for(int i = 1; i <= 12; i++){
            monthlySaleList.add(sdf.format(new Date(calendar.getTimeInMillis())));
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) -1);
            System.err.println(calendar.get(Calendar.MONTH));
        }

        monthlySaleList.forEach(System.out::println);*/
        //System.out.println(new BigDecimal(38.904).setScale(1, RoundingMode.CEILING).multiply(new BigDecimal(100)));
       // BigDecimal ss = new BigDecimal(25.50 * 0.2 + 18.78 * 9 *0.20).setScale(1, RoundingMode.CEILING);
        //System.out.println(ss);
        List<BigDecimal> b = Lists.newArrayList();
        Optional<BigDecimal> bg = b.stream().reduce((b1, b2) -> b1.add(b2));
        if(bg.isPresent()) System.out.println(bg.get()); else System.out.println(BigDecimal.ZERO);

    }


}
