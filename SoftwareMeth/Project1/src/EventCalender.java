public class EventCalendar {
    private Event[] events;
    private int numEvents;
    private static final int INITIAL_CAPACITY = 4;

    public EventCalendar() {
        events = new Event[INITIAL_CAPACITY];
        numEvents = 0;
    }

    public boolean add(Event event) {
        if (!event.date.isValid() || contains(event)) {
            return false; // Invalid date or event already exists
        }

        if (numEvents == events.length) {
            resizeArray();
        }

        events[numEvents++] = event;
        return true;
    }

    public boolean remove(Event event) {
        int index = find(event);
        if (index != -1) {
            for (int i = index; i < numEvents - 1; i++) {
                events[i] = events[i + 1];
            }
            numEvents--;
            return true;
        }
        return false; // Event not found
    }

    public boolean contains(Event event) {
        return find(event) != -1;
    }

    public void print() {
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
    }

    public void printByDate() {
        sortByDate();
        print();
    }

    public void printByCampus() {
        sortByCampus();
        print();
    }

    public void printByDepartment() {
        sortByDepartment();
        print();
    }

    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }

    private void resizeArray() {
        Event[] newEvents = new Event[events.length + INITIAL_CAPACITY];
        System.arraycopy(events, 0, newEvents, 0, events.length);
        events = newEvents;
    }

    private void sortByDate() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].compareTo(events[j + 1]) > 0) {
                    // Swap events[j] and events[j + 1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }

    private void sortByCampus() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].location.compareTo(events[j + 1].location) > 0) {
                    // Swap events[j] and events[j + 1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }

    private void sortByDepartment() {
        for (int i = 0; i < numEvents - 1; i++) {
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].contact.getDepartment().compareTo(events[j + 1].contact.getDepartment()) > 0) {
                    // Swap events[j] and events[j + 1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
    }
}
