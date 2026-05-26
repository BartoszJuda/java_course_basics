package day02.user.records;

public class Main {
    static void main(String[] args) {
        Student student = new Student(1, "Bartosz", 4.2, "Juda");

        System.out.println(student.average());
        System.out.println(student.id());
        System.out.println(student.name());
        System.out.println(student.lastName());
    }
}
