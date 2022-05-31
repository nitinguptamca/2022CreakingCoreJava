package com.java8;

import javax.management.MBeanAttributeInfo;
import java.util.*;
import java.util.stream.Collectors;

public class ApplyOperationEmployee {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("nitin", 43, 245999.8d));
        employees.add(new Employee("sachin", 43, 245239.8d));
        employees.add(new Employee("mark", 67, 35999.8d));
        employees.add(new Employee("vandna", 12, 298999.8d));
        employees.add(new Employee("moumita", 46, 9865999.8d));
        employees.add(new Employee("nitu", 46, 8654999.8d));
        employees.add(new Employee("sangeeta", 56, 3245999.8d));
        employees.add(new Employee("hira", 23, 2345999.8d));
        employees.add(new Employee("panna", 12, 99d));
        employees.add(new Employee("teena", 12, 10d));
        employees.add(new Employee("reena", 99, 125999.8d));

    }

    public static void main(String[] args) {
        List<Employee> ssss = employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                if (e1.getSalary() > e2.getSalary()) return -1;
                else return 1;
            } else if (e1.getAge() > e2.getAge()) return 1;
            else return -1;
        }).collect(Collectors.toList());
        System.out.println(ssss);
    }


    public static void main1(String[] args) {



        System.out.println();

        //sort by salary
        List<Employee> listsored = employees
                .stream()
                // option1   //.sorted(Comparator.comparing(Employee::getSalary ,Comparator.nullsFirst(Comparator.reverseOrder())))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(listsored);

        List<Employee> sortedList = listsored.stream()
                .sorted((o1, o2) -> {
                    if(o1.getAge() == o2.getAge())
                        return o1.getName().compareTo(o2.getName());
                    else if(o1.getAge() > o2.getAge())
                        return 1;
                    else return -1;
                })
                .collect(Collectors.toList());

        List<String> list = Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon");
        List<String> sortedList1 = list.stream().sorted().collect(Collectors.toList());

        sortedList1 = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        listsored.sort(Comparator.comparing(Employee::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        listsored.sort(Comparator.comparing(Employee::getAge, Comparator.nullsLast(Comparator.reverseOrder())));

    }
}
