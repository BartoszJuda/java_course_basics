package day02.user.ticket_reservation_system;

public class StudentTicket extends Ticket{

    public StudentTicket(String eventName, double basePrice) {
        super(eventName, basePrice);
    }

    @Override
    public double calculateFullPrice() {
        return getBasePrice() * 0.7;
    }
}
