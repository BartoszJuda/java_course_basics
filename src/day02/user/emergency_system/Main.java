package day02.user.emergency_system;

import day02.user.emergency_system.enums.Priority;
import day02.user.emergency_system.reports.AccidentReport;
import day02.user.emergency_system.reports.EmergencyReport;
import day02.user.emergency_system.reports.FireReport;
import day02.user.emergency_system.reports.MedicalReport;
import day02.user.emergency_system.units.Ambulans;
import day02.user.emergency_system.units.FireTruck;
import day02.user.emergency_system.units.PoliceCar;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static DispatchCenter dispatchCenter = new DispatchCenter();
    static void main(String[] args) {

    }

    public void runApplication() {
        DispatchCenter center = new DispatchCenter();

        boolean running = true;

        while (running) {
            System.out.println("\n=====SYSTEM RATUNKOWY 112=====");
            System.out.println("1. - dodaj zgłoszenie");
            System.out.println("2. - przydziel jednostki");
            System.out.println("3. - pokaz aktywne zgłoszenia");
            System.out.println("4 - pokaz jednostki");
            System.out.println("5 - zakończ zgłoszenie");
            System.out.println("6. - historia zgłoszeń");
            System.out.println("7. - filtruj zgłoszenia po priorytecie");
            System.out.println("0. - wyjście");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\nPodaj typ zgloszenia");
                    System.out.println("1. Medyczne");
                    System.out.println("2. Pożar");
                    System.out.println("3. Wypadek");

                    int type = Integer.parseInt(sc.nextLine());

                    System.out.println("Podaj swoją lokalizację");
                    String location = sc.nextLine();

                    System.out.println("Podaj opis zgłoszenia:");
                    String description = sc.nextLine();

                    //todo - dodac wybieranie priorytetu
                    Priority priority = choosePriority();

                    EmergencyReport report = switch (type) {
                        case 1 -> new MedicalReport(location, description, priority);
                        case 2 -> new FireReport(location, description, priority);
                        case 3 -> new AccidentReport(location, description, priority);
                        default -> null;
                    };

                    if (report != null) {
                        center.addReport(report);
                        System.out.println("Dodano zgłoszenie");
                    } else {
                        System.out.println("Nieprawidłowy typ zgłoszenia");
                    }
            }
        }
    }

    private static Priority choosePriority() {
        System.out.println("\nPriorytet");
        System.out.println("1. LOW");
        System.out.println("2. MEDIUM");
        System.out.println("3. HIGH");

        int choice = Integer.parseInt(sc.nextLine());

        return switch (choice) {
            case 1 -> Priority.LOW;
            case 2 -> Priority.MEDIUM;
            case 3 -> Priority.HIGH;
            default -> Priority.MEDIUM;
        };
    }

    private static void seedData() {
        dispatchCenter.addUnit(new Ambulans("A-01", "Cenrum"));
        dispatchCenter.addUnit(new Ambulans("A-2", "Południe"));
        dispatchCenter.addUnit(new Ambulans("A-3", "Zachód"));
        dispatchCenter.addUnit(new FireTruck("FT-01", "Zachód"));
        dispatchCenter.addUnit(new PoliceCar("PC-1", "Wschód"));
        dispatchCenter.addUnit(new PoliceCar("PC-2", "Północ"));
    }

}
