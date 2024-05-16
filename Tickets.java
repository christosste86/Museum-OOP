public class Tickets {
    private Double ticketPrice;
    private int maxTicketsPerDay;
    private String status;

    public Tickets() {
        this.ticketPrice = 10.0;
        this.status = status == null? status = "Normal": status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    private Object [][] offers= {
            {"Invalid", "Student", "Child", "Pensioner", "Normal"},
            { 70,         30,         80,       60,       0}};

    public double offerPrice(){
        for(int i = 0; 0<offers.length;i++) {
            if (status.equalsIgnoreCase(offers[0][i].toString())){
                return ticketPrice - (ticketPrice * (int) offers[1][i] / 100);
            }
        }
        return ticketPrice;
    }

    public Object[][] getOffers() {
        return offers;
    }
}

