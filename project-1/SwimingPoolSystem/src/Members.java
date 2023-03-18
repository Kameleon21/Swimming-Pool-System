import javax.swing.plaf.basic.DefaultMenuLayout;

public class Members {
    // private variables
    private String firstName;
    private String secondName;
    private String email;
    private int dayOfMonth;
    private int monthOfYear;
    private int year;
    private String gender;
    private String membershipType;
    private String instructor;

    // constructor method
    public Members(String firstName, String secondName, String email, int dayOfMonth, int monthOfYear, int year, String gender, String membershipType, String instructor) {
        this.firstName = firstName;
        this.secondName = secondName;
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("invalid format email");
        }
        this.dayOfMonth = dayOfMonth;
        this.monthOfYear = monthOfYear;
        this.year = year;
        this.gender = gender;
        this.membershipType = membershipType;
        this.instructor = instructor;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            email = "invalid format email";
        }
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(int monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /* https://www.tutorialspoint.com/java/util/formatter_tostring.htm */
    /* to String*/
    public String toString() {
        return String.format("First Name: %s, Last Name: %s, Subscription Type: %s, Email Address: %s, D.O.B: %02d/%02d/%04d, Gender: %s, Instructor: %s %n",
                firstName, secondName, membershipType, email, dayOfMonth, monthOfYear, year, gender, instructor);
    }

}
