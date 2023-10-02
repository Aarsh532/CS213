//@author Hersh and Aarsh
public enum Timeslot {
    MORNING(10, 30),       // 10:30am
    AFTERNOON(14, 0),     // 2:00pm
    EVENING(18, 30);      // 6:30pm

    private int hour;
    private int minute;


    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }


    public int getHour() {
        return hour;
    }


    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
