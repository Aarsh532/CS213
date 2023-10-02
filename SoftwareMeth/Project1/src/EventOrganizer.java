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

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            processCommand(input);
        }

        System.out.println("Event Organizer terminated.");
    }

    private void processCommand(String input) {
        String[] tokens = input.split(" ");
        String command = tokens[0].toUpperCase();

        switch (command) {
            case "A":
                addEvent(tokens);
                break;
            case "R":
                removeEvent(tokens);
                break;
            case "P":
                calendar.print();
                break;
            case "PE":
                calendar.printByDate();
                break;
            case "PC":
                calendar.printByCampus();
                break;
            case "PD":
                calendar.printByDepartment();
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private void addEvent(String[] tokens) {
        StringTokenizer st = new StringTokenizer(String.join(" ", tokens));

        if (st.countTokens() != 8) {
            System.out.println("Invalid data tokens for the 'A' command.");
            return;
        }

        st.nextToken(); // Get the "A" command.

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
    }

    private void removeEvent(String[] tokens) {
        if (tokens.length != 4) {
            System.out.println("Invalid data tokens for the 'R' command.");
            return;
        }

        // Extract data from the tokens array
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

        if (!calendar.removeEvent(eventDate, timeslot, location)) {
            System.out.println("Event not found.");
        }
    }


    public static void main(String[] args) {
        EventOrganizer organizer = new EventOrganizer();
        organizer.run();
    }
}
