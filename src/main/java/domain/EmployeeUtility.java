package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class EmployeeUtility {

    public static List<Employee> getListOfEmployee(){
        List<Employee> empList = new ArrayList<Employee>();
        IntStream.range(0, 10).forEach( (number)->
                empList.add(new Employee(number,"E".concat(String.valueOf(number))))
        );
        return empList;
    }
}
