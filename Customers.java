import java.time.LocalDate;

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

    public String randomFirstname(){
        int f = (int) (Math.random()*2);
        return randomNames[f][(int)(Math.random()* randomNames[f].length)].toString();
    }

    public String randomLastname(){
        int l = (int) (2 + Math.random()*2);
        return randomNames[l][(int)(Math.random()* randomNames[l].length)].toString();
    }

    public void setRandomTableData(Statistics statistics, Tickets tickets,Customers customers, Calendar calendar){
        double dailyPrice = 0;
        int randomTicketsPerDay =(int) (Math.random()* tickets.getMaxTicketsPerDay() + 1);
        for (int x = 0; x < statistics.getTable().length; x ++){

            statistics.getTable()[0][x] = LocalDate.now().plusDays(x).format(calendar.getCzDateFormat());

            for (int i = 1; i < randomTicketsPerDay+1;i++){
                int f = (int) (Math.random()*2);
                String randomFirstame = randomNames[f][(int)(Math.random()* randomNames[f].length)].toString();
                customers.setFirstName(randomFirstame);
                int l = (int) (2 + Math.random()*2);
                String randomLastname = randomNames[l][(int)(Math.random()* randomNames[l].length)].toString();
                customers.setLastName(randomLastname);
                int s = (int) (Math.random()*tickets.getOffers()[0].length);
                String randomStatus = tickets.getOffers()[0][s].toString();
                customers.setStatus(randomStatus);
                customers.setPrice(tickets.offerPrice(customers));
                statistics.getTable()[i][x] = firstName + ", " + lastName + ", "+ status+ ", "+ tickets.offerPrice(customers);
                dailyPrice = dailyPrice + customers.getPrice();
            }

            statistics.getTable()[11][x] = randomTicketsPerDay;
            statistics.getTable()[12][x] = dailyPrice;
        }

    }

}
