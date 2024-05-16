import java.time.LocalDate;

public class Calendar {
    private int limitDates;

    public int limitDates(){
        int toTheEndOfYear = 365 - LocalDate.now().getDayOfYear();
        return toTheEndOfYear;
    }
}
