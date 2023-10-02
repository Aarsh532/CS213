public class EventOrganizer {
    private EventCalendar calendar;

    public EventOrganizer() {
        calendar = new EventCalendar();
    }

    public void run() {
        System.out.println("Event Organizer running....");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().trim();
            StringTokenizer tokenizer = new StringTokenizer(input);

            if (tokenizer.hasMoreTokens()) {
                String command = tokenizer.nextToken();
                switch (command) {
                    case "A":
                        handleAddCommand(tokenizer);
                        break;
                    case "R":
                        handleRemoveCommand(tokenizer);
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
                    case "Q":
                        System.out.println("Event Organizer terminated.");
                        return;
                    default:
                        System.out.println("Invalid command!");
                        break;
                }
            }
        }
    }

    private void handleAddCommand(StringTokenizer tokenizer) {
        // Assuming the tokenizer has all necessary tokens
        // for date, timeslot, location, contact, and duration
        try {
            String date = tokenizer.nextToken();
            String timeslot = tokenizer.nextToken().toUpperCase();
            String location = tokenizer.nextToken();
            String department = tokenizer.nextToken();
            String email = tokenizer.nextToken();
            int duration = Integer.parseInt(tokenizer.nextToken());

            // Validations
            if (!isValidDate(date)) {
                System.out.println("Invalid date!");
                return;
            }
            if (!isValidTimeslot(timeslot)) {
                System.out.println("Invalid timeslot!");
                return;
            }
            if (!isValidLocation(location)) {
                System.out.println("Invalid location!");
                return;
            }
            if (!isValidDepartment(department)) {
                System.out.println("Invalid department!");
                return;
            }
            if (!isValidEmail(email)) {
                System.out.println("Invalid email!");
                return;
            }
            if (duration < 30 || duration > 120) {
                System.out.println("Invalid duration!");
                return;
            }

            Contact contact = new Contact(Department.valueOf(department), email);
            Event event = new Event(date, timeslot, location, contact, duration);
            calendar.addEvent(event);

        } catch (Exception e) {
            System.out.println("Error processing the add command.");
        }
    }

    private void handleRemoveCommand(StringTokenizer tokenizer) {
        // Here, you'd probably need an additional method in EventCalendar
        // to find and remove an event based on the provided criteria.
        // This is just a placeholder logic.
        try {
            String date = tokenizer.nextToken();
            String timeslot = tokenizer.nextToken().toUpperCase();
            String location = tokenizer.nextToken();

            if (!isValidDate(date) || !isValidTimeslot(timeslot) || !isValidLocation(location)) {
                System.out.println("Invalid removal parameters!");
                return;
            }
            // Remove logic goes here, you might need a method in the EventCalendar to handle this

        } catch (Exception e) {
            System.out.println("Error processing the remove command.");
        }
    }

    private boolean isValidDate(String date) {
        // Check if the date format is correct and if it's a future date within 6 months
        // Use Calendar class to achieve this.
        return true; // Placeholder logic
    }

    private boolean isValidTimeslot(String timeslot) {
        return timeslot.equals("MORNING") || timeslot.equals("AFTERNOON") || timeslot.equals("EVENING");
    }

    private boolean isValidLocation(String location) {
        // Check if the location is one of the six valid locations
        try {
            Location.valueOf(location);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isValidDepartment(String department) {
        try {
            Department.valueOf(department);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        return email.endsWith("@rutgers.edu") && email.contains("@");
    }

    public static void main(String[] args) {
        EventOrganizer organizer = new EventOrganizer();
        organizer.run();
    }
}
