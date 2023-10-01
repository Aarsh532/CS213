public enum Department {
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics"),
    BAIT("Business Analytics and Information Technology");

    private String fullName;

    Department(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}