public class Contact {
    private Department department;
    private String email;

    public enum Department{
        CS ("computer Science"),
        EE ("electrical engineering"),
        ITI ("information technology and informatics"),
        MATH ("mathematics"),
        BAIT ("business analytics and information technology");
        private final String stringValue;

        Department(String stringValue) {
            this.stringValue = stringValue;
        }
    }
    public void setInfo(Department department, String email){
        this.department = department;
        this.email = email;
    }
    public boolean isValid(){
        return true;
    }
}
