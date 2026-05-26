package day02.user.ticket_reservation_system;

public class VeteranTicket extends Ticket {

    public VeteranTicket(String eventName, double basePrice) {
        super(eventName, basePrice);
    }

    @Override
    public double calculateFullPrice() {
        return getBasePrice() * 0.1;
    }
}
