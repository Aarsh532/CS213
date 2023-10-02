public enum Timeslot {
    MORNING(10, 30),       // 10:30am
    AFTERNOON(14, 0),     // 2:00pm
    EVENING(18, 30);      // 6:30pm

    private int hour;   // hour in 24-hour format
    private int minute;

    // Constructor
    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    // Getter for hour
    public int getHour() {
        return hour;
    }

    // Getter for minute
    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
