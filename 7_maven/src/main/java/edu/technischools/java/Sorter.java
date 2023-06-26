/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java;

import com.google.common.collect.Lists;

import java.util.List;

public class Sorter<T extends Number> {

  public Sorter() {
  }

  List<T> sort(List<T> list) {
    list.sort((o1, o2) -> ((Comparable) o1).compareTo(o2));
    return list;
  }

  List<T> reverse(List<T> list) {
    return Lists.reverse(list);
  }
}
