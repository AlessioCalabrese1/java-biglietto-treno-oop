package generation.italy.ticketOffice;

import java.math.BigDecimal;

public class Ticket {
    private int km;
    private int age;

    final private double Km_Cost = 0.21;
    final private double Discount_Over_65 = 40;
    final private double Discount_For_Minors = 20;

    private double ticketCost = 0;

    public Ticket(int km, int age) throws Exception{
        setKm(km);
        setAge(age);
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) throws Exception {
        if (isValidKm(km)) {
            this.km = km;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (isValidAge(age)) {
            this.age = age;
        }
    }

    public boolean isValidKm(int km) throws Exception{
        if (km < 1) {
            throw new Exception("Il valore KM inserito NON è valido!");
        }else{
            return true;
        }
    }

    public boolean isValidAge(int age) throws Exception{
        if (age < 1) {
            throw new Exception("Il valore AGE inserito NON è valido!");
        }else{
            return true;    
        }
    }

    public double calculatePrice(int km, int age){
            ticketCost = (km * Km_Cost) - ((km * Km_Cost)*calculateDiscount(age))/100;
            return ticketCost;
    }

    private double calculateDiscount(int age){
        if (age < 18) {
            return Discount_For_Minors;
        }else if(age > 65){
            return Discount_Over_65;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "KM: " + km +"\nAGE: " + age + "\nTICKET COST: " + calculatePrice(km, age);
    }
}
