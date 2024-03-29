package HW1;

import Sem1.Streams;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {

        List<Department> departments = addDepartmentsList();
        List<Person> personList = addPersonList(departments);
        Map<Department, Person> departmentMap = printDepartmentOldestPerson(personList);
        departmentMap.forEach((d,p) -> System.out.println(d.getName() + p.getName()));
        Department topDepartment = findDepartmentMaxSalary(personList).orElse(null);
        System.out.println(topDepartment);
    }

    /**
     * Реалзиовать методы, описанные ниже:
     *
     */

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
//    public void printNamesPerson(List<Streams.Person> persons) {
//        // ...
//        persons.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
//    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public static Map<Department, Person> printDepartmentOldestPerson(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(Person::getDepartment, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Person::getAge))));
    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */

    public static List<Person> findFirstPersons(List<Person> persons) {
        return persons.stream().filter(person -> person.getAge() < 30).filter(person -> person.getSalary() > 50_000).
                limit(10).collect(Collectors.toList());
    }

    /**
     * Найти департамент, чья суммарная зарплата всех сотрудников максимальна
     */
    public static Optional<Department> findDepartmentMaxSalary(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getDepartment, Collectors.summingDouble(Person::getSalary))).
                entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue)).map(Map.Entry::getKey);
    }

    public static List<Department> addDepartmentsList() {
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Department("Department -> " + i));
        }
        return departments;
    }


    public static List<Person> addPersonList(List<Department> departments) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            persons.add(new Person(
                    " Person # " + i,
                    ThreadLocalRandom.current().nextInt(20, 61),
                    ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }
        return persons;
    }
}
