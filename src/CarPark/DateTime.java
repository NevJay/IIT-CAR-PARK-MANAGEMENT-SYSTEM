package CarPark;

public class DateTime {
    private int year;
    private int month;
    private int day;
    private String hour;
    private String minutes;

    public DateTime(int year, int month, int day, String hour, String minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour='" + hour + '\'' +
                ", minutes='" + minutes + '\'' +
                '}';
    }
}
