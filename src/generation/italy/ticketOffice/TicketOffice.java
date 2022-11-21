package generation.italy.ticketOffice;

public class TicketOffice {
    public static void main(String[] args) {
        try {
            Ticket ticket = new Ticket(-100, 17);
            System.out.println(ticket);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
