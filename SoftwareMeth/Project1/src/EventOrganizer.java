import java.util.Scanner;

public class EventOrganizer {
    public Object run;

    public <String> void run(){
        Scanner input = new Scanner(System.in);
        EventCalender Calender = new EventCalender();
        java.lang.String action;
        Date date = new Date();
        boolean run = true;
        while(run){
            action = input.nextLine();
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
