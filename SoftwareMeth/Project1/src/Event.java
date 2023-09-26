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
    public void setDate(Date date){
        this.date = date;
    }

    public void setStartTime(Timeslot startTime){
        this.startTime = startTime;
    }
}

