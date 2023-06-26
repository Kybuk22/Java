/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.one;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringUtils {


  /**
   * Checks if a string contains letters only
   *
   * @param s string to check
   * @return true or false
   */
  public boolean hasLettersOnly(String s) {
    return s.matches("[a-zA-Z]*+");

  }

  /**
   * Capitalizes a string
   *
   * @param s string to capitalize
   * @return capitalized string
   */
  public String capitalize(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }

  /**
   * Formats a string into a cameCase
   *
   * @param s string to format
   * @return a string in camelCase
   */
  public String camelCase(String s) {
    return Arrays.stream(s.split(" ")).reduce("", (result, str) -> result + new StringUtils().capitalize(str.trim()));
  }

  /**
   * Converts a strong to a number
   *
   * @param s a string to parse
   * @return a double number
   * @throws IllegalArgumentException when a string is not a number
   */
  public Double convertToNumber(String s) {
    try {
      return new BigDecimal(s).doubleValue();
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("String is not a number");
    }
  }

}
