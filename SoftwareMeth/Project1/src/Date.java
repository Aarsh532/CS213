import java.util.Calendar;
public class Date {
    private int year;
    private int month;
    private int day;
    public static final int MONTH_ADDITIVE = 1;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};
    public static final int FEBRUARY = 2;
    public static final int LEAP_YEAR_DAY = 29;
    public static final int LOWEST_DAY = 1;
    public static final int EQUAL = 0;
    public Date(int year, int month, int day){
        this.year = year;
        this.day = day;
        this.month = month;
    }


    public boolean isValid(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + MONTH_ADDITIVE;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (this.month > 12 || this.month < 1) {
            return false;
        }

        if (this.month == FEBRUARY && isLeapYear() == true) {
            if (this.day > LEAP_YEAR_DAY || this.day < LOWEST_DAY) {
                return false;
            }
        } else if (this.day > MONTH_DAYS[this.month - MONTH_ADDITIVE] ||
                this.day < LOWEST_DAY) {
            return false;
        }

        if(this.year > year && this.month > month && this.day > day ||
                this.year < EQUAL){
            return false;
        }
        return true;
    }
    private boolean isLeapYear() {

        if (this.year % QUADRENNIAL == EQUAL) {
            if (this.year % CENTENNIAL == EQUAL) {
                if (this.year % QUATERCENTENNIAL == EQUAL) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int compareTo(Date date) {
        return 1;
    }
}
