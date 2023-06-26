/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bad;

import java.math.BigDecimal;
import java.util.Scanner;

public class BadPractise {

  public static void main(String[] args) {
    ConvertCelsiusToFahrenheit convert_to = new ConvertCelsiusToFahrenheit();

    System.out.println(convert_to.convert(1));

    CustomersRepository cr = new CustomersRepository();

    Account a1 = new Account("123");
    Account a2 = new Account("321");

    a1.setBalance(BigDecimal.TEN);

    MoneyTransferService moneyTransferService = new MoneyTransferService();

    try {
      int i = moneyTransferService.transferMoney(a1, a2, new BigDecimal(2));
      if (i < 0) {
        System.out.println("Not enough money to transfer");
      }

    }catch (Exception ignore) { }
    
   


    // Wczytaj 2 liczby x i y, oraz obicz x^3 i y^5
    int ans1 = 1;
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the value of x: ");
    int x = scanner.nextInt();
    System.out.print("Enter the value of y: ");
    int y = scanner.nextInt();


    System.out.println("x raised to the power 3 = " + Math. pow(x,3) );

    // Calculating y raised to 5


    System.out.println("y raised to the power 5 = " + Math. pow(y,5) );
  }
}
