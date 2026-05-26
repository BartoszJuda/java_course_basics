package day02.user.ticket_reservation_system;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private List<Ticket> tickets;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    //gettery:
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    //setter:


    public void setName(String name) {
        this.name = name;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket (Ticket ticket) {
        tickets.add(ticket);
    }

    public void showTickets() {
        System.out.println("\nBilety użytkownika: " + name);
        if (tickets.isEmpty()) {
            System.out.println("Użytkownik nie ma dodanych zadnych nowych biletów");
            return;
        }
        for (Ticket ticket : tickets) {
            System.out.println("----------------");
            ticket.printTicketInfo();
        }
     }
}
