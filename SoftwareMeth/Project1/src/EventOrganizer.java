//@author Hersh and Aarsh
import java.util.Scanner;
import java.util.StringTokenizer;
public class EventOrganizer {

    private EventCalendar calendar;

    public EventOrganizer() {
        calendar = new EventCalendar();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Event Organizer running....");

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equals("Q")) {
                break;
            }

            processCommand(input);
        }

        System.out.println("Event Organizer terminated.");
    }

    private void processCommand(String input) {
        String[] tokens = input.split(" ");
        String command = tokens[0];

        switch (command) {
            case "A":
                addEvent(tokens);
                break;
            case "R":
                removeEvent(tokens);
                break;
            case "P":
                if (calendar.isEmpty()) {
                    System.out.println("Calendar is empty.");
                } else {
                    calendar.print();
                }
                break;
            case "PE":
                if (calendar.isEmpty()) {
                    System.out.println("Calendar is empty.");
                } else {
                    calendar.printByDate();
                    break;
                }
            case "PC":
                if (calendar.isEmpty()) {
                    System.out.println("Calendar is empty.");
                } else {
                    calendar.printByCampus();
                }
                break;
            case "PD":
                if (calendar.isEmpty()) {
                    System.out.println("Calendar is empty.");
                } else {
                    calendar.printByDepartment();
                }
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private void addEvent(String[] tokens) {
        StringTokenizer st = new StringTokenizer(String.join(" ", tokens));

        st.nextToken();

        String[] dateTokens = st.nextToken().split("/");
        if (dateTokens.length != 3) {
            System.out.println("Invalid date format.");
            return;
        }
        int month = Integer.parseInt(dateTokens[0]);
        int day = Integer.parseInt(dateTokens[1]);
        int year = Integer.parseInt(dateTokens[2]);

        Date eventDate = new Date(day, month, year);
        if (!eventDate.isValid()) {
            System.out.println("Invalid date.");
            return;
        }

        String timeslotString = st.nextToken().toLowerCase();
        Event.Timeslot timeslot;
        switch (timeslotString) {
            case "morning":
                timeslot = Event.Timeslot.MORNING;
                break;
            case "afternoon":
                timeslot = Event.Timeslot.AFTERNOON;
                break;
            case "evening":
                timeslot = Event.Timeslot.EVENING;
                break;
            default:
                System.out.println("Invalid timeslot.");
                return;
        }

        String location = st.nextToken().toUpperCase();
        Location locEnum;
        try {
            locEnum = Location.valueOf(location);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid location.");
            return;
        }


        String departmentString = st.nextToken().toUpperCase();
        Department deptEnum;
        try {
            deptEnum = Department.valueOf(departmentString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid department.");
            return;
        }

        String email = st.nextToken().toLowerCase();
        if (!email.endsWith("@rutgers.edu")) {
            System.out.println("Invalid email address.");
            return;
        }

        int duration = Integer.parseInt(st.nextToken());
        if (duration < 30 || duration > 120) {
            System.out.println("Invalid duration.");
            return;
        }

        Contact contact = new Contact(deptEnum, email);
        Event event = new Event(eventDate, timeslot, location, contact, duration);
        calendar.addEvent(event);
        boolean isAdded = calendar.addEventSUC(event);
        if (isAdded) {
            System.out.println("Event Added");
        } else{
            System.out.println("Event could not be Added");
        }
    }


    private void removeEvent(String[] tokens) {
        if (tokens.length != 4) {
            System.out.println("Invalid data tokens for the 'R' command.");
            return;
        }


        String[] dateTokens = tokens[1].split("/");
        if (dateTokens.length != 3) {
            System.out.println("Invalid date format.");
            return;
        }
        int month = Integer.parseInt(dateTokens[0]);
        int day = Integer.parseInt(dateTokens[1]);
        int year = Integer.parseInt(dateTokens[2]);

        Date eventDate = new Date(day, month, year);

        String timeslotString = tokens[2].toLowerCase();
        Event.Timeslot timeslot;
        switch (timeslotString) {
            case "morning":
                timeslot = Event.Timeslot.MORNING;
                break;
            case "afternoon":
                timeslot = Event.Timeslot.AFTERNOON;
                break;
            case "evening":
                timeslot = Event.Timeslot.EVENING;
                break;
            default:
                System.out.println("Invalid timeslot.");
                return;
        }

        String location = tokens[3].toUpperCase();
        Location locEnum;
        try {
            locEnum = Location.valueOf(location);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid location.");
            return;
        }

        boolean isRemoved = calendar.removeEvent(eventDate, timeslot, location);
        if (isRemoved) {
            System.out.println("Event removed.");
        } else {
            System.out.println("Event not found.");
        }
    }
}
