import java.time.LocalDate;

public class Statistics {
    private Object [][] table = new Object[13][365 - LocalDate.now().getDayOfYear()];

    public Statistics() {
    }

    public Object[][] getTable() {
        return table;
    }


    public void setTable(Object[][] table) {
        this.table = table;
    }

    public void CustomersInfo(){

    }


}
