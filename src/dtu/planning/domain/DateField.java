package dtu.planning.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateField {
    final LocalDate dateStart;
    final LocalDate dateEnd;

    public DateField(String dateStart, String dateEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateStart = LocalDate.parse(dateStart, formatter);
        this.dateEnd = LocalDate.parse(dateEnd, formatter);
    }
}
