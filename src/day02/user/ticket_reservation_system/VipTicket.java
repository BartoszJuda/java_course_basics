package day02.user.ticket_reservation_system;

public class VipTicket extends Ticket {

    private double vipFree;

    public VipTicket(String eventName, double basePrice, double vipFree) {
        super(eventName, basePrice);
        this.vipFree = vipFree;
    }

    @Override
    public double calculateFullPrice() {
        return getBasePrice() + vipFree;
    }
}
