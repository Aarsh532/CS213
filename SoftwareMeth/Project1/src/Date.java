public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    // Constants for months
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    // Constants for leap year calculation
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
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

    public boolean isValid() {
        if (year <= 0 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int daysInMonth;
        switch (month) {
            case FEBRUARY:
                daysInMonth = isLeapYear() ? 29 : 28;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
                break;
        }

        return day <= daysInMonth;
    }

    public boolean isLeapYear() {
        return (year % QUADRENNIAL == 0 && (year % CENTENNIAL != 0 || year % QUATERCENTENNIAL == 0));
    }

    @Override
    public int compareTo(Date otherDate) {
        if (this.year != otherDate.year) {
            return this.year - otherDate.year;
        }
        if (this.month != otherDate.month) {
            return this.month - otherDate.month;
        }
        return this.day - otherDate.day;
    }

    public static void main(String[] args) {
        // Test cases for Date class
        Date validDate = new Date(2023, JANUARY, 15);
        Date invalidDate = new Date(2023, APRIL, 31);
        Date leapYearDate = new Date(2024, FEBRUARY, 29);
        Date nonLeapYearDate = new Date(2023, FEBRUARY, 29);

        System.out.println("Valid Date: " + validDate.isValid()); // true
        System.out.println("Invalid Date: " + invalidDate.isValid()); // false
        System.out.println("Leap Year Date: " + leapYearDate.isValid()); // true
        System.out.println("Non-Leap Year Date: " + nonLeapYearDate.isValid()); // false
    }
}
