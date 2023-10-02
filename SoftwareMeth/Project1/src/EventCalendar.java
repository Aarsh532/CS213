//@author Hersh and Aarsh
public class EventCalendar {
    private static final int MAX_EVENTS = 100;

    private Event[] events;
    private int numEvents;

    public EventCalendar() {
        this.events = new Event[MAX_EVENTS];
        this.numEvents = 0;
    }

    public void addEvent(Event event) {
        if (numEvents < MAX_EVENTS) {
            if (!hasConflict(event.getDate(), event.getStartTime(), event.getLocation()) &&
                    isFutureDate(event.getDate()) &&
                    !isMoreThanSixMonthsAway(event.getDate())) {
                events[numEvents] = event;
                numEvents++;
            } else {
                System.out.println("Event validation failed! Please check event details and try again.");
            }
        } else {
            System.out.println("Event calendar is full! Cannot add more events.");
        }
    }

    public boolean addEventSUC(Event event) {
        if (numEvents < MAX_EVENTS) {
            events[numEvents] = event;
            numEvents++;
            return true; // Event added successfully
        }
        return false; // Could not add the event
    }


    public void print() {
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
    }

    // In-place Bubble Sort by Date
    private void bubbleSortByDate() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].compareTo(events[j + 1]) > 0) {
                    // Swap
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }

    // In-place Bubble Sort by Department
    private void bubbleSortByDepartment() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                Department department1 = events[j].getContact().getDepartment();
                Department department2 = events[j + 1].getContact().getDepartment();
                if (department1.compareTo(department2) > 0) {
                    // Swap
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }

    public boolean hasConflict(Date date, Event.Timeslot timeslot, String location) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].getDate().equals(date) &&
                    events[i].getStartTime() == timeslot &&
                    events[i].getLocation().equals(location)) {
                return true; // Found a conflicting event
            }
        }
        return false; // No conflict found
    }
    public boolean isFutureDate(Date eventDate) {
        Date currentDate = Date.currentDate();
        return eventDate.compareTo(currentDate) > 0;
    }

    public boolean isMoreThanSixMonthsAway(Date eventDate) {
        Date currentDate = Date.currentDate();
        Date sixMonthsLater = currentDate.addMonths(6);
        return eventDate.compareTo(sixMonthsLater) > 0;
    }

    private void bubbleSortByCampus() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                String campus1 = Location.valueOf(events[j].getLocation()).getCampus();
                String campus2 = Location.valueOf(events[j + 1].getLocation()).getCampus();
                int campusComparison = campus1.compareTo(campus2);
                if (campusComparison > 0 || (campusComparison == 0 && events[j].getLocation().compareTo(events[j + 1].getLocation()) > 0)) {
                    // Swap
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }

    public boolean removeEvent(Date date, Event.Timeslot timeslot, String location) {

        for (int i = 0; i < numEvents; i++) {

            if (events[i].getDate().equals(date) &&
                    events[i].getStartTime() == timeslot &&
                    events[i].getLocation().equals(location)) {



                // Remove the event by shifting all elements on its right one place to the left
                for (int j = i; j < numEvents - 1; j++) {
                    events[j] = events[j + 1];
                }
                events[numEvents - 1] = null; // Remove the last duplicate event
                numEvents--;
                return true; // Successfully removed
            }
        }
        return false; // Event not found
    }

    public boolean isEmpty() {
        return numEvents == 0;
    }



    public void printByDate() {
        bubbleSortByDate();
        print();
    }

    public void printByDepartment() {
        bubbleSortByDepartment();
        print();
    }

    public void printByCampus() {
        bubbleSortByCampus();
        print();
    }
}
