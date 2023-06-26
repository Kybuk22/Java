package edu.technischools.java.parcel;

import java.math.BigDecimal;

public class ParcelService {

  public Parcel createParcel(double weight, BigDecimal value, String description) {
    //TODO 3 3. Zmienić metodę `ParcelService.createParcel` tak by na zwracała obiekt `Parcel` z uzupełnionymi polami. [1]

    return new Parcel(weight,value,description);
  }

  public Envelope createEnvelope(String description) {
    //TODO 4 4. Zmienić metodę `ParcelService.createEnvelope` tak by na zwracała obiekt `Envelope` zupełnionymi polami. [1]

    return new Envelope(description);
  }
}
