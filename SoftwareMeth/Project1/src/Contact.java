public class Contact {
    private Department department;
    private String email;

    public enum Department{
        CS,
        EE,
        ITI,
        MATH,
        BAIT
    }
    public boolean isValid(){
        return true;
    }
}
