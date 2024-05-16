public class Main {


    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        tickets.setStatus("Invalid");


        System.out.println(tickets.getStatus());
        System.out.println(tickets.getTicketPrice());
        System.out.println(tickets.offerPrice());

        Introductions.welcome();
    }
}
