package edu.technischools.java.bank.client;

import edu.technischools.java.bank.account.Account;
import edu.technischools.java.bank.account.AccountService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Testy, które używają mocków z biblioteki Mockito, muszą być uruchamiane specjalną klasą,
 * która pozwala używać adnotacji z biblioteki Mockito
 */
@RunWith(MockitoJUnitRunner.class) // klasa 'Runnera'
public class ClientServiceTest {

  /**
   * adnotacja @Mock tworzy automatycznie daną klasę która, będzie mockiem-
   * czyli można weryfikować, jakie metody zostały na niej wywołana i z jakimi parametrami,
   * a także ustawić, jakie dane zostaną zwrócone, gdy dana metoda zostanie wywołana
   */
  @Mock // adnotacja Mock może być na interfejsach...
      ClientsRepository clientsRepository;

  @Mock // ... i na klasach
  ClientSequence clientSequence;

  @Mock
  Client mockClient;

  @Mock
  AccountService accountService;

  @Mock
  private Account mockAccount;

  @Captor // adnotacja Captor używana jest do przechwytywania parametrów wywołania metod
  ArgumentCaptor<Account.Currency> currencyCaptor;

  ClientService clientService;

  @Before
  public void setUp() throws Exception {
    clientService = new ClientService(clientSequence, clientsRepository, accountService);
    setUpClient();
    setUpAccount();
  }

  private void setUpAccount() {
    Mockito // Jeśli chcemy zamockować jaką funkcję- tzn. chcemy wymusić jej konkretne działanie używamy metody when
        .when(accountService.setupAccount(  // jako parametr metody przekzujemy wywołanie metody z klasy, którą zamockowaliśmy (@Mock)
            Mockito.any(Account.Currency.class), // jeśli chcemy, żeby nasz mock działa z dowolnym parametrem możemy użyć metody Mockito.any()
            Mockito.isNull()) // mockujemy dla wywołania z nullem jako 2-gim parametrem
        )
        .thenReturn(mockAccount); // aby, zwrócić określoną wartość z naszego mocka używamy metody thenReturn,
    //.thenThrow(new Exception()) // jeśli natomiast nasz mock ma rzucić wyjątek użyjemy metody thenThrow z wyjątkiem jak ma być rzucony
  }

  private void setUpClient() {
    Mockito.when(clientSequence.next()).thenReturn(1);
    Mockito.when(clientsRepository.save(Mockito.any(Client.class))).thenReturn(mockClient);
  }

  @Test
  public void testCreateClient() {
    clientService.createClient("test", "test", "12345");

    Mockito
        .verify(clientsRepository) // aby, zweryfikować wywołanie metod należy użyć metody verify, gdzie jako parametr przekazujemy mocka
        .save(new Client(1, "test", "test", "12345")); // i wywołujemy metodę, którą chcemy zweryfikować z podanymi parametrami
  }

  @Test
  public void testCreateNewAccount() {
    clientService.createNewAccount(mockClient, "PLN");

    Mockito
        .verify(accountService)
        .setupAccount(
            currencyCaptor.capture(), // jeśli chcemy przechwycić argument wywołania metody używamy klasy ArgumentCaptor i wywołujemy metodę capture na jej obiekcie,
            ArgumentMatchers.eq(null) //jeśli używamy ArgumentCaptor, kolejne parametry muszą być obiektami typu ArgumentMatcher, nie mogą być zwykłymi obiektami
        );
    Mockito.verify(mockClient).setAccount(mockAccount);

    Assert.assertEquals(Account.Currency.PLN, currencyCaptor.getValue()); // jeśli chcemy sprawdzić przechwycone parametry, na obiekcie typu ArgumentCaptor wołamy metodę getValue(), która zwraca przechwyconą wartość

  }
  
  private List<Client> clients;

  @Test
  public void findClientById_ValidId_ReturnsClient()  {
    
    Integer id = 1;

    Client result;
    try {
      result = clientService.findClientByCid(id);
    } catch (ClientNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void findClientById_InvalidId_ReturnsNull()  {
    
    Integer id = 4;

    Client result;
    try {
      result = clientService.findClientByCid(id);
    } catch (ClientNotFoundException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void findAll_ReturnsListOfClients() {
    List<Client> result = clientService.findAll();

  }
}
