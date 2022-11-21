package generation.italy.ticketOffice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TicketOffice {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Quanti biglietti si vogliono creare?");
        int n = sn.nextInt();
        Ticket[] container = new Ticket[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Inserire il numero di km:");
            int km = sn.nextInt();
            System.out.println("Inserire l'età:");
            int age = sn.nextInt();
            System.out.println("Vuole il biglietto flessibile? (true/false)");
            boolean isFlexible = sn.nextBoolean();
            try {
                Ticket ticket = new Ticket(km, age, isFlexible);
                container[i] = ticket;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(Arrays.toString(container));

        sn.close();



        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("./container.txt");
            for (int i = 0; i < container.length; i++) {
                Ticket t = container[i];
                fileWriter.append(t.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File f = new File("./container.txt");
        Scanner fileSc = null;
        
        try {
            fileSc = new Scanner(f);
            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }finally{
            fileSc.close();
        }
    }
}
