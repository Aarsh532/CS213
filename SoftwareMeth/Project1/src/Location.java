public enum Location {
    HLL114("Hill Center, Busch"),
    ARC103("Allison Road Classroom, Busch"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Tillett Hall, Livingston"),
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue");

    private String fullName;

    Location(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}