import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Customers customers = new Customers();
        Calendar limitDates = new Calendar();
        Statistics statistics = new Statistics();

        statistics.setDatesToTable();

        for(int i =0; i<statistics.getTable()[0].length;i++){
            System.out.println(statistics.getTable()[0][i]);
        }

        System.out.println(customers.randomFirstname());
        System.out.println(customers.randomLastname(customers.randomFirstname()));

        tickets.setStatus("Invalid");
        System.out.println(limitDates.limitDates());



        System.out.println(tickets.getStatus());
        System.out.println(tickets.getTicketPrice());
        System.out.println(tickets.offerPrice());

        Introductions.welcome();
    }
    static void setData(Object [][] table, int limitDates){
        for (int i = 0; i<limitDates;i++){
            table[0][i] = LocalDate.now().plusDays(i).toString();
        }
    }

}
