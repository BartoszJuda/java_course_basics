package day02.user.ticket_reservation_system;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        runApplication();
    }

    static void runApplication() {
        Scanner scanner = new Scanner(System.in);

        ReservationSystem rs = new ReservationSystem();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n-----SYSTEM REZERWACJI BILETÓW ODPALONY-----");
            System.out.println("1. Dodaj nowego użytkownika");
            System.out.println("2. Dodaj bilet użytkownikowi");
            System.out.println("3. Wyświetl użytkowników");
            System.out.println("4. Wyjście z programu");
            System.out.println("Wybierz opcje (1, 2, 3, 4)");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Proszę o podanie id użytkownika");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Proszę o podanie imienia");
                    String name = scanner.nextLine();

                    User newUser = new User(id, name);
                    rs.addUser(newUser);
                    break;
                case 2:
                    System.out.println("Proszę o podanie id użytkownika");
                    int userId = Integer.parseInt(scanner.nextLine());

                    System.out.println("\nTyp biletu:");
                    System.out.println("1. Normalny");
                    System.out.println("2. Studencki");
                    System.out.println("3. Weteran");
                    System.out.println("4. VIP");

                    int ticketType = Integer.parseInt(scanner.nextLine());

                    System.out.println("Podaj nazwę wydarzenia");
                    String eventName = scanner.nextLine();

                    System.out.println("Podaj bazowa cenę biletu");
                    double basePrice = Double.parseDouble(scanner.nextLine());

                    Ticket ticket = null;

                    switch (ticketType) {
                        case 1:
                            ticket = new NormalTicket(eventName, basePrice);
                            break;
                        case 2:
                            ticket = new StudentTicket(eventName, basePrice);
                            break;
                        case 3:
                            ticket = new VeteranTicket(eventName, basePrice);
                        case 4:
                            System.out.println("Podaj dopłatę do biletu");
                            double vipFree = Double.parseDouble(scanner.nextLine());
                            ticket = new VipTicket(eventName, basePrice, vipFree);
                            break;
                        default:
                            System.out.println("Wskazałeś niepoprawny typ biletu");
                    }
                    if (ticket != null) {
                        rs.reserveTicketForUser(userId, ticket);
                    }
                case 3:
                    rs.showAllUsers();
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Koniec działania programu");
                    break;
            }
        }
        scanner.close();
    }

}
