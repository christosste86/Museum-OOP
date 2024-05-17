public class Introductions {
    public Introductions() {
    }

    public void welcome() {
        System.out.println("**********************************************");
        System.out.println("Welcome to Mendel Museum of Masaryk University");
        System.out.println("**********************************************");
    }

    public void priceInfo (Tickets tickets) {
        System.out.println("**********************************************");
        System.out.println("Ticket Price : " + tickets.getTicketPrice() + "€" );
        for (int i = 0; i<tickets.getOffers()[0].length - 1;i++){
            System.out.println("Price for "+tickets.getOffers()[0][i] + ": "+ (double) ((int) tickets.getTicketPrice() - ((int) tickets.getTicketPrice() * (int) tickets.getOffers()[1][i])/100) + "€");
        }
        System.out.println("**********************************************");
    }

    public void about() {
        System.out.println("**********************************************");
        System.out.println("The Mendel Museum of Masaryk University builds\n" +
                        "on the legacy of G. J. Mendel. It is a meeting\n" +
                        "place for experts and a centre for presenting\n" +
                        "the findings of science and research to the\n" +
                        "broader public. Besides maintaining an\n" +
                        "exhibition about G. J. Mendel, the museum also\n" +
                        "organises numerous lectures, primarily on genetics\n" +
                        "but also on other disciplines taught at Masaryk\n" +
                        "University.");
        System.out.println("**********************************************");
    }
}
