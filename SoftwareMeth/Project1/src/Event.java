//@author Hersh and Aarsh
public class Event implements Comparable<Event> {

    public enum Timeslot {
        MORNING, AFTERNOON, EVENING
    }

    private Date date;
    private Timeslot startTime;
    private String location;
    private Contact contact;
    private int duration;


    public Event(Date date, Timeslot startTime, String location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }






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

        int dateComparison = this.date.compareTo(other.date);
        if (dateComparison != 0) {
            return dateComparison;
        }


        return this.startTime.compareTo(other.startTime);
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Checking equals for: " + this + " and " + obj);  // Logging

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Event event = (Event) obj;
        boolean isEqual = this.date.equals(event.date) && startTime == event.startTime && location.equals(event.location);

        System.out.println("Result of equality check: " + isEqual);  // Logging

        return isEqual;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
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

        String endTimeStr = calculateEndTime(startTimeStr);


        Location eventLocation = Location.valueOf(location);
        String locationStr = "@" + eventLocation.getRoomNumber() + " ("
                + eventLocation.getBuilding() + ", "
                + eventLocation.getCampus() + ")";

        return "[Event Date: " + date + "] [Start: " + startTimeStr + "] [End: "
                + endTimeStr + "] " + locationStr + " [Contact: "
                + contact.getDepartment() + ", " + contact.getEmail() + "]";
    }

    private String calculateEndTime(String startTimeStr) {
        int endHour = Integer.parseInt(startTimeStr.split(":")[0]) + this.duration / 60;
        int endMinutes = Integer.parseInt(startTimeStr.split(":")[1].replace("am", "").replace("pm", ""))
                + this.duration % 60;
        // Adjust if minutes exceed 60
        if (endMinutes >= 60) {
            endHour += 1;
            endMinutes -= 60;
        }
        String amPm = startTimeStr.substring(startTimeStr.length() - 2);

        if (endHour >= 12) {
            if (endHour > 12) endHour -= 12;
            amPm = (amPm.equals("am")) ? "pm" : "am";
        }
        return endHour + ":" + String.format("%02d", endMinutes) + amPm;
    }
    public static void main(String[] args) {


        //Valid and Invalid Dates for testing
        Date validDate = new Date(28, 2, 2021);
        Date invalidDate = new Date(30, 2, 2020);

       Timeslot validTime = Timeslot.MORNING;

       //Valid and Invalid Locations
       String validLocation = "HLL114";
       String invalidLocation = "ARC1231";

       //Valid and Invalid Contacts
       Contact validContact = new Contact(Department.CS, "cs@rutgers.edu");
       Contact invalidContact = new Contact(Department.valueOf("PT"), "PT@Rutgers.edu");

       //Valid Event
        Event validEvent = new Event(validDate, validTime, validLocation, validContact, 60);

        //Invalid Date event
        Event invalidEvent1 = new Event(invalidDate, validTime, validLocation, validContact, 60);

        //Invalid Location event
        Event invalidEvent2 = new Event(validDate, validTime, invalidLocation, validContact, 60);

        //Invalid Contact Event
        Event invalidEvent3 = new Event(validDate, validTime, validLocation, invalidContact, 60);

        //Invalid Duration Event
        Event invalidEvent4 = new Event(validDate, validTime, validLocation, validContact, 130);
    }

}
