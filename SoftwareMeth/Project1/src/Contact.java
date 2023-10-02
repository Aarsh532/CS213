//@author Hersh and Aarsh
public class Contact {

    private Department department; // Enum type as defined previously
    private String email;


    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }


    public Department getDepartment() {
        return department;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


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
