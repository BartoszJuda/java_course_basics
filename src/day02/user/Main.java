package day02.user;

public class Main {
    static void main(String[] args) {
        User user1 = new User("bartek", 18, "pass");
        User user2 = new User("Paweł", 21, "gkgdasdgjas");

        user1.setAge(0);
        user1.introduceYourself();
    }
}
