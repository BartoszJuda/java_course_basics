package day02.person;

public class Main {
    static void main(String[] args) {
        User user1 = new User("bartek", 18, "pass");
        User user2 = new User("Paweł", 21, "gkgdasdgjas");

        int age = user1.getAge();
        String userName = user1.getUsername();
        System.out.println(age + " " + userName);

        user1.introduceYourself();
    }
}
