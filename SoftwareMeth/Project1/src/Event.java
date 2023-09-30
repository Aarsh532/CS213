import java.util.Calendar;
public class Event{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

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
    public void setInfo(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
}

