//@author Hersh
import java.util.StringTokenizer;

public class Contact {
    private Department department;
    private String email;

    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    public boolean isValid() {
        String[] emailParts = email.split("@");
        if (emailParts.length != 2) {
            return false; // Invalid email format
        }

        String domain = emailParts[1];
        if (!domain.equals("rutgers.edu")) {
            return false; // Invalid domain
        }

        // Add additional validation logic for department if needed

        return true; // Contact information is valid
    }

    public Department getDepartment() {
        return this.department;
    }
}
