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

        customers.setRandomTableData(statistics, tickets, customers, calendar);

        introductions.welcome();


        System.out.println("1. connect as Customer");
        System.out.println("2. connect as Administrator");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        boolean exit = false;
        while (!exit){
            int mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    System.out.println("connected as Customer");
                    System.out.println("1. Add a reservation");
                    System.out.println("2. Payment information's");
                    System.out.println("3. see Reservations");
                    System.out.println("4. Read about Museum");
                    System.out.println("5. Back to Main Menu");
                    System.out.print("Choose an option: ");

                    boolean backToMain = false;
                    while (!backToMain){
                        int customerChois = scanner.nextInt();
                        switch (customerChois){
                            case 1:
                                System.out.println("Reservations");
                                break;
                            case 2:
                                System.out.println("Payment information's");
                                introductions.priceInfo(tickets);
                                break;
                            case 3:
                                System.out.println("see Reservations");
                                break;
                            case 4:
                                System.out.println("Read about Museum");
                                introductions.about();
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
                    System.out.println("connected as Administrator");
                    System.out.println("1. Ticket Statistics");
                    System.out.println("2. Customers Statistics");
                    System.out.println("3. Price Statistics");
                    System.out.println("4. Back to Main Menu");
                    System.out.print("Choose an option: ");
                    backToMain = false;
                    while (!backToMain) {
                        int administratorChois = scanner.nextInt();
                        switch (administratorChois) {
                            case 1:
                                System.out.println("Ticket Statistics");
                                break;
                            case 2:
                                System.out.println("Customers Statistics");
                                break;
                            case 3:
                                System.out.println("Price Statistics");
                                break;
                            case 4:
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
    }
}
