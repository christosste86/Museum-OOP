import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Customers customers = new Customers();
        Calendar calendar = new Calendar();
        Statistics statistics = new Statistics();
        Introductions introductions = new Introductions();

        introductions.welcome();


        customers.setRandomTableData(statistics, tickets, customers, calendar);


        for(int i =0; i<statistics.getTable().length;i++){
            System.out.println(statistics.getTable()[i][2]);
        }
    }
}
