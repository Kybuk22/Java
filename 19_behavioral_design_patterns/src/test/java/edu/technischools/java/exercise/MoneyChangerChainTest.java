package edu.technischools.java.exercise;

import edu.technischools.java.exercise.chain.moneychanger.CashMoneyChanger;
import edu.technischools.java.exercise.chain.moneychanger.MoneyChange;
import edu.technischools.java.exercise.chain.moneychanger.MoneyChangerChain;
import org.junit.Before;
import org.junit.Test;

/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
public class MoneyChangerChainTest {

  MoneyChangerChain changerChain = new MoneyChangerChain();

  @Before
  public void setUp() throws Exception {

    changerChain.addChanger(new CashMoneyChanger(100));
    changerChain.addChanger(new CashMoneyChanger(50));
    changerChain.addChanger(new CashMoneyChanger(5));
    changerChain.addChanger(new CashMoneyChanger(2));
  }

  @Test
  public void testChange() {

    MoneyChange moneyChange = changerChain.doChange(new MoneyChange(257));

    System.out.println(moneyChange.getChange());

  }
}
