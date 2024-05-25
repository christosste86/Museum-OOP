import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Customers {
    private String firstName;
    private String lastName;
    private String status;
    private double price;
    private Tickets tickets;
    private Calendar calendar = new Calendar();
    private Statistics statistics = new Statistics();

    String [][] randomNames = {
            {"Eliška", "Tereza", "Adéla", "Anna", "Natálie"},
            {"Jakub", "Jan", "Tomáš", "Adam", "Matyáš"},
            {"Novákova", "Svobodova", "Novotna", "Dvořákova", "Černa"},
            {"Novák", "Svoboda", "Novotný", "Dvořák", "Černý"}
    };

    public Customers() {
        this.status = status == null?status = "normal": status;
        this.tickets = new Tickets();
    }

    public String getFirstName() {
        return firstName;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRandomTableData(){
        double dailyPrice = 0;

        for (int x = 0; x < statistics.getTable().length; x ++){
            int randomTicketsPerDay =(int) (Math.random()* tickets.getMaxTicketsPerDay() + 1);
            statistics.getTable()[0][x] = LocalDate.now().plusDays(x).format(calendar.getCzDateFormat());

            for (int i = 1; i < randomTicketsPerDay+1;i++){
                int f = (int) (Math.random()*2);
                String randomFirstame = randomNames[f][(int)(Math.random()* randomNames[f].length)].toString();
                setFirstName(randomFirstame);
                int lastnameID = 0;
                for (int z = 0; z < randomNames[0].length;z++){
                    if (getFirstName().equals(randomNames[0][z])){
                        lastnameID = 2;
                    }
                }
                for (int z = 0; z < randomNames[1].length;z++){
                    if (getFirstName().equals(randomNames[1][z])){
                        lastnameID = 3;
                    }
                }


                String randomLastname = randomNames[lastnameID][(int)(Math.random()* randomNames[lastnameID].length)].toString();
                setLastName(randomLastname);
                int s = (int) (Math.random()*tickets.getOffers()[0].length);
                String randomStatus = tickets.getOffers()[0][s].toString();
                setStatus(randomStatus);
                setPrice(tickets.offerPrice(this));
                statistics.getTable()[i][x] = firstName + ", " + lastName + ", "+ status+ ", "+ tickets.offerPrice(this)+" €";
                dailyPrice += getPrice();
            }

            statistics.getTable()[statistics.getTicketID()][x] = randomTicketsPerDay;
            statistics.getTable()[statistics.getPaymentID()][x] = dailyPrice;
        }

    }

    public void addReservation(Scanner scanner, Statistics statistics, Tickets tickets){
        String dateReservation = scanner.nextLine();
        int reservationDateID = 0;
        for (int i = 0; i < statistics.getTable()[0].length; i++){
            if (dateReservation.equals(statistics.getTable()[0][i])){
                reservationDateID = i;
            }
        }
        int numOfTicketsToReservation = scanner.nextInt();
        if (numOfTicketsToReservation <= tickets.getMaxTicketsPerDay() - (int) statistics.getTable()[statistics.getTicketID()][reservationDateID]){
            for (int i = freePositionInDate(statistics, statistics.getTicketID()); i < tickets.getMaxTicketsPerDay(); i++){
                System.out.print("Firstname: ");
                setFirstName(scanner.nextLine());
                System.out.print("Lastname: ");
                setLastName(scanner.nextLine());
                System.out.print("Set your status -> ");
                for(Object element: tickets.getOffers()[0] ){
                    System.out.print(", " + element);
                }
                System.out.print(" <--");
                String status = scanner.nextLine();

                for(Object element: tickets.getOffers()[0] ){
                    if(status.equalsIgnoreCase(element.toString())){
                        setStatus(status);

                    }
                }
            }
        }
    }
    static int freePositionInDate(Statistics statistics, int reservationDateID){
        int freePosition = 0;
        for (int i = 0; i < statistics.getTable().length;i++){

            if (statistics.getTable()[i][reservationDateID] == null){
                freePosition = i;
                return freePosition;
            }
        }
        return freePosition;
    }
    static LocalDate printCorrectLocalDate(Scanner scanner, DateTimeFormatter dateFormat){
        boolean check = false;
        String inputDate = "";
        LocalDate localDate = LocalDate.now();
        while (check == false){
            inputDate = scanner.nextLine();
            try{
                localDate = LocalDate.parse(inputDate, dateFormat);
                check = true;
                return localDate;
            }catch (Exception e){
                check = false;
            }
        }
        return localDate;
    }

}
