/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.bank;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SampleMockTest {

  /**
   * adnotacja @Mock tworzy automatycznie daną klasę która, będzie mockiem-
   * czyli można weryfikować, jakie metody zostały na niej wywołana i z jakimi parametrami,
   * a także ustawić, jakie dane zostaną zwrócone, gdy dana metoda zostanie wywołana
   */
  @Mock
  List<String> list;

  @Test
  public void testAdding() {
    list.add("one"); // w przypadku Mocków, wywołania nie są przekazywane do prawdziwego obiektu, w związku z tym sprawdzenie z linii 39 nie zadziała
    list.add("two");

//  Mockito.verify(list).add("one"); // w przypadku Mocków możemy weryfikować czy i z jakimi parametrami metoda została wywołana
//  Mockito.verify(list).add("two");

    Mockito.verify(list, Mockito.times(2)).add(Mockito.anyString()); // możemy sprawdzić też, czy dana metoda została wywołana określoną ilość razy

//  Assert.assertEquals(2, list.size()); // to sprawdzenie nie zadziała-metody na obiektach Mock nie są przekazywane dalej
  }

  @Test
  public void testGetting() {

    Mockito.when(list.get(3)).thenReturn("three"); // chcąc ustawić odpowiednie zachowanie Mocka, używmy składni when-thenReturn/thenThrows,
    // gdzie ustalamy co ma się stać, gdy wywołamy mocka z odpowiednimi parametrami

    Assert.assertEquals("three", list.get(3));
  }

}
