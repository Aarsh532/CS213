import java.sql.Time;
import java.text.DecimalFormat;

public class Event {
    private Date date;
    private Timeslot timeslot;
    private Location location;
    private Contact contact;
    private int duration;

    public Event(Date date, Timeslot timeslot, Location location, Contact contact, int duration) {
        this.date = date;
        this.timeslot = timeslot;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    public boolean equals(Event otherEvent) {
        return date.compareTo(otherEvent.date) == 0 &&
                timeslot == otherEvent.timeslot &&
                location == otherEvent.location &&
                contact.isValid() && contact.equals(otherEvent.contact) &&
                duration == otherEvent.duration;
    }

    public int compareTo(Event otherEvent) {
        if (date.compareTo(otherEvent.date) != 0) {
            return date.compareTo(otherEvent.date);
        }

        return timeslot.compareTo(otherEvent.timeslot);
    }

    public String toString() {
        DecimalFormat durationFormat = new DecimalFormat("00");
        String formattedDuration = durationFormat.format(duration);

        return "[Event Date: " + date.toString() + "] [Start: " + timeslot.toString() +
                "] [End: " + timeslot.getEndTimeslot().toString() + "] @" +
                location.toString() + " (" + location.getLocationName() + ") [Contact: " +
                contact.getDepartment().toString() + ", " + contact.getEmail() + "]";
    }

    public Location getLocation() {
        return this.location;
    }

    public Contact getContact() {
        return this.getContact();
    }

    public Date getDate() {
        return this.date;
    }

    public Timeslot getStartTime() {
        return this.timeslot;
    }
}
