package day02.user.ticket_reservation_system;

abstract class Ticket {
    private String eventName;
    private double basePrice;
    private boolean reserved;

    public Ticket(String eventName, double basePrice) {
        this.eventName = eventName;
        this.basePrice = basePrice;
        this.reserved = false;
    }

    public String getEventName() {
        return eventName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isReserved() {
        return isReserved();
    }

    public void reserve(){
        reserved = true;
    }

    public abstract double calculateFullPrice();

    public void printTicketInfo() {
        System.out.println("Wydarzenie " + eventName);
        System.out.println("Cena " + calculateFullPrice() + " PLN");
        System.out.println("Rezerwacja " + (reserved ? "TAK" : "NIE"));
    }
}
