import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Collection {
    /* Arraylist for holding data on four classes  */
    ArrayList<Members> membersList = new ArrayList<>();
    ArrayList<Staff> staffList = new ArrayList<>();
    ArrayList<Stock> stockList = new ArrayList<>();
    ArrayList<Admin> adminList = new ArrayList<>();

    /* Constructor */
    public Collection() {

    }

    /* Methods  to add */
    public void addMember(Members m1) {
        membersList.add(m1);
    }

    public void addStaff(Staff st1) {
        staffList.add(st1);
    }

    public void addStock(Stock sto1) {
        stockList.add(sto1);
    }

    public void addAdmin(Admin ad1) {
        adminList.add(ad1);
    }

    /* Methods to remove */
    public void removeMember(int index) {
        membersList.remove(index);
    }

    public void removeStaff(int index) {
        staffList.remove(index);
    }

    public void removeStock(int index) {
        stockList.remove(index);
    }

    public void removeAdmin(int index) {
        adminList.remove(index);
    }

    /* Methods to view how many members,staff and stock there is */
    public int numberOfMembers() {
        return membersList.size();
    }

    public int numberOfStaff() {
        return staffList.size();
    }

    public int numberOfStock() {
        return stockList.size();
    }

    // list of Members/Staff/Stock
    public String listOfMembers() {
        String allMembers = "";
        int index = 0;
        if (membersList.isEmpty()) {
            allMembers = "There are no members stored in the system";
        } else {
            for (Members m : membersList) {
                allMembers = allMembers + "Index " + (index + 1) + ":    " + m + "\n";
                index++;
            }
        }
        return allMembers;
    }

    public String listOfStaff() {
        String allStaff = "";
        int index = 0;
        if (staffList.isEmpty()) {
            allStaff = "There are no staff stored in the system";
        } else {
            for (Staff s : staffList) {
                allStaff = allStaff + "Index " + (index + 1) + ":     " + s + "\n";
                index++;
            }
        }
        return allStaff;
    }

    public String listOfStock() {
        String allStock = "";
        int index = 0;
        if (stockList.isEmpty()) {
            allStock = "There is not stock stored in the system";
        } else {
            for (Stock st : stockList) {
                allStock = allStock + "Index " + (index + 1) + ":      " + st + "\n";
                index++;
            }
        }
        return allStock;
    }

    // Method for admin
    public String getAdminPassword() {
        String pass = adminList.get(0).getPassword();
        return pass;
    }

    public String getAdminName() {
        String name = adminList.get(0).getName();
        return name;
    }

    public void setAdminPassword() {
        String currentPass = getAdminPassword();
        System.out.println("Enter current Password:");
        String currentPassword = EasyScanner.nextString();
        if (currentPassword.equals(currentPass)) {
            System.out.println("Enter new password");
            String updatedPassword = EasyScanner.nextString();
            System.out.println("Confirm the new password.( Make sure they match)");
            String updatedPassword2 = EasyScanner.nextString();
            if (updatedPassword2.equals(updatedPassword)) adminList.get(0).setPassword(updatedPassword2);
        } else {
            boolean flag = true;
            while (flag) {
                System.out.println("Wrong password entered. Try again");
                String password = EasyScanner.nextString();
                if (password.equals(getAdminPassword())) {
                    System.out.println("Enter new password");
                    String updatedPassword = EasyScanner.nextString();
                    System.out.println("Confirm the new password.( Make sure they match)");
                    String updatedPassword2 = EasyScanner.nextString();
                    if (updatedPassword2.equals(updatedPassword)) adminList.get(0).setPassword(updatedPassword2);
                    flag = false;
                }
            }
        }

    }

    // search for member by details
    public String searchMemByName(String nameIn) {
        String searchResults = "";
        int count = 0;
        for (Members m : membersList) {
            if (m.getFirstName().equals(nameIn)) {
                searchResults = searchResults + m.toString() + '\n';
                count++;
            } else {
                System.out.println("No match found");
            }
        }
        System.out.println("\nResult: " + count + " members"+"\n");
        return searchResults;
    }

    public String searchMemByYear(int year) {
        String searchResult = "";
        int count = 0;
        for (Members m : membersList) {
            if (m.getYear() >= year) {
                searchResult += m.toString() + "\n";
                count++;
            }
        }
        System.out.println("\nResult: "+ count + " members" +"\n");
        return searchResult;
    }

    public String searchMemByType(String subType) {
        String searchResults = "";
        int count = 0;
        for (Members m : membersList) {
            if (m.getMembershipType().equals(subType)) {
                searchResults += m.toString() + "\n";
                count++;
            }
        }
        System.out.println("\nResult: " + count + " members"+"\n");
        return searchResults;
    }

    // search for staff by details
    public String searchStaffByName(String nameIn) {
        String searchResult = "";
        int count = 0;
        for (Staff s : staffList) {
            if (s.getFirstName().equals(nameIn)) {
                searchResult += s.toString() + "\n";
                count++;
            }
        }
        System.out.println("\nResult: "+count + " members" +"\n");
        return searchResult;
    }

    public String searchStaffByYear(int year) {
        String searchResult = "";
        int count = 0;
        for (Staff s : staffList) {
            if (s.getYear() >= year) {
                searchResult += s.toString() + "\n";
                count++;
            }
        }
        System.out.println("\nResult: " + count + " members" +"\n");
        return searchResult;
    }

    public String searchStaffByPostition(String pos) {
        String searchResult = "";
        int count = 0;
        for (Staff s : staffList) {
            if (s.getPosition().equals(pos)) {
                searchResult += s.toString() + "\n";
                count++;
            }
        }
        System.out.println("\nResult: " + count+ " members" +"\n");
        return searchResult;
    }

    // capitalize the first letter
    public String formatName(String name) {
        name = name.trim();
        String firstLetter = name.substring(0,1).toUpperCase();
        String restOfName = name.substring(1).toLowerCase();
        return firstLetter + restOfName;
    }

    // save and load Members
    @SuppressWarnings("unchecked")
    public void loadMembers() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("members.xml"));
        membersList = (ArrayList<Members>) is.readObject();
        is.close();
    }

    public void saveMembers() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("members.xml"));
        out.writeObject(membersList);
        out.close();
    }

    //save and load Staff
    @SuppressWarnings("unchecked")
    public void loadStaff() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("staff.xml"));
        staffList = (ArrayList<Staff>) is.readObject();
        is.close();
    }

    public void saveStaff() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("staff.xml"));
        out.writeObject(staffList);
        out.close();
    }

    //save and load Stock
    @SuppressWarnings("unchecked")
    public void loadStock() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("stock.xml"));
        stockList = (ArrayList<Stock>) is.readObject();
        is.close();
    }

    public void saveStock() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("stock.xml"));
        out.writeObject(stockList);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void loadAdmin() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("admin.xml"));
        adminList = (ArrayList<Admin>) is.readObject();
        is.close();
    }

    public void saveAdmin() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("admin.xml"));
        out.writeObject(adminList);
        out.close();
    }

}
