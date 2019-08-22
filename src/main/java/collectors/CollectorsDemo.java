package collectors;

import collectors.dao.EmployeeDao;
import collectors.domain.Employee;
import functional.BiConsumerDemo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo<T,R> {

    private static List<Employee> employees = EmployeeDao.employees().get();

    public void demoGroupingByReturningMapOfList(List<T> supplier, Function<T,R> f, ToDoubleFunction<T> downstreamFunction){
        Stream<T> stream = supplier.stream();
        Map<R, Double> collectionByGroup = stream.collect(Collectors.groupingBy(f, Collectors.averagingDouble(downstreamFunction)));
        collectionByGroup.forEach((R department, Double empList)-> System.out.println("Department = "+ department + ", Employees = " + empList));
    }


    public void demoGroupingByReturningMapOfSet(List<T> supplier, Function<T,R> f){
        Stream<T> stream = supplier.stream();
        Map<R, Set<T>> collectionByGroup = stream.collect(Collectors.groupingBy(f, Collectors.toSet()));
        collectionByGroup.forEach((R department, Set<T> empList)-> System.out.println("Department = "+ department + ", Employees = " + empList));
    }

    public void demoGroupingByCountOfElement(List<T> supplier, Function<T,R> f){
        Stream<T> stream = supplier.stream();
        Map<R, Long> collectionByGroup = stream.collect(Collectors.groupingBy(f, Collectors.counting()));
        collectionByGroup.forEach((R department, Long count)-> System.out.println("Department = "+ department + ", Number of Employee in department = " + count));
    }

    public <RR> void averageSalaryByDepartment(List<T> supplier, Function<T,R> f, ToDoubleFunction<T> avgFunction, BiConsumer<R,Double> actionOnMapEntry){
        Stream<T> stream = supplier.stream();
        Map<R, Double> collectionByGroup = stream.collect(Collectors.groupingBy(f, Collectors.averagingDouble(avgFunction)));
        //collectionByGroup.forEach((R department, Double avgSalary)-> System.out.println("Department = "+ department + ", Number of Employee in department = " + avgSalary));
        printMapV1(()-> collectionByGroup);
        printMapV2(()->collectionByGroup,actionOnMapEntry);
    }

    public <RR> void  printMapV1(Supplier<? extends Map<R,RR >> supplier){
        Map<R,RR> map = supplier.get();
        map.forEach((department,value)-> System.out.println(department +","+ value));
    }

    public <RR> void  printMapV2(Supplier<? extends Map<R,RR >> supplier, BiConsumer<R,RR> biConsumer){
        Map<R,RR> map = supplier.get();

        map.forEach((department,value)-> System.out.println(department +","+ value));
        map.forEach((department,value)->biConsumer.accept(department,value));
    }


    public static void main(String[] args) {
        CollectorsDemo<Employee,String> demo = new CollectorsDemo<>();
        demo.demoGroupingByReturningMapOfList(EmployeeDao.employees().get(), Employee::getDepartment, Employee::getSalary);
        //demo.demoGroupingByReturningMapOfSet(EmployeeDao.employees().get(),Employee::getDepartment);
        //demo.demoGroupingByCountOfElement(EmployeeDao.employees().get(),Employee::getDepartment);
        //demo.averageSalaryByDepartment(EmployeeDao.employees().get(),Employee::getDepartment, Employee::getSalary,(String department,Double value)-> System.out.println(department+"="+value));
    }


}
