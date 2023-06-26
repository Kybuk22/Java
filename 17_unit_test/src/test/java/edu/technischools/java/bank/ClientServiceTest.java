package edu.technischools.java.bank;

import org.junit.Assert;
import org.junit.Before;
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
public class ClientServiceTest {

  ClientService clientService;

  @Before
  public void setUp() throws Exception {
    clientService = new ClientService(new AccountService());
  }

  @Test
  public void testCreateClientWithValidData() {
    Client client = clientService.createClient("Jan", "Nowak", "123456789");

    Assert.assertTrue(client.getCid() != null);
    Assert.assertNull(client.getAccount());
  }


  @Test
  public void testCreateClientWithNullData() {
    Client client = clientService.createClient("Jan", "Nowak", null);

    Assert.assertNull(client);
  }

  @Test
  public void createNewAccount() {
  }
  @Test(expected = IllegalArgumentException.class)
  public void createClient_withNullParameters_throwsIllegalArgumentException() {
    ClientService clientService = new ClientService(null);
    clientService.createClient(null, null, null);
  }
  @Test
public void createNewAccount_withValidParameters_returnsClientWithAccount() {
    ClientService clientService = new ClientService(new AccountService());
    Client client = clientService.createClient("John", "Doe", "12345678901");
    client = clientService.createNewAccount(client, "PLN");

    assertNotNull(client.getAccount());
    assertEquals(Account.Currency.PLN, client.getAccount().getCurrency());
}

@Test(expected = IllegalArgumentException.class)
public void createNewAccount_withNullClient_throwsIllegalArgumentException() {
    ClientService clientService = new ClientService(new AccountService());
    clientService.createNewAccount(null, "PLN");
}

@Test(expected = IllegalArgumentException.class)
public void createNewAccount_withNullCurrency_throwsIllegalArgumentException() {
    ClientService clientService = new ClientService(new AccountService());
    Client client = clientService.createClient("John", "Doe", "12345678901");
    clientService.createNewAccount(client, null);
}
}
