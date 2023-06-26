/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bad;

import java.math.BigDecimal;

public class Utils {

  public static boolean isNegative(int x) {
    try {
      if (x < 0) {
        throw new IllegalArgumentException("Error: Non-negative integer used");
      }
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
      return true;
    }
  }


  public static BigDecimal parse(String s) {
    try {
      return new BigDecimal(s);
    } catch (NumberFormatException nfe) {
      return null;
    }
  }

  public static String dayName(int day) {
    if (day==1){
      return "Monday";
    }
    else if(day==2){
      return "Tuesday";
    }
    else if(day==3){
      return "Wednsday";
    }
    else if(day==4){
      return "Thursday";
    }
    else if(day==5){
      return "Friday";
    }
    else if(day==6){
      return "Thursday";
    }
    else if(day==7){
      return "Sunady";
    }
    else{
      return "unknown day";
    }

  }   
}
