public class Customers {
    private String firstName;
    private String lastName;
    private String status;

    String [][] randomNames = {
            {"Eliška", "Tereza", "Adéla", "Anna", "Natálie"},
            {"Jakub", "Jan", "Tomáš", "Adam", "Matyáš"},
            {"Novákova", "Svobodova", "Novotna", "Dvořákova", "Černa"},
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

    public String randomFirstname(){
        int i = (int) (Math.random()*2);
        return randomNames[i][(int)(Math.random()* randomNames[i].length)].toString();
    }

    public String randomLastname(String randomFirstname){
        int len = 0;
        for (int i = 0; i < 1; i++){
            for (int x = 0; x< randomNames[i].length; x++){
                if (randomFirstname.equals(randomNames[i][x])){
                    if (i == 0){
                        len = 2;
                    }if (i == 1){
                        len = 3;
                    }
                }
            }
        }
        int surnameID = (int) (Math.random() * randomNames[len].length);
        return randomNames[len][surnameID];
    }

}
