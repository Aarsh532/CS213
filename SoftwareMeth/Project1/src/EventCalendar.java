import java.util.Comparator;

public class EventCalendar {
    private Event[] events;       // Array holding the list of events
    private int numEvents;        // Current number of events in the array
    private static final int INITIAL_CAPACITY = 4;
    private static final int CAPACITY_INCREMENT = 4;
    private static final int NOT_FOUND = -1;

    // Constructor
    public EventCalendar() {
        events = new Event[INITIAL_CAPACITY];
        numEvents = 0;
    }

    // Private method to find an event in the array
    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    // Private method to increase the capacity of the events array
    private void grow() {
        Event[] newEvents = new Event[events.length + CAPACITY_INCREMENT];
        System.arraycopy(events, 0, newEvents, 0, numEvents);
        events = newEvents;
    }

    // Public method to add an event to the calendar
    public boolean add(Event event) {
        if (find(event) != NOT_FOUND) {
            System.out.println("Error: Event with the same date/timeslot/location already exists.");
            return false;
        }

        if (numEvents == events.length) {
            grow();
        }

        events[numEvents++] = event;
        return true;
    }

    // Public method to remove an event from the calendar
    public boolean remove(Event event) {
        int index = find(event);
        if (index == NOT_FOUND) {
            System.out.println("Error: Event not found in the calendar.");
            return false;
        }

        // Shift elements to the left to remove the event
        for (int i = index; i < numEvents - 1; i++) {
            events[i] = events[i + 1];
        }

        numEvents--;
        return true;
    }

    // Public method to check if an event is in the calendar
    public boolean contains(Event event) {
        return find(event) != NOT_FOUND;
    }

    // Public method to print all events in the calendar
    public void print() {
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
    }

    // Public method to print events sorted by date and timeslot using Bubble Sort
    public void printByDate() {
        bubbleSort(new DateTimeslotComparator());
        print();
    }

    // Public method to print events sorted by campus and building/room using Bubble Sort
    public void printByCampus() {
        bubbleSort(new CampusComparator());
        print();
    }

    // Public method to print events sorted by department using Bubble Sort
    public void printByDepartment() {
        bubbleSort(new DepartmentComparator());
        print();
    }

    // Bubble Sort implementation for sorting events
    private void bubbleSort(Comparator<Event> comparator) {
        int n = numEvents;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(events[i - 1], events[i]) > 0) {
                    // Swap events[i-1] and events[i]
                    Event temp = events[i - 1];
                    events[i - 1] = events[i];
                    events[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // Comparator for sorting by date and timeslot
    private static class DateTimeslotComparator implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            int dateComparison = event1.getDate().compareTo(event2.getDate());
            if (dateComparison != 0) {
                return dateComparison;
            } else {
                return event1.getStartTime().compareTo(event2.getStartTime());
            }
        }
    }

    // Comparator for sorting by campus and building/room
    private static class CampusComparator implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            return event1.getLocation().compareTo(event2.getLocation());
        }
    }

    // Comparator for sorting by department
    private static class DepartmentComparator implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            return event1.getContact().getDepartment().compareTo(event2.getContact().getDepartment());
        }
    }
}