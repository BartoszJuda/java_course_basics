package day02.person;

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

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public void introduceYourself() {
        System.out.println("Cześć, jestem użytkownikiem: " + username + " i mam: " + age + " lat.");
    }
}
