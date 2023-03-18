public class Staff {
    /* private variables */
    private String firstName;
    private String secondName;
    private int dayOfMonth;
    private int monthOfYear;
    private int year;
    private String position;

    /* constructor method */

    public Staff(String firstName, String secondName, int dayOfMonth, int monthOfYear, int year, String position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dayOfMonth = dayOfMonth;
        this.monthOfYear = monthOfYear;
        this.year = year;
        this.position = position;
    }

    /* Getters and Setters */

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /* https://www.tutorialspoint.com/java/util/formatter_tostring.htm */
    /* to String */
    public String toString() {
        return "firstName: %s, secondName: %s, D.O.B : %02d/%02d/%04d, position: %s %n".formatted(firstName, secondName,dayOfMonth, monthOfYear,year,position);
    }
}
