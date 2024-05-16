public class Main {


    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Customers customers = new Customers();

        System.out.println(customers.randomFirstname());
        System.out.println(customers.randomLastname(customers.randomFirstname()));

        tickets.setStatus("Invalid");



        System.out.println(tickets.getStatus());
        System.out.println(tickets.getTicketPrice());
        System.out.println(tickets.offerPrice());

        Introductions.welcome();
    }
}
