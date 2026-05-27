package day03;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resources {

    static void main(String[] args) {
        Locale locale = new Locale("pl");

        ResourceBundle resourceBundle= ResourceBundle.getBundle("day03.messages", locale);

        System.out.println(resourceBundle.getString("menu.exit"));
    }
}
