/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.template;

public class StarPrinter extends Printer {

  private final String footer;
  private final String header;
  private final String body;

  public StarPrinter(String header, String body, String footer) {
    this.header = header;
    this.body = body;
    this.footer = footer;
  }

  @Override
  protected String printHeader() {
    return "********************\n" + header + "\n********************\n";
  }

  @Override
  protected String printBody() {
    return body+ "\n";
  }

  @Override
  protected String printFooter() {
    return "********************\n" + footer + "\n********************";
  }
}
