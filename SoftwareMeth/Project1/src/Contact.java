public class Contact {
    private Department department;
    private String email;

    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    // Define necessary constants for department acronyms
    public enum Department {
        CS, EE, ITI, MATH, BAIT
    }

    // Check if the contact information is valid
    public boolean isValid() {
        return isDepartmentValid(department) && isEmailValid(email);
    }

    // Helper method to check if the department name is valid
    private boolean isDepartmentValid(Department department) {
        for (Department validDepartment : Department.values()) {
            if (validDepartment == department) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if the email is valid
    private boolean isEmailValid(String email) {
        // Check if the email has the @rutgers.edu domain
        return email.endsWith("@rutgers.edu");
    }

    // Getters for department and email
    public Department getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }
}
