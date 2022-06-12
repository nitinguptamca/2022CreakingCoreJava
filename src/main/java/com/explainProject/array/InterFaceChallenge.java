package com.explainProject.array;

 interface Alarm {

    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }

    static String testing123(){ return  "testing 1231";}
}

 interface Vehicle {
    String getBrand();
    String speedUp();
    String slowDown();
    static String getSound(){
        return "mild sound";
    }
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }
    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }
    static int getHorsePower(int rpm, int torque) {
         return (rpm * torque) / 5252;
     }
}

class TestingCar implements Vehicle{

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String speedUp() {
        return null;
    }

   @Override
    public String slowDown() {
        return null;
    }
 /*
    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn();
    }*/

    @Override
    public String turnAlarmOff() {
       int abc= Vehicle.getHorsePower(1 ,3);


        return Vehicle.super.turnAlarmOff();

    }
}

class Car implements Vehicle,Alarm {

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }
// constructors/getters

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }
/*
    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff();
    }*/

    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
    }
}

public class InterFaceChallenge {
    public static void main(String[] args) {
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
    }
}
