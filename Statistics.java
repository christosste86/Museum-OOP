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
                        dateToID = i;
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
                    dateToID = i;
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
            //String dateFrom = scanner.nextLine();
            String dateFrom = "25.05.2024";
            System.out.print("Date To: ");

            //String dateTo = scanner.nextLine();
            String dateTo = "28.05.2024";
            System.out.println();

            int dateFromID = 0;
            int dateToID = 0;
            for (int i = 0; i<statistics.getTable()[0].length;i++){
                if (dateFrom.equals(statistics.getTable()[0][i])){
                    dateFromID = i;
                }if (dateTo.equals(statistics.getTable()[0][i])){
                    dateToID = i;
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
    public void freeTicketsStatistics(Calendar calendar, Scanner scanner, Statistics statistics, Tickets tickets){
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
                    dateToID = i;
                }
            }
            for (int i = dateFromID; i < dateToID;i++){
                System.out.printf("|Date %-3S: %S Tickets", statistics.getTable()[0][i], (tickets.getMaxTicketsPerDay() - (int) statistics.getTable()[ticketID][i]));
                System.out.println();
            }
            validDate = true; // Date is valid

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
            //String dateFrom = scanner.nextLine();
            String dateFrom = "25.05.2024";
            System.out.print("Date To: ");

            //String dateTo = scanner.nextLine();
            String dateTo = "28.05.2024";
            System.out.println();

            int dateFromID = 0;
            int dateToID = 0;
            for (int i = 0; i<statistics.getTable()[0].length;i++){
                if (dateFrom.equals(statistics.getTable()[0][i])){
                    dateFromID = i;
                }if (dateTo.equals(statistics.getTable()[0][i])){
                    dateToID = i;
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
            System.out.printf("|Period Sold Tickets : %-18S|", ticketSum);
            System.out.println();
            System.out.printf("|Period payment: %-6S %-17S|", paymentSum, "€");
            System.out.println();
            validDate = true; // Date is valid

        }
    }
}
