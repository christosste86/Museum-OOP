public class Customers {
    String firstName;
    String lastName;
    String status;

    String [][] randomNames = {
            {"Eliška", "Tereza", "Adéla", "Anna", "Natálie"},
            {"Novákova", "Svobodova", "Novotna", "Dvořákova", "Černa"},
            {"Jakub", "Jan", "Tomáš", "Adam", "Matyáš"},
            {"Novák", "Svoboda", "Novotný", "Dvořák", "Černý"}
    };

    public Customers() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
