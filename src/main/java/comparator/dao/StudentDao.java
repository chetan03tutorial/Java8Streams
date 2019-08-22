package comparator.dao;

import collectors.domain.Employee;
import comparator.domain.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDao {


    private static Supplier<List<Student>> students = ()-> Arrays.asList(
            new Student(null, 20,"A"),
            new Student( null,20,"A"),
            new Student("IT-1",24,"B"),
            new Student("HR-2",26,"C"),
            new Student(null,25,"C"),
            new Student("IT-2", 19,"A"),
            new Student( "IT-3",24,"B"),
            new Student( "IT-4",32,"A"),
            new Student("PR-2",25,"A"),
            new Student("HR-4",27,"C"));


    public static Supplier<List<Student>> students(){
        return students;
    }
}
