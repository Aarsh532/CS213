import java.util.Date;

public class Event implements Comparable<Event> {
    private Date date;             // Event date
    private Timeslot startTime;    // Starting time
    private Location location;     // Event location
    private Contact contact;       // Event contact
    private int duration;          // Event duration in minutes

    public enum Timeslot{
        morning(10, 30),
        afternoon(2,0),
        evening(6,30);

        private int hour;
        private int minute;
        Timeslot(int hour, int minute){
            this.hour = hour;
            this.minute = minute;
        }
    }

    public enum Location{
        HILL114 ("Hill Center", "Busch"),
        ARC103 ("Allison Road", "Classroom, Busch"),
        BE_AUD ("Beck Hall", "Livingston"),
        TIL232 ("Tillett Hall", "Livingston"),
        AB2225 ("Academic Building", "College Avenue"),
        MU302 ("Murray Hall", "College Avenue");

        private final String buildingName;
        private final String campus;

        Location(String buildingName, String campus){
            this.buildingName = buildingName;
            this.campus = campus;
        }

    }
    // Constructor
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    // Getters and Setters for instance variables

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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
    public int compareTo(Event otherEvent) {
        // Compare events based on date and then startTime if dates are the same
        int dateComparison = this.date.compareTo(otherEvent.date);
        if (dateComparison != 0) {
            return dateComparison;
        } else {
            return this.startTime.compareTo(otherEvent.startTime);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event otherEvent = (Event) obj;
        return date.equals(otherEvent.date) && startTime.equals(otherEvent.startTime) && location.equals(otherEvent.location);
    }


    @Override
    public String toString() {
        return "[Event Date: " + date.toString() + "] [Start: " + startTime.toString() + "] [End: " + calculateEndTime().toString() + "] @" + location.toString() + " [Contact: " + contact.toString() + "]";
    }

    // Helper method to calculate end time based on duration
    private Timeslot calculateEndTime() {
        // Add duration minutes to the start time to get the end time
        int endHour = startTime.getHour();
        int endMinute = startTime.getMinute() + duration;
        if (endMinute >= 60) {
            endHour += endMinute / 60;
            endMinute %= 60;
        }
        return new Timeslot(endHour, endMinute);
    }
}
