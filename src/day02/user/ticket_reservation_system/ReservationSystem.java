package day02.user.ticket_reservation_system;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    private List<User> users;

    public ReservationSystem() {
        users = new ArrayList<>();
    }

    public void addUser (User user) {
        users.add(user);
    }

    public User findUserById(int userId) {
        for (User u: users) {
            if (u.getId() == userId) {
                return u;
            }
        }
        return null;
    }

    public void reserveTicketForUser(int userId, Ticket ticket) {
        User foundedUser = findUserById(userId);

        if (foundedUser != null) {
            ticket.reserve();
            foundedUser.addTicket(ticket);
            System.out.println("Bilet został dodany do użytkownika " + foundedUser.getName());
        } else {
            System.out.println("Uzytkownik od id: " + userId + " nie został odnaleziony");
        }
    }

    public void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Brak zarejestrowanych użytkowników w bazie");
            return;
        }
        for (User user : users) {
            System.out.println("\n===================");
            System.out.println("Id użytkownika: " + user.getId());
            System.out.println("Imię użytkownika: " + user.getName());
            //wypisanie biletów jest w klasie User
            user.showTickets();
        }
    }
}
