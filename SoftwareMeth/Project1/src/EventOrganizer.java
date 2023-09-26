import java.util.Scanner;


public class EventOrganizer {
    public Object run;

    public <String> void run(){
        Scanner scanner = new Scanner(System.in);
        EventCalender Calender = new EventCalender();


        java.lang.String action = (java.lang.String) " ";
        boolean run = true;
        while(run){
            java.lang.String Line = scanner.next();
            java.lang.String[] token = Line.split(" ");
            action = token[0];

            if(action.equals("A")){
                Date date = new Date(
                );
                Event event = new Event(
                );
                System.out.println("Add Event");
            }
            else if(action.equals("R")){

            }
            else if(action.equals("PE")){

            }
            else if(action.equals("PC")){

            }
            else if(action.equals("PD")){

            }
            else if(action.equals("Q")){
                System.out.println("Event Organizer Terminated");
                run = false;
            }
        }
    }
}
