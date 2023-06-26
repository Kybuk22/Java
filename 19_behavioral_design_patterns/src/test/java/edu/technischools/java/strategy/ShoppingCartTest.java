package edu.technischools.java.strategy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {

  @Spy
  CashPayment cashPayment;

  BlikPayment blikPayment;

  CreditCardPayment creditCardPayment;

  ShoppingCart shoppingCart;

  @Before
  public void setUp() throws Exception {
    shoppingCart = new ShoppingCart();

    shoppingCart.addItem(new Item(new BigDecimal("1.00"), "item 1"));
    shoppingCart.addItem(new Item(new BigDecimal("12.12"), "item 2"));

    blikPayment = Mockito.spy(new BlikPayment("123456"));

    creditCardPayment = Mockito.spy(new CreditCardPayment("123456", "123"));
  }

  @Test
  public void testPayWithCash() {
    
    shoppingCart.pay(cashPayment);

    Mockito.verify(cashPayment).pay(new BigDecimal("13.12"));
  }


  @Test
  public void testPayWithBlik() {
    shoppingCart.pay(blikPayment);

    Mockito.verify(blikPayment).pay(new BigDecimal("13.12"));
  }

  @Test
  public void testPayWithCC() {
    shoppingCart.pay(creditCardPayment);

    Mockito.verify(creditCardPayment).pay(new BigDecimal("13.12"));
  }
}
