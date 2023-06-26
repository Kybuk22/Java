import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;

import edu.technischools.java.bank.Account;
import edu.technischools.java.bank.InsufficientFundsException;
import edu.technischools.java.bank.TransferService;

public class TransferServiceTest {

  @Test
  public void testTransferSuccessful() throws InsufficientFundsException {
    Account from = new Account();
    from.setNo("1");
    from.setBalance(BigDecimal.valueOf(100));

    Account to = new Account();
    to.setNo("2");
    to.setBalance(BigDecimal.valueOf(0));

    TransferService transferService = TransferService.getInstance();
    transferService.transfer(from, to, BigDecimal.valueOf(50));

    assertEquals(BigDecimal.valueOf(50), from.getBalance());
    assertEquals(BigDecimal.valueOf(50), to.getBalance());
  }

  @Test
  public void testTransferWithNullFromAccount() {
    Account from = null;
    Account to = new Account();
    to.setNo("2");
    to.setBalance(BigDecimal.valueOf(0));

    TransferService transferService = TransferService.getInstance();

    assertThrows(NullPointerException.class, () -> transferService.transfer(from, to, BigDecimal.valueOf(50)));
  }

  @Test
  public void testTransferWithNullToAccount() {
    Account from = new Account();
    from.setNo("1");
    from.setBalance(BigDecimal.valueOf(100));

    Account to = null;

    TransferService transferService = TransferService.getInstance();

    assertThrows(NullPointerException.class, () -> transferService.transfer(from, to, BigDecimal.valueOf(50)));
  }

  @Test
  public void testTransferWithInsufficientFunds() {
    Account from = new Account();
    from.setNo("1");
    from.setBalance(BigDecimal.valueOf(100));

    Account to = new Account();
    to.setNo("2");
    to.setBalance(BigDecimal.valueOf(0));

    TransferService transferService = TransferService.getInstance();

    assertThrows(InsufficientFundsException.class, () -> transferService.transfer(from, to, BigDecimal.valueOf(150)));
  }
}