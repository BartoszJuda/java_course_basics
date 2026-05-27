package day03.messaging.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

    private ResourceBundle bundle;

    public Messages(Locale locale) {
        this.bundle = ResourceBundle.getBundle("day03.messaging.i18n.messages", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
