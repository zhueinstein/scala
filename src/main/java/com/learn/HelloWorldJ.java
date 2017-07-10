package com.learn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/6/15.
 */
public class HelloWorldJ {
    public static void main(String[] args) throws Exception{
        System.out.println("HelloWorld, Java!");
        List<String> list = new ArrayList<>(0);
        int[] s = {123123,312312,32131,321321,31231,2,3123,12312,312312,312312,3213,12312,12312,321,3,12312,3};
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
        Calendar c2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        c2.setTime(sdf.parse("2017-08-11"));
        System.out.println(c2.MONTH);
    }
}
