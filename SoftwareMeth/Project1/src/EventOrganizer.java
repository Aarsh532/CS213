import java.util.Scanner;


public class EventOrganizer {
    public Object run;

    public <String> void run(){
        Scanner scanner = new Scanner(System.in);
        EventCalender Calender = new EventCalender();
        Date date = new Date();
        Event event = new Event();
        int year = 0;
        int month = 0;
        int day = 0;

        java.lang.String action = (java.lang.String) " ";
        boolean run = true;
        while(run){
            java.lang.String Line = scanner.nextLine();
            java.lang.String[] token = Line.split(" ");
            action = token[0];



            if(action.equals("A")){
                java.lang.String[] days = token[1].split("/");
                date.setDate(Integer.parseInt(days[2]),Integer.parseInt(days[0]), Integer.parseInt(days[1]));
                if(!date.isValid()){System.out.println(token[1] + "Invalid Calender Date");}



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
