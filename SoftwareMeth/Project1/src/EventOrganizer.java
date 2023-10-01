import java.util.Scanner;
import java.util.StringTokenizer;

public class EventOrganizer {
    private EventCalendar calendar;
    private Scanner scanner;

    public EventOrganizer() {
        calendar = new EventCalendar();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Event Organizer running....");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();
            processCommand(command);

            if (command.equals("Q")) {
                System.out.println("Event Organizer terminated.");
                break;
            }
        }
    }

    private void processCommand(String command) {
        StringTokenizer tokenizer = new StringTokenizer(command);
        if (!tokenizer.hasMoreTokens()) {
            return; // Empty command
        }

        String action = tokenizer.nextToken().toUpperCase();
        switch (action) {
            case "A":
                processAddCommand(tokenizer);
                break;
            case "R":
                processRemoveCommand(tokenizer);
                break;
            case "P":
                processPrintCommand(tokenizer);
                break;
            case "PE":
                processPrintByDateCommand(tokenizer);
                break;
            case "PC":
                processPrintByCampusCommand(tokenizer);
                break;
            case "PD":
                processPrintByDepartmentCommand(tokenizer);
                break;
            default:
                System.out.println("Invalid command: " + action);
        }
    }

    private void processAddCommand(StringTokenizer tokenizer) {
        if (tokenizer.countTokens() != 6) {
            System.out.println("Invalid command: A command requires 6 tokens.");
            return;
        }

        String eventDateStr = tokenizer.nextToken();
        String timeslotStr = tokenizer.nextToken();
        String locationStr = tokenizer.nextToken();
        String departmentStr = tokenizer.nextToken();
        String email = tokenizer.nextToken();
        String durationStr = tokenizer.nextToken();

        // Parse and validate event date, timeslot, location, department, and duration
        Date eventDate = parseDate(eventDateStr);
        Timeslot timeslot = parseTimeslot(timeslotStr);
        Location location = Location.valueOf(locationStr);
        Department department = Department.valueOf(departmentStr);
        int duration = parseDuration(durationStr);

        if (eventDate == null || timeslot == null) {
            System.out.println("Invalid date or timeslot.");
            return;
        }

        if (duration < 30 || duration > 120) {
            System.out.println("Invalid duration. It must be between 30 and 120 minutes.");
            return;
        }

        // Validate email format
        if (!email.endsWith("@rutgers.edu")) {
            System.out.println("Invalid email format. It should end with @rutgers.edu.");
            return;
        }

        // Create a new event and add it to the calendar
        Contact contact = new Contact(department, email);
        Event event = new Event(eventDate, timeslot, location, contact, duration);
        if (calendar.add(event)) {
            System.out.println("Event added successfully.");
        } else {
            System.out.println("Error adding event. Check for conflicts or invalid data.");
        }
    }

    private void processRemoveCommand(StringTokenizer tokenizer) {
        if (tokenizer.countTokens() != 3) {
            System.out.println("Invalid command: R command requires 3 tokens.");
            return;
        }

        String eventDateStr = tokenizer.nextToken();
        String timeslotStr = tokenizer.nextToken();
        String locationStr = tokenizer.nextToken();

        // Parse and validate event date, timeslot, and location
        Date eventDate = parseDate(eventDateStr);
        Timeslot timeslot = parseTimeslot(timeslotStr);
        Location location = Location.valueOf(locationStr);

        if (eventDate == null || timeslot == null) {
            System.out.println("Invalid date or timeslot.");
            return;
        }

        // Create a temporary event for removal
        Event eventToRemove = new Event(eventDate, timeslot, location, null, 0);
        if (calendar.remove(eventToRemove)) {
            System.out.println("Event removed successfully.");
        } else {
            System.out.println("Event not found or error removing event.");
        }
    }

    private void processPrintCommand(StringTokenizer tokenizer) {
        calendar.print();
    }

    private void processPrintByDateCommand(StringTokenizer tokenizer) {
        calendar.printByDate();
    }

    private void processPrintByCampusCommand(StringTokenizer tokenizer) {
        calendar.printByCampus();
    }

    private void processPrintByDepartmentCommand(StringTokenizer tokenizer) {
        calendar.printByDepartment();
    }

    private Date parseDate(String dateStr) {
        String[] dateParts = dateStr.split("/");
        if (dateParts.length != 3) {
            return null; // Invalid date format
        }

        try {
            int month = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            return new Date(month, day, year);
        } catch (NumberFormatException e) {
            return null; // Invalid numeric values
        }
    }

    private Timeslot parseTimeslot(String timeslotStr) {
        timeslotStr = timeslotStr.toUpperCase();
        if (timeslotStr.equals("MORNING")) {
            return Timeslot.MORNING;
        } else if (timeslotStr.equals("AFTERNOON")) {
            return Timeslot.AFTERNOON;
        } else if (timeslotStr.equals("EVENING")) {
            return Timeslot.EVENING;
        } else {
            return null; // Invalid timeslot
        }
    }

    private int parseDuration(String durationStr) {
        try {
            int duration = Integer.parseInt(durationStr);
            return duration;
        } catch (NumberFormatException e) {
            return -1; // Invalid duration format
        }
    }

    public static void main(String[] args) {
        new EventOrganizer().run();
    }
}
