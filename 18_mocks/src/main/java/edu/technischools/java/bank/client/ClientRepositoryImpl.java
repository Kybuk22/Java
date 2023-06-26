/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank.client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientsRepository {

  private List<Client> clients = new ArrayList<>();

  @Override
  public Client save(Client client) {
    clients.add(client);
    return client;
  }

  @Override
  public Client delete(Client client) {
    clients.remove(client);

    return client;
  }

  @Override
  public Client findById(int id) throws ClientNotFoundException {
    return clients.stream().filter(c -> c.getCid() == id).findFirst().orElseThrow(ClientNotFoundException::new);
  }

  @Override
  public List<Client> findAll() {
    return clients;
  }
}
