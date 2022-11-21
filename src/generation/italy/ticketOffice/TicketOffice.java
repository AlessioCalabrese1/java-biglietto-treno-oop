package generation.italy.ticketOffice;

import java.util.Scanner;

public class TicketOffice {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Inserire il numero di km:");
        int km = sn.nextInt();
        System.out.println("Inserire l'età:");
        int age = sn.nextInt();
        try {
            Ticket ticket = new Ticket(km, age);
            System.out.println(ticket);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
