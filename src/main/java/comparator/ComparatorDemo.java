package comparator;

import comparator.dao.StudentDao;
import comparator.domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {

    public static void sortByName(List<Student> students){
        List<String> list = students.stream().map(Student::getName).collect(Collectors.toList());
        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }

    public static void sortByAge(List<Student> students){
        students.sort(Comparator.comparing(Student::getAge).thenComparing(Student::getName));
        students.forEach(System.out::println);
    }

    public static void sortByNaturalOrder(List<Integer> studentAgeList){
        studentAgeList.sort(Comparator.naturalOrder());
        studentAgeList.forEach(System.out::println);
    }

    public static void sortEmployeeWithNullName(List<Student> students){
        Comparator<Student> comparator = Comparator.comparing(Student::getName);
        students.sort(Comparator.comparing(Student::getName,Comparator.nullsFirst(String::compareTo)));
        students.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Student> students = StudentDao.students().get();
        //sortByName(students);
        //sortByAge(students);
        //List<Integer> studentAgeList = students.stream().map(Student::getAge).collect(Collectors.toList());
        //sortByNaturalOrder(studentAgeList);
        sortEmployeeWithNullName(students);
    }
}
