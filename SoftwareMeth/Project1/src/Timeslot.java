public enum Timeslot {
    MORNING("10:30am"),
    AFTERNOON("2:00pm"),
    EVENING("6:30pm");

    private String time;

    Timeslot(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}