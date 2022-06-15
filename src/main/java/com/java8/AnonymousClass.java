package com.java8;

public class AnonymousClass {

    private int testing=123;

    abstract class AbstractClass {
        abstract void doSomething();
    }

    public static void main(String[] args) {
        AnonymousClass anonymousClass = new AnonymousClass();
        AbstractClass testingew= anonymousClass.new AbstractClass() {
            @Override
            void doSomething() {
                System.out.println("example of anonymous class");
            }
        };

        testingew.doSomething();

    }
}
