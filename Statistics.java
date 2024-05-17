import javax.xml.transform.Source;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Statistics {
    private Object [][] table = new Object[13][365 - LocalDate.now().getDayOfYear()];

    public Statistics() {
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
                    System.out.printf("|Date %-3S: %S Tickets", statistics.getTable()[0][i], statistics.getTable()[11][i]);
                    System.out.println();
                    sum += (int) statistics.getTable()[11][i];
                }
            System.out.println(sum);
                validDate = true; // Date is valid

        }
    }

    public void paymentStatistics(Calendar calendar, Customers customers, Scanner scanner, Statistics statistics){
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
                System.out.printf("|Date %-3S: %S €", statistics.getTable()[0][i], statistics.getTable()[12][i]);
                System.out.println();
                sum += (double) statistics.getTable()[12][i];
            }
            System.out.println(sum + " €");
            validDate = true; // Date is valid

        }
    }
}
