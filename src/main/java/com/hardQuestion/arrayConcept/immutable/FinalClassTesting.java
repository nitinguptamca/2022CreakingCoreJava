package com.hardQuestion.arrayConcept.immutable;

public final class FinalClassTesting {
    final String fname;
    final String lname;
    final int age;
    final double salary;

    public FinalClassTesting(String fname, String lname, int age, double salary) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.salary = salary;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "FinalClassTesting{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
