package com.thoughtworks.capability.gtb;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {

  public static LocalDate getNextWorkDate(LocalDate date) {

    int offset;
    String weekday= date.getDayOfWeek().name();//获取周几
    LocalDate newDate;

    HashMap<String,Integer> weekdays = new HashMap<>();

    weekdays.put("MONDAY",1);
    weekdays.put("TUESDAY",2);
    weekdays.put("WEDNESDAY",3);
    weekdays.put("THURSDAY",4);
    weekdays.put("FRIDAY",5);
    weekdays.put("SATURDAY",6);
    weekdays.put("SUNDAY",7);

    int day=weekdays.get(weekday);

    //工作日 1~4 and 7 +1
    //周五+ 3
    //周六 +2
    if(day!=5 && day!=6){
      offset=1;
    }else if(day==6){
      offset=2;
    }else{
      offset=3;
    }

    newDate=date.plusDays(offset);

    return newDate;
  }

  public static void main(String[] args) {

    LocalDate test = LocalDate.of(2020,5,1);

    System.out.println(getNextWorkDate(test));

  }
}
