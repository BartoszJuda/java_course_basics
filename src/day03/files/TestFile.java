package day03.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class TestFile {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Podaj swoje imię:");
            String name = scanner.nextLine();

            //utworzenie pliku
            FileWriter writer = new FileWriter("użytkownicy.txt");

            //zapis do pliku
            writer.write(name);
            writer.close();

            //odczyt pliku
            BufferedReader reader = new BufferedReader(new FileReader("użytkownicy.txt"));
            System.out.println("Odczyt użytkownika z pliku: " + reader.readLine());
            reader.close();

            //kopiowanie pliku
            Files.copy(Paths.get("użytkownicy.txt"),
                    Paths.get("użytkownicy_backup.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            //serializacja
            User user = new User(name);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.ser"));
            out.writeObject(user);
            out.close();

            //deserializacja
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.ser"));
            User loadedUser = (User) in.readObject();
            System.out.println("Odczytany deserializowany użytkownik: " + loadedUser.getName());


        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}

class User implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }
}
