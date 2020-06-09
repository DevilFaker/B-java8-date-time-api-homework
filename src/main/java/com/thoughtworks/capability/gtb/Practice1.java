package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {

  public static long getDaysBetweenNextLaborDay(LocalDate date) {

    int year = date.getYear();

    LocalDate laborDate = LocalDate.of(year,5,1);

    Period period;

    //判断当年劳动节在前后
    //在前： 劳动节 - now
    //在后：下一年 - now
    if (laborDate.isBefore(date)){
     laborDate=laborDate.withYear(year+1);
    }else if (laborDate.isEqual(date)){
      return Long.valueOf(0);
    }

    period=date.until(laborDate);

    long days=ChronoUnit.DAYS.between(date,laborDate);

    return days;


  }

  public static long getDaysBetweenNextLaborDayMethod2(LocalDate date) {


    LocalDate laborDate = date.withMonth(5).withDayOfMonth(1);

    //判断当年劳动节在前后
    //在前： 劳动节 - now
    //在后：下一年 - now
    if (laborDate.isBefore(date)){
      laborDate=laborDate.withYear(laborDate.getYear()+1);
    }else if (laborDate.isEqual(date)){
      return Long.valueOf(0);
    }


    long days=ChronoUnit.DAYS.between(date,laborDate);

    return days;

  }

  public static void main(String[] args) {

    LocalDate test = LocalDate.of(2020,4,29);

    System.out.println(getDaysBetweenNextLaborDay(test));

    System.out.println(getDaysBetweenNextLaborDayMethod2(test));

  }


}
