package com.multithreading.synchronizedWholeClass;

import java.util.Random;

public class EmployeeSynchronized {
    private int age;
    private String name;
    private double salary;

    public EmployeeSynchronized(int age, String name, double salary) {
        synchronized (EmployeeSynchronized.class) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName());
            this.age = age;
            this.name = name;
            this.salary = salary;
        }
    }

    public int getAge() {
        return age;
    }

    public synchronized void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        System.out.println("Age"+Thread.currentThread().getName());
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public synchronized void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeSynchronized{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


class testinSync implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            EmployeeSynchronized e1 = new EmployeeSynchronized(random.nextInt(), "" + random.nextInt(), random.nextDouble());
            e1.setAge(30);
        }
    }
}

class TestingEmployeeSynchronized {
    public static void main(String[] args) {
        Thread t1 = new Thread(new testinSync());
        Thread t2 = new Thread(new testinSync());
        t1.start();
        t2.start();
    }
}
