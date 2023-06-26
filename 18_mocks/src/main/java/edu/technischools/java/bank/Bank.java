/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank;

import edu.technischools.java.bank.client.Client;
import edu.technischools.java.bank.client.ClientNotFoundException;
import edu.technischools.java.bank.client.ClientService;
import edu.technischools.java.bank.transaction.InsufficientFundsException;
import edu.technischools.java.bank.transaction.TransferService;

import java.math.BigDecimal;
import java.util.List;

public class Bank {

  private ClientService clientService;

  private TransferService transferService;

  public Bank(ClientService clientService, TransferService transferService) {
    this.clientService = clientService;
    this.transferService = transferService;
  }

  public List<Client> getClients() {
    return this.clientService.findAll();
  }


  public Client addNewClient(String firstName, String lastName, String address) {
    return this.clientService.createClient(firstName, lastName, address);
  }

  public Client setupNewAccount(Client client, String currency) {
    return this.clientService.createNewAccount(client, currency);
  }


  public void transferMoney(Client from, Client to, BigDecimal amount) throws InsufficientFundsException {
    this.transferService.transfer(from.getAccount(), to.getAccount(), amount);
  }

  public void transferMoney(String accountFrom, String accountTo, BigDecimal amount) throws ClientNotFoundException, InsufficientFundsException {
    Client from = this.clientService.findAll().stream().filter(client -> client.getAccount().getNo().equals(accountFrom)).findFirst().orElseThrow(ClientNotFoundException::new);
    Client to = this.clientService.findAll().stream().filter(client -> client.getAccount().getNo().equals(accountTo)).findFirst().orElseThrow(ClientNotFoundException::new);

    this.transferMoney(from, to, amount);
  }

}
