/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.template;

public abstract class Printer {

  public String print() {
    
    String printout = "";

    printout += this.printHeader();
    printout += this.printBody();
    printout += this.printFooter();

    return printout;
  }

  protected abstract String printHeader();

  protected abstract String printBody();

  protected abstract String printFooter();
}
