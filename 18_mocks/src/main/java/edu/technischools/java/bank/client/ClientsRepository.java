/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank.client;

import java.util.List;

public interface ClientsRepository {

  Client save(Client client);

  Client delete(Client client);

  Client findById(int id) throws ClientNotFoundException;

  List<Client> findAll();
}
