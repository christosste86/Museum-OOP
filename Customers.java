import java.time.LocalDate;
import java.util.Scanner;

public class Customers {
    private String firstName;
    private String lastName;
    private String status;
    private double price;

    String [][] randomNames = {
            {"Eliška", "Tereza", "Adéla", "Anna", "Natálie"},
            {"Jakub", "Jan", "Tomáš", "Adam", "Matyáš"},
            {"Novákova", "Svobodova", "Novotna", "Dvořákova", "Černa"},
            {"Novák", "Svoboda", "Novotný", "Dvořák", "Černý"}
    };

    public Customers() {
        this.status = status == null?status = "normal": status;
    }

    public String getFirstName() {
        return firstName;
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

    public void setRandomTableData(Statistics statistics, Tickets tickets,Customers customers, Calendar calendar){
        double dailyPrice = 0;

        for (int x = 0; x < statistics.getTable().length; x ++){
            int randomTicketsPerDay =(int) (Math.random()* tickets.getMaxTicketsPerDay() + 1);
            statistics.getTable()[0][x] = LocalDate.now().plusDays(x).format(calendar.getCzDateFormat());

            for (int i = 1; i < randomTicketsPerDay+1;i++){
                int f = (int) (Math.random()*2);
                String randomFirstame = randomNames[f][(int)(Math.random()* randomNames[f].length)].toString();
                customers.setFirstName(randomFirstame);
                int lastnameID = 0;
                for (int z = 0; z < customers.randomNames[0].length;z++){
                    if (customers.getFirstName().equals(customers.randomNames[0][z])){
                        lastnameID = 2;
                    }
                }
                for (int z = 0; z < customers.randomNames[1].length;z++){
                    if (customers.getFirstName().equals(customers.randomNames[1][z])){
                        lastnameID = 3;
                    }
                }


                String randomLastname = randomNames[lastnameID][(int)(Math.random()* randomNames[lastnameID].length)].toString();
                customers.setLastName(randomLastname);
                int s = (int) (Math.random()*tickets.getOffers()[0].length);
                String randomStatus = tickets.getOffers()[0][s].toString();
                customers.setStatus(randomStatus);
                customers.setPrice(tickets.offerPrice(customers));
                statistics.getTable()[i][x] = firstName + ", " + lastName + ", "+ status+ ", "+ tickets.offerPrice(customers);
                dailyPrice += customers.getPrice();
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

}
