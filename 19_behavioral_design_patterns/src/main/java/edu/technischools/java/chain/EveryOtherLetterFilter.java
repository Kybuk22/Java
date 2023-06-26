/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.chain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EveryOtherLetterFilter implements Filter {

  @Override
  public String doFilter(String item, FilterChain chain) {
    String[] letters = item.split("");

    List<String> everyOther = IntStream
        .range(0, letters.length)
        .filter(i -> i % 2 == 0)
        .mapToObj(i -> letters[i])
        .collect(Collectors.toList());

    String filtered = String.join("", everyOther);

    return chain.doFilter(filtered);
  }
}
