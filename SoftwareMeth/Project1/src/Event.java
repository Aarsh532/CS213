public class Event implements Comparable<Event> {
    // Enum for Timeslot
    public enum Timeslot {
        MORNING, AFTERNOON, EVENING
    }

    private Date date; // the event date
    private Timeslot startTime; // the starting time
    private String location;
    private Contact contact; // includes the department name and email
    private int duration; // in minutes

    // Constructor
    public Event(Date date, Timeslot startTime, String location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timeslot getStartTime() {
        return startTime;
    }

    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(Event other) {
        // Compare dates first
        int dateComparison = this.date.compareTo(other.date);
        if (dateComparison != 0) {
            return dateComparison;
        }

        // If dates are the same, compare timeslots
        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;
        return date.equals(event.date) && startTime == event.startTime && location.equals(event.location);
    }

    @Override
    public String toString() {
        String startTimeStr;
        switch (this.startTime) {
            case MORNING:
                startTimeStr = "10:30am";
                break;
            case AFTERNOON:
                startTimeStr = "2:00pm";
                break;
            default: // EVENING
                startTimeStr = "6:30pm";
                break;
        }
        return "[Event Date: " + date + "] [Start: " + startTimeStr + "] [End: "
                + (Integer.parseInt(startTimeStr.split(":")[0]) + this.duration / 60) + ":"
                + (Integer.parseInt(startTimeStr.split(":")[1].replace("am", "").replace("pm", ""))
                + this.duration % 60)
                + startTimeStr.substring(startTimeStr.length() - 2) + "] @" + location + " [Contact: "
                + contact.getDepartment() + ", " + contact.getEmail() + "]";
    }
}
