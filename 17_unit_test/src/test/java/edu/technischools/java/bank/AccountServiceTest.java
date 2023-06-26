package edu.technischools.java.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */

/**
 * Klasa testu jest zwykłą klasą Javy
 */
public class AccountServiceTest {

  AccountService accountService;

  @Before // Adnotacja @Before odpalana jest przed testem służy zainicjowaniu wszystkich zależności niezbędnych do testu
  public void setUp() {
    accountService = new AccountService();
  }

  @Test   // każda metoda z adnotacją @Test jest osobnym testem,
  public void testSetupAccountWithCurrencyAndName() {
    Account account = accountService.setupAccount(Account.Currency.PLN, "name");

    Assert.assertNotNull(account.getNo());    // klasa Assert zawiera metody do weryfikacji czy wynik jest zgodny z oczekiwanym, w przypadku gdy nie, test będzie negatywny
    Assert.assertEquals("name", account.getName());
  }

//  @Ignore // jeśli chcemy wyłączyć jakiś test używamy adnotacji @Ignore
  @Test(expected = IllegalArgumentException.class)    // chcąc sprawdzić, czy metoda rzuci wyjątek, dodajemy parametr expected do adnotacji z klasą wtjątku
  public void testSetupAccountWithNullCurrency() {
    Account account = accountService.setupAccount(null, "name");
  }

  @Test
    public void testGetTransactionsFrom() {
        AccountService accountService = new AccountService();

        Account account1 = accountService.setupAccount(Account.Currency.PLN, "John Doe");
        Account account2 = accountService.setupAccount(Account.Currency.USD, "Jane Doe");

        Transaction transaction1 = new Transaction();
        transaction1.setFrom(account1);
        transaction1.setTo(account2);
        account1.getTransactions().add(transaction1);

        Transaction transaction2 = new Transaction();
        transaction2.setFrom(account2);
        transaction2.setTo(account1);
        account2.getTransactions().add(transaction2);

        List<Transaction> transactionsFromAccount1 = accountService.getTransactionsFrom(account1);
        assertEquals(1, transactionsFromAccount1.size());
        assertEquals(transaction1, transactionsFromAccount1.get(0));

        List<Transaction> transactionsFromAccount2 = accountService.getTransactionsFrom(account2);
        assertEquals(1, transactionsFromAccount2.size());
        assertEquals(transaction2, transactionsFromAccount2.get(0));


    }
    @Test(expected = NullPointerException.class)
    public void testGetTransactionsFromNull() {
      Account account1 = accountService.setupAccount(Account.Currency.PLN, "John Doe");
      Account account2 = accountService.setupAccount(Account.Currency.USD, "Jane Doe");

      Transaction transaction1 = new Transaction();
      transaction1.setFrom(account1);
      transaction1.setTo(account2);
      account1.getTransactions().add(transaction1);

      List<Transaction> transactionsFromAccount11 = accountService.getTransactionsFrom(null);
      assertEquals(1, transactionsFromAccount11.size());
      assertEquals(transaction1, transactionsFromAccount11.get(0));



    }
    private TransferService transferService = TransferService.getInstance();
    private Account account = new AccountService().setupAccount(Account.Currency.PLN, "Test Account");
  
    @Test
    public void testDeposit() {
      BigDecimal depositAmount = new BigDecimal(100);
      transferService.deposit(account, depositAmount);
      assertEquals(depositAmount, account.getBalance());
    }
  
    @Test
    public void testWithdrawn() throws InsufficientFundsException {
      BigDecimal depositAmount = new BigDecimal(100);
      transferService.deposit(account, depositAmount);
      BigDecimal withdrawnAmount = new BigDecimal(50);
      transferService.withdrawn(account, withdrawnAmount);
      assertEquals(depositAmount.subtract(withdrawnAmount), account.getBalance());
    }
}
