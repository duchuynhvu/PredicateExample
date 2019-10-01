package com.tma.training;

import java.util.Arrays;
import java.util.List;
import static com.tma.training.EmployeePredicates.*;

public class EmployeePredicatesTest {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList( //
                new Employee(1, 23, "M", "Rick", "Beethovan"), //
                new Employee(2, 13, "F", "Martina", "Hengis"), //
                new Employee(3, 43, "M", "Ricky", "Martin"), //
                new Employee(4, 26, "M", "Jon", "Lowman"), //
                new Employee(5, 19, "F", "Cristine", "Maria"), //
                new Employee(6, 15, "M", "David", "Feezor"), //
                new Employee(7, 68, "F", "Melissa", "Roy"), //
                new Employee(8, 79, "M", "Alex", "Gussin"), //
                new Employee(9, 15, "F", "Neetu", "Singh"), //
                new Employee(10, 45, "M", "Naveen", "Jain") //
        );

        // Lấy danh sách Employee nam 21+
        System.out.println(filterEmployees(employees, isAdultMale()));

        // Lấy danh sách Employee nữ 18+
        System.out.println(filterEmployees(employees, isAdultFemale()));

        // Lấy danh sách Employee > 35 tuổi
        System.out.println(filterEmployees(employees, isAgeMoreThan(35)));

        // Lấy danh sách Employee <= 35 tuổi
        System.out.println(
                filterEmployees(employees, isAgeMoreThan(35).negate()));
    }
}
