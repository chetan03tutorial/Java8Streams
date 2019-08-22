package collectors.dao;

import collectors.domain.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class EmployeeDao {


    private static Supplier<List<Employee>> employees = ()-> Arrays.asList(
            new Employee(1,Double.valueOf(1000),Long.valueOf(20), "HR"),
            new Employee(2,Double.valueOf(1000),Long.valueOf(20), "PR"),
            new Employee(3,Double.valueOf(1200),Long.valueOf(20), "IT"),
            new Employee(4,Double.valueOf(1200),Long.valueOf(20), "HR"),
            new Employee(5,Double.valueOf(1400),Long.valueOf(20), "HR"),
            new Employee(6,Double.valueOf(1400),Long.valueOf(20), "IT"),
            new Employee(7,Double.valueOf(1500),Long.valueOf(20), "IT"),
            new Employee(8,Double.valueOf(1600),Long.valueOf(20), "IT"),
            new Employee(9,Double.valueOf(1000),Long.valueOf(20), "PR"),
            new Employee(1,Double.valueOf(1000),Long.valueOf(20), "HR"));


    public static Supplier<List<Employee>> employees(){
        return employees;
    }
}
