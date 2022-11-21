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

            //I cortrutti try-catch servono per ricevere eventuali eccezioni, 
            //inseriamo nella try il pezzo di codice che potrebbe generare un eccezione e nel catch il pezzo di codice utile a gestire l'eccezione
            try {
                Ticket ticket = new Ticket(km, age, isFlexible);
                container[i] = ticket;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(Arrays.toString(container));

        sn.close();


        //la classe FileWriter ci permette di avere uno stream di input e di crazione di un file
        //(si utilizza il costrutto try-catch perchè le funzioni della classe FileWriter possono restituire eccezioni)
        FileWriter fileWriter = null;
        try {
            //con new FileWriter creiamo il file andando a specificare il percorso
            fileWriter = new FileWriter("./container.txt");
            for (int i = 0; i < container.length; i++) {
                Ticket t = container[i];
                //con append() scriviamo sul file aggiungendo il contenuto a quello già presente, 
                //con write il contenuto vieni sovrascritto (si può aggirare inserendo \n alla fine del contenuto inserito write(t.toString + "\n"))
                fileWriter.append(t.toString());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            //anche la close può causare eccezioni
            try {
                fileWriter.close();
            } catch (IOException e) {
                //printStackTrace mostra a schermo tutto il percorso svolto fino all'eccezione
                e.printStackTrace();
            }
        }

        //con la classe File si può recuperare il file con il path specificato
        File f = new File("./container.txt");
        Scanner fileSc = null;
        
        try {
            //lo Scanner funziona esattamente allo stesso modo, ma con uno stream di input differente (il file)
            fileSc = new Scanner(f);
            //con il ciclo con condizione hasNextLine andiamo a leggere tutte le righe presenti nel file
            while (fileSc.hasNextLine()) {
                //con nextLine prendiamo la riga similmente a quando prendiamo un input dal terminale
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
