/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java;

import java.util.ArrayList;
import java.util.List;

public class ListOfInts {

  private List<Integer> listofInts = new ArrayList<>();

  public Integer get(int index) {
    return listofInts.get(index);
  }

  public void add(Integer i) {
    listofInts.add(i);
  }
}
