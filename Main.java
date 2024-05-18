import java.time.LocalDate;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tickets tickets = new Tickets();
        Customers customers = new Customers();
        Calendar calendar = new Calendar();
        Statistics statistics = new Statistics();
        Introductions introductions = new Introductions();

        customers.setRandomTableData(statistics, tickets, calendar);

        introductions.welcome();
        System.out.println(statistics.getTable()[statistics.getPaymentID()][0]);

        boolean exit = false;
        while (!exit){

            System.out.println("1. connect as Customer");
            System.out.println("2. connect as Administrator");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    boolean backToMain = false;
                    while (!backToMain){

                        System.out.println("connected as Customer");
                        System.out.println("1. Add a reservation");
                        System.out.println("2. Payment information's");
                        System.out.println("3. see free Tickets");
                        System.out.println("4. Read about Museum");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Choose an option: ");

                        int customerChois = scanner.nextInt();
                        switch (customerChois){
                            case 1:
                                System.out.println("Reservations");
                                promptEnterKey(scanner);
                                break;
                            case 2:
                                System.out.println("Payment information's");
                                introductions.priceInfo(tickets);
                                promptEnterKey(scanner);
                                break;
                            case 3:
                                System.out.println("see Reservations");
                                statistics.freeTicketsStatistics(calendar, scanner, statistics, tickets);
                                promptEnterKey(scanner);
                                break;
                            case 4:
                                System.out.println("Read about Museum");
                                introductions.about();
                                promptEnterKey(scanner);
                                break;
                            case 5:
                                backToMain = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                case 2:
                    backToMain = false;
                    while (!backToMain) {

                        System.out.println("connected as Administrator");
                        System.out.println("1. Ticket Statistics");
                        System.out.println("2. Customers Statistics");
                        System.out.println("3. Payment Statistics");
                        System.out.println("4. Full Statistics");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Choose an option: ");

                        int administratorChois = scanner.nextInt();
                        switch (administratorChois) {
                            case 1:
                                System.out.println("Ticket Statistics");
                                statistics.ticketStatistics(calendar,customers,scanner,statistics);
                                promptEnterKey(scanner);
                                break;
                            case 2:
                                System.out.println("Customers Statistics");
                                statistics.customerStatistics(calendar, scanner, statistics, tickets);
                                promptEnterKey(scanner);
                                break;
                            case 3:
                                System.out.println("Payment Statistics");
                                statistics.paymentStatistics(calendar,scanner,statistics);
                                promptEnterKey(scanner);
                                break;
                            case 4:
                                backToMain = true;
                                statistics.fullStatistics(calendar, scanner, statistics, tickets);
                                promptEnterKey(scanner);
                                break;
                            case 5:
                                backToMain = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    private static void promptEnterKey(Scanner scanner) {
        System.out.println("Press Enter to go back to the menu...");
        scanner.nextLine(); // Wait for the user to press Enter
    }
}
