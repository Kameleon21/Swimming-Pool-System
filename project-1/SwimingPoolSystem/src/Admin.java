public class Admin {
    // private variables
    private String name;
    private String password;

    //constructor method
    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*  https://www.tutorialspoint.com/java/util/formatter_tostring.htm */
    // to String
    public String toString() {
        return "name=%s , password = %s %n".formatted(name, password);
    }
}
