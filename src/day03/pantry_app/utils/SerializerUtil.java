package day03.pantry_app.utils;

import java.io.*;

public class SerializerUtil {

    public static void save(Object object, String fileName) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {

            out.writeObject(object);
            System.out.println("Zapisano plik: " + fileName);

        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Object load(String fileName) {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(fileName))) {

            return in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
            return null;
        }
    }
}
