package com.designpatterns.adapter.approach1;

interface Bird {
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    public void fly();
    public void makeSound();
}

class Sparrow implements Bird {
    // a concrete implementation of bird
    public void fly() {
        System.out.println("Flying");
    }
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

interface ToyDuck {
    public void squeak();
}

class PlasticToyDuck implements ToyDuck {
    public void squeak() {
        System.out.println("Squeak");
    }
}

class BirdAdapter implements ToyDuck {

    Bird bird;

    public BirdAdapter(Bird bird) {

        this.bird = bird;
    }

    public void squeak() {
        System.out.println("quqck quack");
    }
}


public class AdapterTesting {
    public static void main(String args[]) {

        ToyDuck birdAdapter = new BirdAdapter(new Sparrow());
        Sparrow sparrow1 = (Sparrow) ((BirdAdapter) birdAdapter).bird;
        System.out.println("Sparrow...");
        sparrow1.fly();
        sparrow1.makeSound();

        System.out.println("ToyDuck...");

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
