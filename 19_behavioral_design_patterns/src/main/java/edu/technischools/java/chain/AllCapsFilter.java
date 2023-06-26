/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.chain;

public class AllCapsFilter implements Filter {

  @Override
  public String doFilter(String item, FilterChain chain) {

    String filtered = item.toUpperCase();

    return chain.doFilter(filtered);
  }
}
