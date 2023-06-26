/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank;

public class ClientService {

  private static int CID = 0;

  private AccountService accountService;

  public ClientService(AccountService accountService) {
    this.accountService = accountService;
  }

  public Client createClient(String firstName, String lastName, String pesel) {
    if (firstName == null || lastName == null || pesel == null) {
      throw new IllegalArgumentException("None of the parameters can be null");
    }

    return new Client(CID++, firstName, lastName, pesel);
  }

  public Client createNewAccount(Client client, String currency) {
    Account account = this.accountService.setupAccount(Account.Currency.valueOf(currency), null);
    client.setAccount(account);

    return client;
  }

}
