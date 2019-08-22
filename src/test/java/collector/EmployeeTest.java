package collector;


import domain.Employee;
import domain.EmployeeUtility;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EmployeeTest {


    @Test
    public void testCollectorToList(){

        List<Employee> empList = EmployeeUtility.getListOfEmployee();

        Stream<Employee> employeeStream = empList.stream();

        List<Integer> empIdList = employeeStream.map((e)-> e.getEmpId()*2).
                collect(Collectors.toList());

        //empIdList.stream().forEach((e)-> System.out.println("Employee Id Details are " + e.intValue()));


        String[] names = {"A","B"};
        String nameString = Arrays.stream(names).collect(Collectors.joining(","));
        //String commaSeparatedEmpIdList = empIdList.stream().collect().toString();


        Supplier<List<String>> someList = ArrayList::new;
        List<String> stringList = someList.get();
        stringList.add("A1");
        stringList.add("A2");
        stringList.add("A3");
        stringList.add("A4");
        stringList.add("A5");
        stringList.forEach(s-> System.out.println(s));



    }




    public static String ShowDetails(Integer aNumber){
        System.out.println("aNumber = " + aNumber + " aName = ");
        return "A";
    }

    /*public void test(){
        BiConsumer<Integer,String> biConsumer = EmployeeTest::ShowDetails;
    }*/
}
