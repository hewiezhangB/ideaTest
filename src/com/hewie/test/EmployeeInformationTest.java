package com.hewie.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInformationTest {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("test1"),
                new Employee("test2"),
                new Employee("test3"));

        List<String> employ = employees.stream().map(ele -> ele.getEmpName()).collect(Collectors.toList());
        System.err.println(employ);
    }
}
