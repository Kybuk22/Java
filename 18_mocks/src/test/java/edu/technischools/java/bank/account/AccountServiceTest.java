package edu.technischools.java.bank.account;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mockito;

public class AccountServiceTest {

  @Test
  public void testSetupAccountWithValidData() {
    AccountNumberGenerator accountNumberGenerator = mock(AccountNumberGenerator.class);
    when(accountNumberGenerator.generate()).thenReturn("1234");

    AccountService accountService = new AccountService(accountNumberGenerator);
    Account account = accountService.setupAccount(Account.Currency.PLN, "John Doe");

    assertNotNull(account);
    assertEquals("1234", account.getNo());
    assertEquals("John Doe", account.getName());
    assertEquals(Account.Currency.PLN, account.getCurrency());
    assertEquals(BigDecimal.ZERO, account.getBalance());
    assertEquals(BigDecimal.ZERO, account.getFee());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetupAccountWithInvalidCurrency() {
    AccountNumberGenerator accountNumberGenerator = mock(AccountNumberGenerator.class);

    AccountService accountService = new AccountService(accountNumberGenerator);
    accountService.setupAccount((Account.Currency)null, "John Doe");
  }
}