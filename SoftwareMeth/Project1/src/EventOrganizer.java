import java.util.Scanner;


public class EventOrganizer {
    public Object run;

    public <String> void run(){
        Scanner scanner = new Scanner(System.in);
        EventCalendar calendar = new EventCalendar();

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
                Date date = new Date(Integer.parseInt(days[2]),Integer.parseInt(days[0]), Integer.parseInt(days[1]));
                if(!date.isValid()){System.out.println(token[1] + "Invalid Calender Date");}
                Contact.Department department = Contact.Department.valueOf(token[4]);
                Contact contact = new Contact(department, token[5]);
                Event.Timeslot timeslot = Event.Timeslot.valueOf(token[2]);
                Event.Location location = Event.Location.valueOf(token[3]);
                Event event = new Event(date, timeslot, location, contact, Integer.parseInt(token[6]));
                calendar.add(event);
            }
            else if(action.equals("R")){
            }
            else if(action.equals("P")){
                calendar.print(); }
            else if(action.equals("PE")){
                calendar.printByDate(); }
            else if(action.equals("PC")){
                calendar.printByCampus(); }
            else if(action.equals("PD")){
                calendar.printByDepartment(); }
            else if(action.equals("Q")){
                System.out.println("Event Organizer Terminated");
                run = false; }
            else{
                System.out.println(token[0] + " is an invalid command"); }
        }
    }
}
