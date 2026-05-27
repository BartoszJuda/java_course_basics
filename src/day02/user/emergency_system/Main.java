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
   private static final Scanner scanner = new Scanner(System.in);

   private static final DispatchCenter center = new DispatchCenter();

    static void main(String[] args) {

        seedData();

        boolean isRunning = true;

        while (isRunning) {

            showMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> addReport();
                case 2 -> center.dispatchUnits();
                case 3 -> center.showActiveReports();
                case 4 -> center.showUnits();
                case 5 -> finishReport();
                case 6 -> center.showHistory();
                case 7 -> filterReportsByPriority();
                case 8 -> center.showTodayReports();
                case 9 -> center.saveHistoryToCsvFile();
                case 0 -> {
                    isRunning = false;
                    System.out.println("Zamykanie systemu");
                }

                default -> System.out.println("Wybrłeś nieprawidłową opcję");
            }
        }
    }

   private static void showMenu() {
       System.out.println("\n-----SYSTEM RATUNKOWY-----");

       System.out.println("1. Dodaj zgłoszenie");
       System.out.println("2. Przydziel jednostki");
       System.out.println("3. Pokaż aktywne zgłoszenia");
       System.out.println("4. Pokaż jednostki");
       System.out.println("5. Zakończ zgłoszenie");
       System.out.println("6. Historia zgłoszeń");
       System.out.println("7. Filtruj zgłoszenia po priorytecie");
       System.out.println("8. Pokaż dzisiejsze zgłoszenia");
       System.out.println("9. Zapisz historię do pliku csv");
       System.out.println("0. Wyjście z programu");
   }

   private static void  seedData() {

       center.addUnit(new Ambulans("A1", "Północ"));
       center.addUnit(new PoliceCar("P1", "Południe"));
       center.addUnit(new PoliceCar("P2", "Zachód"));
       center.addUnit(new FireTruck("FT1", "Wschód"));
   }

   private static void addReport() {

       System.out.println("\nTyp zgłoszenia");

       System.out.println("1. Medyczne");
       System.out.println("2. Pożar");
       System.out.println("3. Wypadek");
       int type = Integer.parseInt(scanner.nextLine());

       System.out.println("Podaj lokalizację");
       String location = scanner.nextLine();

       System.out.println("Podaj opis zgłoszenia");
       String description = scanner.nextLine();

       Priority priority = choosePriority();

       EmergencyReport report = switch (type) {

           case 1 -> new MedicalReport(
                   location,
                   description,
                   priority
           );

           case 2 -> new FireReport(
                   location,
                   description,
                   priority
           );

           case 3 -> new AccidentReport(
                   location,
                   description,
                   priority
           );

           default -> null;
       };

       if (report != null) {
           center.addReport(report);

           System.out.println("Dodano nowe zgłoszenie");
       } else {
           System.out.println("Nieprawidłowy typ zgłoszenia");
       }

   }

   private static Priority choosePriority() {

       System.out.println("\nPriorytet");

       System.out.println("1. LOW");
       System.out.println("2. MEDIUM");
       System.out.println("3. HIGH");

       int choice = Integer.parseInt(scanner.nextLine());

       return switch (choice) {
           case 1 -> Priority.LOW;
           case 2 -> Priority.MEDIUM;
           case 3 -> Priority.HIGH;
           default -> Priority.MEDIUM;
       };
   }

   private static void finishReport() {

       System.out.println("Podaj id zgloszenia do zakończenia");
       int id = Integer.parseInt(scanner.nextLine());

       center.finishReport(id);

       System.out.println("Zgłoszenie o id" + id + " zostało zakończone");
   }

   private static void filterReportsByPriority() {

       Priority priority = choosePriority();

       center.showReportsByPriority(priority);
   }

}
