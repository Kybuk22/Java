package edu.technischools.java.chain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
public class FilterChainTest {


  FilterChain filterChain;

  @Before
  public void setUp() throws Exception {
    filterChain = new FilterChain();

    filterChain.addFilter(new AllCapsFilter());
  }

  @Test
  public void testOneElementFilter() {
    Assert.assertEquals("ABC", filterChain.doFilter("abc"));
  }

  @Test
  public void testTwoElementsFilter() {
    filterChain.addFilters(new EveryOtherLetterFilter());

    Assert.assertEquals("AC", filterChain.doFilter("abcd"));
  }
}
