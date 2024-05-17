public class Tickets {
    private Double ticketPrice;
    private Integer maxTicketsPerDay;

    public Tickets() {
        this.ticketPrice = 10.0;
        this.maxTicketsPerDay = maxTicketsPerDay == null? maxTicketsPerDay = 10:maxTicketsPerDay;
    }

    public Integer getMaxTicketsPerDay() {
        return maxTicketsPerDay;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    private Object [][] offers= {
            {"Invalid", "Student", "Child", "Pensioner", "Normal"},
            { 70,         30,         80,       60,       0}};

    public double offerPrice(Customers customers){
        for(int i = 0; 0<offers.length;i++) {
            if (customers.getStatus().equalsIgnoreCase(offers[0][i].toString())){
                return ticketPrice - (ticketPrice * (int) offers[1][i] / 100);
            }
        }
        return 0.0;
    }

    public Object[][] getOffers() {
        return offers;
    }
}

