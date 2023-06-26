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

public class ListOfDoubles {

  private List<Double> listofDoubles = new ArrayList<>();

  public Double get(int index) {
    return listofDoubles.get(index);
  }

  public void add(Double d) {
    listofDoubles.add(d);
  }
}
