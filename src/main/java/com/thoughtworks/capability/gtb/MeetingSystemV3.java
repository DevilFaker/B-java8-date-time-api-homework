package com.thoughtworks.capability.gtb;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static java.time.ZoneId.getAvailableZoneIds;

/**
 * 脑洞会议系统v3.0
 * 1.当前会议时间"2020-04-01 14:30:00"表示伦敦的本地时间，而输出的新会议时间是芝加哥的本地时间
 * 2.用Period来实现下个会议时间的计算
 *
 * @author itutry
 * @create 2020-05-19_18:43
 */
public class MeetingSystemV3 {

  public static void main(String[] args) {
    String timeStr = "2020-04-01 14:30:00";

    // 根据格式创建格式化类
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // 从字符串解析得到会议时间
    LocalDateTime meetingTime = LocalDateTime.parse(timeStr, formatter);

    LocalDateTime now = LocalDateTime.now();

    if (now.isAfter(meetingTime)) {

      Period period=Period.of(0,0,1);

      LocalDateTime tomorrow = now.plus(period);

      int newDayOfYear = tomorrow.getDayOfYear();

      meetingTime = meetingTime.withDayOfYear(newDayOfYear);

      ZonedDateTime zonedDateTime=meetingTime.atZone(ZoneId.of("Europe/London"));

      ZonedDateTime newZonedDateTime=zonedDateTime.withZoneSameInstant(ZoneId.of("America/Chicago"));



      // 格式化新会议时间
      String showTimeStr = formatter.format(newZonedDateTime);


      System.out.println(showTimeStr);
    } else {
      System.out.println("会议还没开始呢");
    }
  }
}
