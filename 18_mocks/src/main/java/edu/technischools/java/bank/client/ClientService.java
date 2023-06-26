/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank.client;

import edu.technischools.java.bank.account.Account;
import edu.technischools.java.bank.account.AccountService;

import java.util.List;

public class ClientService {

  private ClientSequence clientSequence;

  private ClientsRepository clientsRepository;

  private AccountService accountService;

  public ClientService(ClientSequence clientSequence, ClientsRepository clientsRepository, AccountService accountService) {
    this.clientSequence = clientSequence;
    this.clientsRepository = clientsRepository;
    this.accountService = accountService;
  }

  public Client createClient(String firstName, String lastName, String pesel) {
    if (firstName != null && lastName != null && pesel != null) {
      Client client = new Client(clientSequence.next(), firstName, lastName, pesel);

      return clientsRepository.save(client);
    } else {
      throw new IllegalArgumentException("Cannot create client with null data");
    }
  }

  public Client createNewAccount(Client client, String currency) {
    Account account = this.accountService.setupAccount(Account.Currency.valueOf(currency), null);
    client.setAccount(account);

    return client;
  }

  public Client findClientByCid(Integer cid) throws ClientNotFoundException {
    return this.clientsRepository.findById(cid);
  }

  public List<Client> findAll() {
    return this.clientsRepository.findAll();
  }

}
