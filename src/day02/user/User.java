package day02.user;

public class User {
    private String username;
    private int age;
    private String password;

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Wiek nie może być ujemny");
        }

    }

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public void introduceYourself() {
        System.out.println("Cześć, jestem użytkownikiem: " + username + " i mam: " + age + " lat.");
    }
}
