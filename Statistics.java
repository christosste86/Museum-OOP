import javax.xml.transform.Source;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Statistics {
    private Object [][] table = new Object[13][365 - LocalDate.now().getDayOfYear()];
    private final int ticketID = 11;
    private final int paymentID = 12;

    public Statistics() {
    }

    public int getTicketID() {
        return ticketID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public Object[][] getTable() {
        return table;
    }

    public void ticketStatistics(Calendar calendar, Customers customers, Scanner scanner, Statistics statistics){
        boolean validDate = false;
        while (!validDate) {
            scanner.nextLine();
            System.out.println("Date format: "+ LocalDate.now().format(calendar.getCzDateFormat()));
            System.out.print("Date from: ");
            String dateFrom = scanner.nextLine();
            System.out.print("Date To: ");
            String dateTo = scanner.nextLine();

                int dateFromID = 0;
                int dateToID = 0;
                int sum = 0;
                for (int i = 0; i<statistics.getTable()[0].length;i++){
                    if (dateFrom.equals(statistics.getTable()[0][i])){
                        dateFromID = i;
                    }if (dateTo.equals(statistics.getTable()[0][i])){
                        dateToID = i+1;
                    }
                }
                for (int i = dateFromID; i < dateToID;i++){
                    System.out.printf("|Date %-3S: %S Tickets", statistics.getTable()[0][i], statistics.getTable()[ticketID][i]);
                    System.out.println();
                    sum += (int) statistics.getTable()[ticketID][i];
                }
            System.out.println(sum);
                validDate = true; // Date is valid

        }
    }



    public void paymentStatistics(Calendar calendar, Scanner scanner, Statistics statistics){
        boolean validDate = false;
        while (!validDate) {
            scanner.nextLine();
            System.out.println("Date format: "+ LocalDate.now().format(calendar.getCzDateFormat()));
            System.out.print("Date from: ");
            String dateFrom = scanner.nextLine();
            System.out.print("Date To: ");
            String dateTo = scanner.nextLine();

            int dateFromID = 0;
            int dateToID = 0;
            double sum = 0;
            for (int i = 0; i<statistics.getTable()[0].length;i++){
                if (dateFrom.equals(statistics.getTable()[0][i])){
                    dateFromID = i;
                }if (dateTo.equals(statistics.getTable()[0][i])){
                    dateToID = i+1;
                }
            }
            for (int i = dateFromID; i < dateToID;i++){
                System.out.printf("|Date %-3S: %S €", statistics.getTable()[0][i], statistics.getTable()[paymentID][i]);
                System.out.println();
                sum += (double) statistics.getTable()[paymentID][i];
            }
            System.out.println(sum + " €");
            validDate = true; // Date is valid

        }
    }
    public void customerStatistics (Calendar calendar, Scanner scanner, Statistics statistics, Tickets tickets){
        boolean validDate = false;
        while (!validDate) {
            scanner.nextLine();
            System.out.println("Date format: "+ LocalDate.now().format(calendar.getCzDateFormat()));
            System.out.print("Date from: ");
            String dateFrom = scanner.nextLine();
            System.out.print("Date To: ");

            String dateTo = scanner.nextLine();
            System.out.println();

            int dateFromID = 0;
            int dateToID = 0;
            for (int i = 0; i<statistics.getTable()[0].length;i++){
                if (dateFrom.equals(statistics.getTable()[0][i])){
                    dateFromID = i;
                }if (dateTo.equals(statistics.getTable()[0][i])){
                    dateToID = i+1;
                }
            }
            for (int i = dateFromID; i < dateToID;i++){
                System.out.printf("|%-40S|", statistics.getTable()[0][i]);
                System.out.println();
                System.out.println("|----------------------------------------|");
                for (int x = 1; x <= tickets.getMaxTicketsPerDay(); x++) {
                    if (statistics.getTable()[x][i] == null){
                        System.out.print("");
                    }else {
                        System.out.printf("|%-40S|", statistics.getTable()[x][i]);
                        System.out.println();
                    }
                }
                System.out.println("|****************************************|");
            }
            validDate = true; // Date is valid

        }
    }
    public void freeTicketsStatistics(Customers customers){
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        while (!validDate) {
            scanner.nextLine();
            try {
                System.out.println("Date format: " + LocalDate.now().format(customers.getCalendar().getCzDateFormat()));
                System.out.print("Date from: ");
                String dateFrom = scanner.nextLine();
                System.out.print("Date To: ");
                String dateTo = scanner.nextLine();

                int dateFromID = 0;
                int dateToID = 0;
                int sum = 0;
                for (int i = 0; i < customers.getStatistics().getTable()[0].length; i++) {
                    if (dateFrom.equals(customers.getStatistics().getTable()[0][i])) {
                        dateFromID = i;
                    }
                    if (dateTo.equals(customers.getStatistics().getTable()[0][i])) {
                        dateToID = i + 1;
                    }
                }
                for (int i = dateFromID; i < dateToID; i++) {
                    System.out.printf("|Date %-3S: %S Tickets", customers.getStatistics().getTable()[0][i], (customers.getTickets().getMaxTicketsPerDay() - (int) customers.getStatistics().getTable()[ticketID][i]));
                    System.out.println();
                }
                validDate = true; // Date is valid
            }catch (Exception e){
                System.out.println("use correct format ");
                validDate = false;
            }
        }
    }

    public void fullStatistics (Calendar calendar, Scanner scanner, Statistics statistics, Tickets tickets){
        boolean validDate = false;
        int ticketSum = 0;
        double paymentSum = 0;
        while (!validDate) {
            scanner.nextLine();
            System.out.println("Date format: "+ LocalDate.now().format(calendar.getCzDateFormat()));
            System.out.print("Date from: ");
            String dateFrom = scanner.nextLine();
            System.out.print("Date To: ");

            String dateTo = scanner.nextLine();
            System.out.println();

            int dateFromID = 0;
            int dateToID = 0;
            for (int i = 0; i<statistics.getTable()[0].length;i++){
                if (dateFrom.equals(statistics.getTable()[0][i])){
                    dateFromID = i;
                }if (dateTo.equals(statistics.getTable()[0][i])){
                    dateToID = i+1;
                }
            }
            for (int i = dateFromID; i < dateToID;i++){
                System.out.printf("|%-40S|", statistics.getTable()[0][i]);
                System.out.println();
                System.out.println("|----------------------------------------|");
                for (int x = 1; x <= tickets.getMaxTicketsPerDay(); x++) {
                    if (statistics.getTable()[x][i] == null){
                        System.out.print("");
                    }else {
                        System.out.printf("|%-40S|", statistics.getTable()[x][i]);
                        System.out.println();
                    }
                }
                System.out.printf("|%-2S %-37S|", statistics.getTable()[ticketID][i],"Tickets");
                System.out.println();
                System.out.printf("|%-6S %-33S|", statistics.getTable()[paymentID][i],"€");
                System.out.println();
                System.out.println("|****************************************|");
                ticketSum += (int) statistics.getTable()[ticketID][i];
                paymentSum += (double) statistics.getTable()[paymentID][i];
            }
            validDate = true; // Date is valid
        }
        System.out.printf("|Period Sold Tickets : %-18S|", ticketSum);
        System.out.println();
        System.out.printf("|Period payment: %-6S %-17S|", paymentSum, "€");
        System.out.println();

    }
}
