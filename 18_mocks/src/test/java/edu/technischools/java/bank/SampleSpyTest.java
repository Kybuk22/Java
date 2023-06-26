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
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class SampleSpyTest {

  /**
   * Adnotacja Spy pozwala stworzyć tzw. częściowego mocka, tzn. możemy weryfikować czy metody zostały wywołane
   * i z jakimi parametrami, ale dodatkowo prawdziwe metody zostaną wywołane
   */
  @Spy
  ArrayList<String> list = new ArrayList<>();

  @Test
  public void testAdding() {
    list.add("one"); // mimo tego, że mamy obiekt Spy, to dodawanie do listy zwiększa jej rozmiar
    list.add("two"); //

    Assert.assertEquals(2, list.size()); // dlatego możemy sprawdzić rozmiar
    Mockito.verify(list, Mockito.times(2)).add(Mockito.anyString()); // ale dodatkowo możemy zweryfikować czy metoda została wywołana
  }

  @Test
  public void testGetting() {
    /*
     *  w przypadku obiektów typu Spy, normalne 'mockowanie' nie zadziała, z racji tego, że wywołujemy metodę-
     *  (w tym wypadku - list.get(3)), która może spowodować błąd z racji tego, że jest wywoływana na prawdziwym obiekcie
     */

//    Mockito.when(list.get(3)).thenReturn("three");

    /*
     * w takim wypadku musimy użyć, odwrotnej składni i funkcji doReturn, gdzie jawnie nie wołamy metody na obiekcie Spy
     */
    Mockito.doReturn("three").when(list).get(3);

    Assert.assertEquals("three", list.get(3));
  }

}
