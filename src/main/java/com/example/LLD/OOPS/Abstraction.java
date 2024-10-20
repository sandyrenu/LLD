package com.example.LLD.OOPS;

 abstract class Vehicle {
    // Abstract method (no implementation)
    abstract void accelerate();

    // Concrete method (implementation provided)
    void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {
    @Override
    void accelerate() {
        System.out.println("Car is accelerating...");
    }
}


// This class ideally main function
public class Abstraction {
    public static void abstraction(String[] args) {
        // Creating an object of Car class
        Vehicle myCar = new Car();
        myCar.start();         // Abstracted behavior
        myCar.accelerate();     // Implementation hidden, abstracted behavior
    }
}


// Abstract classes doesnt have multiple inheritance due to diamond problem
