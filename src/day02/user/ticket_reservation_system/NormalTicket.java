package day02.user.ticket_reservation_system;

public class NormalTicket extends Ticket {

    public NormalTicket(String eventName, double basePrice) {
        super(eventName, basePrice);
    }

    @Override
    public double calculateFullPrice() {
        return getBasePrice();
    }
}
