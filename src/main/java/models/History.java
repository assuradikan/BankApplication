package main.java.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History implements Comparable<History>{
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
    private LocalDateTime date;
    private String log;

    public History(LocalDateTime date, String log) {
        this.date = date;
        this.log = log;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                "%s%n", this.date, this.log);
    }

    @Override
    public int compareTo(History o) {
        if (this.date.isAfter(o.date)) return -1;
        else if (this.date.isBefore(o.date)) return 1;
        else return 0;
    }


}
