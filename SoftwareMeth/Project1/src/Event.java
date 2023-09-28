import java.util.Calendar;
public class Event{
    private Date date;
    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    public enum Timeslot{
        morning,
        afternoon,
        evening,
    }

    public enum Location{
        HILL114,
        ARC103,
        BE_AUD,
        TIL232,
        AB2225,
        MU302
    }
    public void setInfo(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
}

