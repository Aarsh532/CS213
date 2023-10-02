public class Contact {

    private Department department; // Enum type as defined previously
    private String email;

    // Constructor
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    // Getter for department
    public Department getDepartment() {
        return department;
    }

    // Setter for department
    public void setDepartment(Department department) {
        this.department = department;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Check if the department and email are valid
    public boolean isValid() {
        return department != null && email != null && email.contains("@");
    }

    @Override
    public String toString() {
        return "Contact{" +
                "department=" + department +
                ", email='" + email + '\'' +
                '}';
    }
}
