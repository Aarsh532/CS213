public enum Location {
    HLL114("HLL114", "Hill Center", "Busch"),
    ARC103("ARC103", "Allison Road Classroom", "Busch"),
    BE_AUD("BE_AUD", "Beck Hall", "Livingston"),
    TIL232("TIL232", "Tillett Hall", "Livingston"),
    AB2225("AB2225", "Academic Building", "College Avenue"),
    MU302("MU302", "Murray Hall", "College Avenue");

    private final String roomNumber;
    private final String building;
    private final String campus;

    Location(String roomNumber, String building, String campus) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.campus = campus;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public String getCampus() {
        return campus;
    }

    @Override
    public String toString() {
        return roomNumber + " (" + building + ", " + campus + ")";
    }
}
