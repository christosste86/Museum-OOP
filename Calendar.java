import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calendar {
    private DateTimeFormatter czDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Calendar() {
    }

    public DateTimeFormatter getCzDateFormat() {
        return czDateFormat;
    }
}
