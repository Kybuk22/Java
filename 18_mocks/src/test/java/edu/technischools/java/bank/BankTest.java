package edu.technischools.java.bank;

import edu.technischools.java.bank.account.Account;
import edu.technischools.java.bank.account.AccountService;
import edu.technischools.java.bank.account.Account.Currency;
import edu.technischools.java.bank.client.BeforeEach;
import edu.technischools.java.bank.client.Client;
import edu.technischools.java.bank.client.ClientSequence;
import edu.technischools.java.bank.client.ClientService;
import edu.technischools.java.bank.client.ClientsRepository;
import edu.technischools.java.bank.transaction.InsufficientFundsException;
import edu.technischools.java.bank.transaction.TransferService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.technischools.java.bank.Bank;
import java.math.BigDecimal;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

  Bank bank;
  Client client1;
  Client client2;
  Account account1;
  Account account2;

  @Before
  public void setUp() {
    bank = mock(Bank.class);
    client1 = bank.addNewClient("John", "Doe", "123456");
    client2 = bank.addNewClient("Jane", "Doe", "654321");
    account1 = bank.setupNewAccount(client1, "USD").getAccount();
    account2 = bank.setupNewAccount(client2, "EUR").getAccount();
  }

  @Test
  public void testAddNewClient() {
    when(bank.addNewClient("Jon","Jon","Jon")).thenReturn(client1);
    boolean result = bank.addNewClient("Jon","Jon","Jon") != null;
    assertEquals(true, result);
  }

  @Test
  public void testSetupNewAccount() {
    when(bank.setupNewAccount(client1, "USD")).thenReturn(client1);
    Account result = bank.setupNewAccount(client1, "USD").getAccount();
    assertNotNull(result);
    assertEquals(account1, result);
  }

  @Test
  public void testTransferMoney() throws InsufficientFundsException {
    BigDecimal balance1 = new BigDecimal(100);
    BigDecimal balance2 = new BigDecimal(50);
    BigDecimal transferAmount = new BigDecimal(10);
    Currency currency = mock(Currency.class);
    when(account1.getBalance()).thenReturn(balance1);
    when(account2.getBalance()).thenReturn(balance2);
    when(account1.getCurrency()).thenReturn(currency);
    when(account2.getCurrency()).thenReturn(currency);
    bank.transferMoney(client1, client2, transferAmount);
    BigDecimal expectedBalance1 = balance1.subtract(transferAmount);
    BigDecimal expectedBalance2 = balance2.add(transferAmount);
    assertEquals(expectedBalance1, account1.getBalance());
    assertEquals(expectedBalance2, account2.getBalance());
  }

  @Test(expected = InsufficientFundsException.class)
  public void testTransferMoneyWithInsufficientFundsException() throws InsufficientFundsException {
    BigDecimal balance1 = new BigDecimal(100);
    BigDecimal balance2 = new BigDecimal(50);
    BigDecimal transferAmount = new BigDecimal(200);

  }
}

