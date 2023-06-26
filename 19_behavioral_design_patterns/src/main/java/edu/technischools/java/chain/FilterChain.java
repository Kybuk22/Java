/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.chain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterChain {

  private List<Filter> filters;


  public FilterChain() {
    filters = new ArrayList<>();
  }

  void addFilter(Filter filter) {
    this.filters.add(filter);
  }

  void addFilters(Filter... filters) {
    this.filters.addAll(Arrays.asList(filters));
  }

  String doFilter(String item) {
    if (this.filters.size() > 0) {
      Filter nextFilter = this.filters.remove(0);

      return nextFilter.doFilter(item, this);
    } else {
      return item;
    }

  }
}
