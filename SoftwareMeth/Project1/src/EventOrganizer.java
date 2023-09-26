import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;
public class EventOrganizer {
    public Object run;

    public void run(){
        Scanner input = new Scanner(System.in);
        EventCalender Calender = new EventCalender();
        String action;
        Date date = new Date();
        boolean run = true;
        while(run){
            action = input.next();

            if(action == "A"){
                System.out.println("Add Event");

            }
            else if(action == "Q"){
                System.out.println("Event Organizer Terminated");
                run = false;
            }
        }
    }
}
