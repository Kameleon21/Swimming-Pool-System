public class SwimmingPoolSystem {
    private Members m1;
    private Staff st1;
    private Stock sto1;
    private Admin ad1;
    private final Collection collectionList = new Collection();

    public SwimmingPoolSystem() {
    }

    public static void main(String[] args) {
        SwimmingPoolSystem sps1 = new SwimmingPoolSystem();
        sps1.checkPassword();
        sps1.saveData();
    }

    public int mainMenu() {
        System.out.println("Welcome to the Swimming Pool System");
        System.out.println("-".repeat(20));
        System.out.println("1 --> Members");
        System.out.println("2 --> Staff");
        System.out.println("3 --> Stock");
        System.out.println("4 --> Admin");
        System.out.println("0 --> Quit");
        System.out.println("Enter a choice between [0-5]");

        /* store users choice */
        int choice = EasyScanner.nextInt();
        System.out.println("-".repeat(20));
        return choice;
    }

    // upload stored data on load of program
    public void upload() {
        System.out.println("Booting up system" + ".".repeat(15));
        try {
            collectionList.loadMembers();
            collectionList.loadStaff();
            collectionList.loadStock();
            collectionList.loadAdmin();
        } catch (Exception e) {
            System.out.println("Error writing to file:" + e);
        }
    }

    //save data when user closes the program
    public void saveData() {
        System.out.println("Data being stored" + ".".repeat(15));
        try {
            collectionList.saveMembers();
            collectionList.saveStock();
            collectionList.saveStaff();
            collectionList.saveAdmin();
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e);
        }
        System.out.println("--------Data backlogged-----------");
    }

    //members choice interface
    public int membersChoice() {
        //ask user for input
        System.out.println("What would you like to do?");
        System.out.println("1 --> Create a member");
        System.out.println("2 --> List all members");
        System.out.println("3 --> Remove a member from the system");
        System.out.println("4 --> Search members by specific details");
        System.out.println("5 --> Update members details");
        System.out.println("0 --> Return to main menu");
        int memberOption = EasyScanner.nextInt();
        System.out.println("-".repeat(20));
        return memberOption;
    }

    // members functionality
    public void membersMenu() {
        int option2 = membersChoice();
        while (option2 != 0) {
            switch (option2) {

                case 1 -> createMember();
                case 2 -> System.out.println(collectionList.listOfMembers());
                case 3 -> deleteMember();
                case 4 -> listOfMemDetails2();
                case 5 -> updateMemDetails();
                default -> System.out.println("Wrong option chosen");
            }
            option2 = membersChoice();
        }
    }

    // Staff choice interface
    public int staffChoice() {
        //ask user for input
        System.out.println("What would you like to do?");
        System.out.println("1 --> Create a staff");
        System.out.println("2 --> List all staff");
        System.out.println("3 --> Remove a staff from the system");
        System.out.println("4 --> Search for staff by specific details");
        System.out.println("5 --> See Instructors Clients");
        System.out.println("0 --> Return to main menu");
        int staffOption = EasyScanner.nextInt();
        System.out.println("-".repeat(20));
        return staffOption;
    }

    // staff functionality
    public void staffMenu() {
        int option3 = staffChoice();
        while (option3 != 0) {
            switch (option3) {
                case 1 -> createStaff();
                case 2 -> System.out.println(collectionList.listOfStaff());
                case 3 -> deleteStaff();
                case 4 -> listOfStaffDetails2();
                case 5 -> searchClients();
                default -> System.out.println("Wrong option chosen");
            }
            option3 = staffChoice();
        }
    }

    // stock interface Menu
    public int stockChoice() {
        //ask user for input
        System.out.println("What would you like to do?");
        System.out.println("1 --> Add to stock");
        System.out.println("2 --> List all stock");
        System.out.println("3 --> Remove an item from stock");
        System.out.println("0 --> Return to main menu");
        int stockOption = EasyScanner.nextInt();
        System.out.println("-".repeat(20));
        return stockOption;
    }

    // stock functionality
    public void stockMenu() {
        int option4 = stockChoice();
        while (option4 != 0) {
            switch (option4) {
                case 1 -> createStock();
                case 2 -> System.out.println(collectionList.listOfStock());
                case 3 -> deleteStock();
                default -> System.out.println("Wrong option chosen");
            }
            option4 = stockChoice();
        }
    }

    public int adminChoice() {
        // greet user and ask what they would like to do
        System.out.println("Hey " + collectionList.getAdminName());
        System.out.println("What would you like to do?");
        System.out.println("1 --> Updated password");
        System.out.println("0 --> Return to the main menu");
        int adminOption = EasyScanner.nextInt();
        System.out.println("-".repeat(20));
        return adminOption;
    }

    public void adminMenu() {
        int option5 = adminChoice();
        while (option5 != 0) {
            if (option5 == 1) {
                collectionList.setAdminPassword();
            } else {
                System.out.println("Wrong option chosen");
            }
            option5 = adminChoice();
        }
    }

    public void run() {
        // reference https://www.baeldung.com/java-delay-code-execution
        try {
            Thread.sleep(2500); // wait for 2.5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> membersMenu();
                case 2 -> staffMenu();
                case 3 -> stockMenu();
                case 4 -> checkAdminPass();
                default -> System.out.println("Wrong option chosen");
            }
            option = mainMenu();
        }
    }

    public void checkPassword() {
        String adminPassword = "Swim1";
        System.out.println("Enter password: ");
        String pass = EasyScanner.nextString();
        if (pass.equals(adminPassword)) {
            upload();
            run();
        } else {
            boolean constant = true;
            System.out.println("Wrong password Entered");
            if (constant) {
                while (constant) {
                    System.out.println("Enter password: ");
                    pass = EasyScanner.nextString();
                    if (pass.equals(adminPassword)) {
                        constant = false;
                        upload();
                        run();
                    }
                }
            }
        }
    }

    public void checkAdminPass() {
        System.out.println("Enter administrator password");
        String testPass = EasyScanner.nextString();
        if (testPass.equals(collectionList.getAdminPassword())) {
            adminMenu();
        } else {
            boolean flag = true;
            while (flag) {
                System.out.println("Wrong password entered.Try again");
                String testPass2 = EasyScanner.nextString();
                if (testPass2.equals(collectionList.getAdminPassword())) {
                    flag = false;
                    adminMenu();
                }
            }
        }
    }

    /* Create the member/staff/stock/Admin methods */
    public void createMember() {
        // Declare Variables
        String firstName;
        String secondName;
        String email;
        int dayOfMonth;
        int monthOfYear;
        int year;
        String gender;
        String membershipType;
        String instructor;

        // Input and assign values
        System.out.println("Enter members first name");
        firstName = EasyScanner.nextString();
        firstName = collectionList.formatName(firstName);

        System.out.println("Enter members second name");
        secondName = EasyScanner.nextString();
        secondName = collectionList.formatName(secondName);

        System.out.println("Enter members email address");
        email = EasyScanner.nextString();
        if (email.contains("@")) {
            email = email;
        } else {
            System.out.println("Invalid email format, please enter a correct address");
            boolean flag = true;
            while (flag) {
                System.out.println("Enter members email");
                email = EasyScanner.nextString();
                if (email.contains("@")) {
                    email = email;
                    flag = false;
                }
            }
        }

        System.out.println("Enter the day of the month that the member was born");
        dayOfMonth = EasyScanner.nextInt();

        System.out.println("What month was the member born in? [from 1-12]");
        monthOfYear = EasyScanner.nextInt();

        System.out.println("What year was the member born in?");
        year = EasyScanner.nextInt();

        System.out.println("Enter gender i.e Male or Female");
        gender = EasyScanner.nextString();
        gender = collectionList.formatName(gender);

        System.out.println("Enter members subscription type");
        membershipType = EasyScanner.nextString();
        membershipType = collectionList.formatName(membershipType);

        System.out.println("Enter instructors name");
        instructor = EasyScanner.nextString();
        instructor = collectionList.formatName(instructor);

        //use these variables to crate and construct new member object
        m1 = new Members(firstName, secondName, email, dayOfMonth, monthOfYear, year, gender, membershipType, instructor);
        collectionList.addMember(m1);
        System.out.println("-".repeat(20));
    }

    public void createStaff() {
        // Declare Variables
        String firstName;
        String secondName;
        int dayOfMonth;
        int monthOfYear;
        int year;
        String position;

        // Input and assign values
        System.out.println("Enter staff's first name: ");
        firstName = EasyScanner.nextString();
        firstName = collectionList.formatName(firstName);

        System.out.println("Enter staff's second name: ");
        secondName = EasyScanner.nextString();
        secondName = collectionList.formatName(secondName);

        System.out.println("What day of the month were they born on? [1-31]");
        dayOfMonth = EasyScanner.nextInt();

        System.out.println("What month where they born in? Answer in [1-12]");
        monthOfYear = EasyScanner.nextInt();

        System.out.println("What year were they born in?");
        year = EasyScanner.nextInt();

        System.out.println("Enter new staff's position age");
        position = EasyScanner.nextString();
        position = collectionList.formatName(position);

        //use these variables to crate and construct new staff object
        st1 = new Staff(firstName, secondName, dayOfMonth, monthOfYear, year, position);
        collectionList.addStaff(st1);
        System.out.println("-".repeat(20));
    }

    public void createStock() {
        // Declare Variables
        String itemName;
        int itemQuantity;

        // Input and assign values
        System.out.println("Enter new item name ");
        itemName = EasyScanner.nextString();

        System.out.println("Enter new items quantity: ");
        itemQuantity = EasyScanner.nextInt();

        //use these variables to crate and construct new stock object
        sto1 = new Stock(itemName, itemQuantity);
        collectionList.addStock(sto1);
        System.out.println("-".repeat(20));
    }

    public void createAdmin() {
        // Declare variables
        String name;
        String password;

        // Input and assign values
        System.out.println("Enter admins name");
        name = EasyScanner.nextString();

        System.out.println("Enter new password");
        password = EasyScanner.nextString();

        //use these variables to crate and construct new stock object
        ad1 = new Admin(name, password);
        collectionList.addAdmin(ad1);
        System.out.println("-".repeat(20));
    }


    /* delete members/staff/stock object from arrayList */
    public void deleteMember() {
        System.out.println("Swimming Pool Members List: " + "\n" + collectionList.listOfMembers());
        System.out.println("-".repeat(20));
        System.out.println("Enter the index of the member you wish to remove from the system");
        int index = EasyScanner.nextInt() - 1;
        collectionList.removeMember(index);
        System.out.println("Member removed from the system");
    }

    public void deleteStaff() {
        System.out.println("Swimming Pool Staff List: " + "\n" + collectionList.listOfStaff());
        System.out.println("-".repeat(20));
        System.out.println("Enter the index of the staff you wish to remove from the system");
        int index = EasyScanner.nextInt() - 1;
        collectionList.removeStaff(index);
        System.out.println("Staff removed from the system");
    }

    public void deleteStock() {
        System.out.println("Swimming Pool Stock List: " + "\n" + collectionList.listOfStaff());
        System.out.println("-".repeat(20));
        System.out.println("Enter the index of the stock you wish to remove from the system");
        int index = EasyScanner.nextInt() - 1;
        collectionList.removeStock(index);
        System.out.println("Stock removed from the system");
    }

    // menu to Search for members details
    public int listOfMembersDetails() {
        System.out.println("Search members by ");
        System.out.println("1 --> Name");
        System.out.println("2 --> Year of birth");
        System.out.println("3 --> Subscription type");
        System.out.println("0 --> Return to members menu");
        int searchNum = EasyScanner.nextInt();
        return searchNum;
    }

    public void listOfMemDetails2() {
        int option6 = listOfMembersDetails();
        while (option6 != 0) {
            switch (option6) {
                case 1 -> {
                    System.out.println("Enter a name");
                    String name = EasyScanner.nextString();
                    name = collectionList.formatName(name);
                    System.out.println(collectionList.searchMemByName(name));
                }
                case 2 -> {
                    System.out.println("Enter the year");
                    int yearIn = EasyScanner.nextInt();
                    System.out.println(collectionList.searchMemByYear(yearIn));
                }
                case 3 -> {
                    System.out.println("Enter the subscription type i.e Yearly or Monthly");
                    String memType = EasyScanner.nextString();
                    memType = collectionList.formatName(memType);
                    System.out.println(collectionList.searchMemByType(memType));
                }
                default -> System.out.println("Wrong option chosen");
            }
            option6 = listOfMembersDetails();
        }
    }

    // update members details
    public void updateMemDetails() {
        System.out.println("Waterford Swimming Pool Members List \n:" + collectionList.listOfMembers());
        System.out.println("Please enter the index of the member you wish to update: ");
        int index = EasyScanner.nextInt()-1;

        Members m = collectionList.membersList.get(index);
        System.out.println("\tWhich of the following do you wish to edit:");
        System.out.println("\t1 --> Members first name");
        System.out.println("\t2 --> Members second name");
        System.out.println("\t3 --> Members email address");
        System.out.println("\t4 --> The day of the month member was born on i.e [1-31]");
        System.out.println("\t5 --> The month that the member was born in i.e [1-12]");
        System.out.println("\t6 --> The year that the member was born in ");
        System.out.println("\t7 --> Members gender");
        System.out.println("\t8 --> Members subscription type");
        System.out.println("\t9 --> Instructors name");
        System.out.println("\t0. Exit");
        int option = EasyScanner.nextInt();

        while (option != 0) {
            switch (option) {
                case 1 -> {
                    System.out.println("Enter members first name");
                    String memFirstName = EasyScanner.nextString();
                    memFirstName = collectionList.formatName(memFirstName);
                    m.setFirstName(memFirstName);
                }
                case 2 -> {
                    System.out.println("Enter members second name");
                    String memSecondName = EasyScanner.nextString();
                    memSecondName = collectionList.formatName(memSecondName);
                    m.setSecondName(memSecondName);
                }
                case 3 -> {
                    System.out.println("Enter members email address");
                    String memEmail = EasyScanner.nextString();
                    m.setEmail(memEmail);
                }
                case 4 -> {
                    System.out.println("Enter the day of the month member was born on i.e [1-31]");
                    int memDayOfBirth = EasyScanner.nextInt();
                    m.setDayOfMonth(memDayOfBirth);
                }
                case 5 -> {
                    System.out.println("Enter the month that the member was born in i.e [1-12]");
                    int memMonthOfBirth = EasyScanner.nextInt();
                    m.setMonthOfYear(memMonthOfBirth);
                }
                case 6 -> {
                    System.out.println("Enter the year that the member was born in ");
                    int memYearOfBirth = EasyScanner.nextInt();
                    m.setYear(memYearOfBirth);
                }
                case 7 -> {
                    System.out.println("Enter members gender");
                    String memGender = EasyScanner.nextString();
                    memGender = collectionList.formatName(memGender);
                    m.setGender(memGender);
                }
                case 8 -> {
                    System.out.println("Enter members subscription type");
                    String memSubType = EasyScanner.nextString();
                    memSubType = collectionList.formatName(memSubType);
                    m.setMembershipType(memSubType);
                }
                case 9 -> {
                    System.out.println("Enter instructors name");
                    String instrName = EasyScanner.nextString();
                    instrName = collectionList.formatName(instrName);
                    m.setInstructor(instrName);
                }
                default -> System.out.println("Invalid Option");
            }
            System.out.println("\tWhich of the following do you wish to edit:");
            System.out.println("\t1 --> Members first name");
            System.out.println("\t2 --> Members second name");
            System.out.println("\t3 --> Members email address");
            System.out.println("\t4 --> The day of the month member was born on i.e [1-31]");
            System.out.println("\t5 --> The month that the member was born in i.e [1-12]");
            System.out.println("\t6 --> The year that the member was born in ");
            System.out.println("\t7 --> Members gender");
            System.out.println("\t8 --> Members subscription type");
            option = EasyScanner.nextInt();
        }
        System.out.println("Updated Details");
        System.out.println(m);
    }

    // menu to Search for Staff Details
    public int listOfStaffDetails() {
        System.out.println("Search Staff by ");
        System.out.println("1 --> Name");
        System.out.println("2 --> Year of birth");
        System.out.println("3 --> Position");
        System.out.println("0 --> Return to staff menu");
        int searchNum = EasyScanner.nextInt();
        return searchNum;
    }

    public void listOfStaffDetails2() {
        int option7 = listOfStaffDetails();
        while (option7 != 0) {
            switch (option7) {
                case 1 -> {
                    System.out.println("Enter a name");
                    String name = EasyScanner.nextString();
                    name = collectionList.formatName(name);
                    System.out.println(collectionList.searchStaffByName(name));
                }
                case 2 -> {
                    System.out.println("Enter the year");
                    int yearIn = EasyScanner.nextInt();
                    System.out.println(collectionList.searchStaffByYear(yearIn));
                }
                case 3 -> {
                    System.out.println("Enter position your looking for i.e Cleaner, Help Desk or Instructor");
                    String pos = EasyScanner.nextString();
                    pos = collectionList.formatName(pos);
                    System.out.println(collectionList.searchStaffByPostition(pos));
                }
                default -> System.out.println("Wrong option chosen");
            }
            option7 = listOfStaffDetails();
        }
    }

    // search instructors clients and see a list of them
    public void searchClients() {
        String instructors = "";
        for (Staff s: collectionList.staffList) {
            if (s.getPosition().equals("Instructor")) {
                instructors += s.getFirstName() + "\n";
            }
        }
        System.out.println(instructors);
        System.out.println("Choose who's clients you want to look at");
        String answer = EasyScanner.nextString();
        answer = collectionList.formatName(answer);
        String answerOfClients = "";
        for (Members m: collectionList.membersList) {
            if(m.getInstructor().equals(answer)) {
                answerOfClients += m + "\n";
            }
        }
        System.out.println(answerOfClients);
    }

}