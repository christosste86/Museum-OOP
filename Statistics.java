import java.time.LocalDate;

public class Statistics {
    private Object [][] table = new Object[12][365 - LocalDate.now().getDayOfYear()];

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

    public void setDatesToTable(){
        for (int i = 0;i< table[0].length;i++){
            table[0][i] = LocalDate.now().plusDays(i).toString();
        }
    }
}
