package ru.javawebinar.topjava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see <a href="http://topjava.herokuapp.com">Demo application</a>
 * @see <a href="https://github.com/JavaOPs/topjava">Initial project</a>
 */
public class Main {
    public static void main(String[] args) {
      //          System.out.format("Hello TopJava Enterprise!");
                Main myMain = new Main();
        List<Student> students = Arrays.asList(
                myMain.new Student("Alex", Speciality.Physics, 1),
                myMain.new Student("Rika", Speciality.Biology, 4),
                myMain.new Student("Julia", Speciality.Biology, 2),
                myMain.new Student("Steve", Speciality.History, 4),
                myMain. new Student("Mike", Speciality.Finance, 1),
                myMain.new Student("Hinata", Speciality.Biology, 2),
                myMain.new Student("Richard", Speciality.History, 1),
                myMain. new Student("Kate", Speciality.Psychology, 2),
                myMain.new Student("Sergey", Speciality.ComputerScience, 4),
                myMain.new Student("Maximilian", Speciality.ComputerScience, 3),
                myMain. new Student("Tim", Speciality.ComputerScience, 5),
                myMain.new Student("Ann", Speciality.Psychology, 1)
        );

        students.stream()
                .filter(student -> student.getYear() == 1
                        && student.getSpeciality() != Speciality.Physics).forEach(System.out::println);


//         students.stream()
//                .sorted(Comparator.comparing(Student::getSpeciality,
//                        Comparator.comparing(Enum::name))
//                        .thenComparingInt(Student::getYear)
//                )
//                .collect(Collectors.groupingBy(Student::getSpeciality, LinkedHashMap::new, Collectors.groupingBy(Student::getYear)))
//                .forEach((k,v) -> {
//                    System.out.println(" " + k + ": " + v);
//
//                    }
//                );


//        students.stream().collect(Collectors.groupingBy(Student::getSpeciality, Collectors.counting()))
//                .forEach((s, count) -> System.out.println(s + ": " + count));


//        students.stream().map(Student::getSpeciality).distinct().sorted().forEach(System.out::println);

//grouping year
//        students.stream().collect(Collectors.groupingBy(Student::getYear)).entrySet()
//                .forEach(System.out::println);
    }

    public class Student{
        private String name;
        private Speciality speciality;
        private int year;

        public Student(String name, Speciality speciality, int year) {
            this.name = name;
            this.speciality = speciality;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Speciality getSpeciality() {
            return speciality;
        }

        public void setSpeciality(Speciality speciality) {
            this.speciality = speciality;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return getYear() == student.getYear() &&
                    getName().equals(student.getName()) &&
                    getSpeciality() == student.getSpeciality();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getSpeciality(), getYear());
        }

        @Override
        public String toString() {
            return  '(' + name + ": " +
                     speciality +
                    ", " + year +
                    '}';
        }
    }

    public enum Speciality {
        Biology, ComputerScience, Economics, Finance,
        History, Philosophy, Physics, Psychology
    }
}
