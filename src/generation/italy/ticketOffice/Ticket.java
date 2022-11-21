package generation.italy.ticketOffice;

// import java.math.BigDecimal;
import java.time.LocalDate;

public class Ticket {
    private int km;
    private int age;
    private boolean flexible;
    private LocalDate date;

    final private double Km_Cost = 0.21;
    final private double Discount_Over_65 = 40;
    final private double Discount_For_Minors = 20;
    final private int Normal_Duration = 30;
    final private int Flexible_Duration = 90;

    private double ticketCost = 0;


    public Ticket(int km, int age, boolean flexible) throws Exception{
        setKm(km);
        setAge(age);
        setFlexible(flexible);
        ticketCost = calculatePrice(km, age, flexible);
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

    public boolean isFlexible() {
        return flexible;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

    public LocalDate getData() {
        return date;
    }

    public void setData(LocalDate date) {
        this.date = date;
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

    public double calculatePrice(int km, int age , Boolean flexible){
            if (flexible) {
                ticketCost = (km * Km_Cost) - ((km * Km_Cost)*calculateDiscount(age))/100;
                ticketCost += (ticketCost * 10)/100;
                return ticketCost;
            }else{
                ticketCost = (km * Km_Cost) - ((km * Km_Cost)*calculateDiscount(age))/100;
                return ticketCost;
            }
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

    public LocalDate calculateDueDate(boolean flexible, int km, int age){
        if (flexible) {
            return this.date.now().plusDays(Flexible_Duration);
        } else {
            return this.date.now().plusDays(Normal_Duration);
        }
    }

    @Override
    public String toString() {
        return "KM: " + km +"\nAGE: " + age + "\nTICKET COST: " + 
        calculatePrice(km, age, flexible) + "\nEXPIRATION DATE: " + calculateDueDate(flexible, km, age);
    }
}
