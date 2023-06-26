package edu.technischools.java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.technischools.Plane;

public class GenericTest {
    public static void main(String[] args)
        {
            Set<Plane> planes = new HashSet<>();
        
            Plane plane1 = new Plane(700, 10000, "Boeing 767-223ER");
            Plane plane2 = new Plane(900, 12000, "Boeing 767-223ER");
            Plane plane3 = new Plane(800, 11000, "Bruh 767-223ER");
            Car car =new Car(950);
            planes.add(plane1);
            planes.add(plane2);
            planes.add(plane3);

            List<Plane> sortedPlanes = new ArrayList<>(planes);
            Collections.sort(sortedPlanes);
            
            System.out.println("Sort:");
            for (Plane plane : sortedPlanes) {
                System.out.println(plane.getName() + " - Speed: " + plane.getSpeed());
            }
            if (car.getSpeed() > plane1.getSpeed()) {
                    System.out.println("Car is faster than Plane");
            } else if (car.getSpeed() < plane1.getSpeed()) {
                    System.out.println("Plane is faster than Car");
            } else {
                    System.out.println("Car and Plane have the same speed");
            }
    
}}
