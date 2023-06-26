package edu.technischools.java.two;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.technischools.java.two.exception.ItemAlreadyManagedByDatabaseException;
import edu.technischools.java.two.exception.ItemDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

  private ClientService clientService;

  @Mock
  private Database database;

  @Before
  public void setUp() {
    this.clientService = new ClientService(database);
  }

  @Test
  public void testCreateClient() throws ItemAlreadyManagedByDatabaseException {
    Client client = new Client();
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(24);

    when(database.create(client)).thenReturn(client);

  }

  @Test
  public void testUpdateClientForExisting() throws ItemDoesNotExistException {
    Client client = new Client();
    client.setId(1);
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(25);

    when(database.update(client)).thenReturn(client);

    Client updatedClient = clientService.updateClient(client);

    assertEquals(client, updatedClient);
    verify(database, times(1)).update(client);
  }

  @Test(expected = ItemDoesNotExistException.class)
  public void testUpdateClientForNonExistingElement() throws ItemDoesNotExistException {
    Client client = new Client();
    client.setId(1);
    client.setFirstName("John");
    client.setLastName("Doe");
    client.setAge(25);

    doThrow(new ItemDoesNotExistException()).when(database).update(client);

    clientService.updateClient(client);

    verify(database, times(1)).update(client);
  }

  @Test
  public void testGetClientByAge() {
    Client client1 = new Client();
    client1.setId(1);
    client1.setFirstName("John");
    client1.setLastName("Doe");
    client1.setAge(25);

    Client client2 = new Client();
    client2.setId(2);
    client2.setFirstName("Jane");
    client2.setLastName("Doe");
    client2.setAge(25);

    List<Client> clients = new ArrayList<>();
    clients.add(client1);
    clients.add(client2);

    when(database.getAll()).thenReturn(clients);

    List<Client> filteredClients = clientService.getClientByAge(25);

    assertEquals(2, filteredClients.size());
    assertEquals(client1, filteredClients.get(0));
    assertEquals(client2, filteredClients.get(1));
    verify(database, times(1)).getAll();
  }
}
