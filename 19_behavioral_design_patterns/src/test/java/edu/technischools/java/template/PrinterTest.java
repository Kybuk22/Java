package edu.technischools.java.template;

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
public class PrinterTest {


  @Test
  public void testDashPrinter() {
    Printer printer = new DashPrinter("header", "body", "footer");
    String print = printer.print();

    assertEquals("--------------------\n" +
        "header\n" +
        "--------------------\n" +
        "body\n" +
        "--------------------\n" +
        "footer" +
        "\n--------------------", print);
  }
  @Test
  public void testStarPrinter() {
    Printer printer = new StarPrinter("header", "body", "footer");
    String print = printer.print();

    assertEquals("********************\n" +
        "header\n" +
        "********************\n" +
        "body\n" +
        "********************\n" +
        "footer" +
        "\n********************", print);
  }
}
