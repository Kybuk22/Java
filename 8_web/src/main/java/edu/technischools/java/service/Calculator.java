package edu.technischools.java.service;

public class Calculator {
  private static Calculator instance;

  private Calculator() {
  }

  public static Calculator getInstance() {
    if (instance == null) {
      instance = new Calculator();
    }
    return instance;
  }

  public Double compute(Double a, Double b, String operation) throws ComputationException {
    if (a == null || b == null) {
      throw new ComputationException("Parametry nie mogą być null.");
    }

    Double result;

    switch (operation) {
      case "ADD":
        result = a + b;
        break;
      case "SUB":
        result = a - b;
        break;
      case "MUL":
        result = a * b;
        break;
      case "DIV":
        if (b != 0) {
          result = a / b;
        } else {
          throw new ComputationException("Nie można dzielić przez zero!");
        }
        break;
      default:
        throw new ComputationException("Nieprawidłowa operacja: " + operation);
    }

    return result;
  }
}
