package org.example;

import java.util.*;
interface discounts{
    public void addDiscount();
    public double calculateDiscount(int ageGroup,double RealPrice);
    public void removeDiscount(int ageGroup);
    public void modifyDiscount(int ageGroup, double newPercentageDiscount);

}
interface Event {
    public void setOpeningTime(String openingTime);

    public void setClosingTime(String closingTime);

    public String getOpeningTime();

    public String getClosingTime();
    public void setTicketPrice(double ticketPrice);

    public double getTicketPrice();

    public void setVisitorCount(int visitorCount);

    public int getVisitorCount();
}

class Attractions implements Event{
    private String name;
    private double price_of_attraction;
    private String description;
    private String openingTime;
    private String closingTime;
    private double ticketPrice;
    private int visitorCount;
    private double revenue;
    public Attractions(String name, String description,double ticketPrice){

        this.name = name;
        this.description = description;
        this.ticketPrice = ticketPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice_of_attraction() {
        return price_of_attraction;
    }

    @Override
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String getOpeningTime() {
        return openingTime;
    }

    @Override
    public String getClosingTime() {
        return closingTime;
    }

    @Override
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    @Override
    public int getVisitorCount() {
        return visitorCount;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getRevenue() {
        return revenue;
    }
    public void incrementRevenue(double amount) {
        revenue += amount;
    }
}

abstract class Animal{
    private String name;
    private String type;

    public Animal(String name, String type){
        this.name = name;
        this.type = type;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public abstract String sound();
    public abstract String description();
    public String tostring(){
        return "type:" + type + "Name:" + name;
    }
}
class Mammals extends Animal{
    public Mammals(String name){
        super(name, "Mammal");
    }

    @Override
    public String sound() {
        if(getName().equalsIgnoreCase("Lion")){
            return "roar";
        } else if (getName().equalsIgnoreCase("Dog")) {
            return "bark";
        }else{
            return "sound not specified yet for this mammal";
        }
    }

    @Override
    public String description() {
        return "Mammals are vertebrates with hair, mammary glands used to suckle young with milk, a diaphragm, three bones in the middle ear, and a lower jaw made up of a single pair of bones that articulates in a unique way with the skull.";
    }
}
class Amphibians extends Animal{
    public Amphibians(String name){
        super(name,"Amphibians");
    }

    @Override
    public String sound() {
        if(getName().equalsIgnoreCase("Frog")){
            return "croak";
        } else if (getName().equalsIgnoreCase("salamander")) {
            return "Hiss";
        }else{
            return "sound not specified";
        }
    }

    @Override
    public String description() {
        return "Amphibians are ectothermic, anamniotic, four-limbed vertebrate animals that constitute the class Amphibia. They are a paraphyletic group encompassing all tetrapods excluding the amniotes (tetrapods with an amniotic membrane, ";
    }
}
class Reptiles extends Animal{
    public Reptiles(String name){
        super(name,"Reptiles");
    }

    @Override
    public String sound() {
        if(getName().equalsIgnoreCase("Snake")){
            return "Hiss";
        } else if (getName().equalsIgnoreCase("crocodile")) {
            return "Roar";
        }else{
            return "sound not specified";
        }
    }

    @Override
    public String description() {
        return "Reptiles are defined as a vertebrate animal of a class that includes snake, lizards, turtles and tortoise. And they are distinguished by having dry scaly skin and typically laying soft-shelled eggs on land.";
    }
}
class Zoo{
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to the zoo.");
    }
}
class Admin implements discounts {
    private static final String username = "admin";
    private static final String password = "admin123";
    //    private int totalVisitors;
//    private double totalRevenue;
//    private String popularAttraction;
    public static boolean recognising(String admin_username,String admin_password){
        return admin_username.equals(username) && admin_password.equals(password);
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    private ArrayList<Attractions> attractions;
    private ArrayList<Animal> animals;
    private HashMap<String,Double> discount;
    //    private ArrayList<String> discount;
    private HashMap<String,Event> event_attraction;
    private List<String> feedback_list;
    private List<String> specialDeals;
    private Zoo zoo;
    public Admin(){
        attractions = new ArrayList<>();
        animals = new ArrayList<>();
        discount = new HashMap<>();
        feedback_list = new ArrayList<>();
        event_attraction = new HashMap<>();
        specialDeals = new ArrayList<>();
        this.zoo = new Zoo();
    }

    public List<String> getSpecialDeals() {
        return specialDeals;
    }

    public List<String> getFeedback_list() {
        return feedback_list;
    }

    public List<Attractions> getAttractions(){
        return attractions;
    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public HashMap<String, Double> getDiscount() {
        return discount;
    }

    public void addAttractions(String name, String description,double ticketprice){
        Attractions attraction = new Attractions(name,description,ticketprice);
        attractions.add(attraction);
        System.out.println("Attraction added succesfully");
    }
    public void viewAttraction(Admin admin){
        if(attractions.isEmpty()){
            System.out.println("No attractions are there");
        }else{
            System.out.println("Attractions are:-");
            List<Attractions> attractions = admin.getAttractions();
            for(int i=0;i<attractions.size();i++){
                Attractions attraction = attractions.get(i);
                System.out.println((i+1)+". "+ attraction.getName() + "(₹" + attraction.getTicketPrice()+")");
            }
        }
        System.out.println();
    }
    public boolean modifyAttraction(String name, String newName, String newDescription) {
        for (Attractions attraction : attractions) {
            if (attraction.getName().equals(name)) {
                attraction.setName(newName);
                attraction.setDescription(newDescription);
                System.out.println("Attraction modified successfully for: " + name);
                return true;
            }
        }
        System.out.println("Attraction with the specified name not found. Modification failed.");
        return false;
    }
    public void removeAttractions(String name) {
        Iterator<Attractions> iterator = attractions.iterator();
        while (iterator.hasNext()) {
            Attractions attraction = iterator.next();
            if (attraction.getName().equals(name)){
                iterator.remove();
                System.out.println("Attraction removed successfully: " + name);
                return;
            }
            System.out.println("Attraction not found: " + name);
        }

    }
    public void addAnimals(String name, String type) {
        Animal animal;
        switch (type.toLowerCase()) {
            case "mammal":
                animal = new Mammals(name);
                break;
            case "amphibian":
                animal = new Amphibians(name);
                break;
            case "reptile":
                animal = new Reptiles(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid animal type: " + type);
        }
        zoo.addAnimal(animal);
    }
    public void updateAnimalDetails(int index,String name, String type){
        if(index >=0 && index < animals.size()){
            Animal animal = animals.get(index);
            animal.setName(name);
            animal.setType(type);
            System.out.println("Animal details updated at this index "+ index);
        }else{
            System.out.println("Invalid index");
        }

    }
    public void removeAnimals(String name,String type){
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getName().equals(name) && animal.getType().equalsIgnoreCase(type)) {
                iterator.remove();
                System.out.println("Animal removed: " + name);
                return;
            }
        }
        System.out.println("Animal not found: " + name);
    }
    public void scheduleEvents(String openingTime, String closingTime, double ticketPrice, int visitorCount) {
        if (attractions.isEmpty()) {
            System.out.println("No attractions available to schedule events.");
            return;
        }

        System.out.println("Scheduling events for existing attractions:");
        updateAttractions(openingTime, closingTime, ticketPrice, visitorCount);
        printScheduledEvents();
    }

    private void updateAttractions(String openingTime, String closingTime, double ticketPrice, int visitorCount) {
        for (Attractions attraction : attractions) {
            attraction.setOpeningTime(openingTime);
            attraction.setClosingTime(closingTime);
            attraction.setTicketPrice(ticketPrice);
            attraction.setVisitorCount(visitorCount);
        }
    }

    private void printScheduledEvents() {
        for (Attractions attraction : attractions) {
            System.out.println("Event scheduled for " + attraction.getName() +
                    ": Opening Time - " + attraction.getOpeningTime() +
                    ", Closing Time - " + attraction.getClosingTime() +
                    ", Ticket Price - " + attraction.getTicketPrice() +
                    ", Visitor Count - " + attraction.getVisitorCount());
        }
    }
    @Override
    public void addDiscount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter discount category");
        String discountCategory = sc.nextLine();
        System.out.println("Enter Discount percentage.(e.g., 20 for 20");
        double discountPercentage = Double.parseDouble(sc.nextLine());
        discount.put(discountCategory,discountPercentage);
        System.out.println("discount added succesfully");
    }

    @Override
    public double calculateDiscount(int ageGroup,double RealPrice) {
        if(ageGroup< 18){
            return RealPrice - (RealPrice*0.1);
        } else if (ageGroup > 60) {
            return RealPrice - (RealPrice *0.2);
        }
        else{
            return RealPrice;
        }
    }

    @Override
    public void removeDiscount(int ageGroup) {
        if (discount.containsKey(ageGroup)) {
            discount.remove(ageGroup);
            System.out.println("Discount removed for age group: " + ageGroup);
        } else {
            System.out.println("No discount found for age group: " + ageGroup);
        }
    }

    @Override
    public void modifyDiscount(int ageGroup, double newPercentageDiscount) {
        if(discount.containsKey(ageGroup)){
            discount.put(String.valueOf(ageGroup),newPercentageDiscount);
            System.out.println("Discount modified for this group " + ageGroup);
        }
        else{
            System.out.println("Can't modified ");
        }
    }
    public void setDiscounts(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter discount category(Students, minor,senior)or Enter any discount code coupon ");
        String setDiscount = sc.nextLine();
        System.out.println(" Enter discount percentage(15 for 15%) ");
        double SetDiscountpercentage = sc.nextDouble();
        sc.nextLine();
        discount.put(setDiscount,SetDiscountpercentage);
    }
    public void setSpecialDeals() {

    }
    public void viewVisitorStats(Visitors visitor) {
        int totalVisitors = calculateTotalVisitors();
        double totalRevenue = calculateTotalRevenue();
        String popularAttraction = findMostPopularAttraction();

        totalVisitors += visitor.getNo_of_visitors();

        System.out.println("Visitor Statistics:");
        System.out.println("- Total Visitors: " + totalVisitors);
        System.out.println("- Total Revenue: $" + totalRevenue);
        System.out.println("- Most Popular Attraction: " + popularAttraction);
    }

    private int calculateTotalVisitors() {
        int totalVisitors = 0;
        for (Attractions attraction : attractions) {
            totalVisitors += attraction.getVisitorCount();
        }
        return totalVisitors;
    }
    private double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Attractions attraction : attractions) {
            totalRevenue += attraction.getRevenue();
        }
        return totalRevenue;
    }

    private String findMostPopularAttraction() {
        int maxVisitors = 0;
        String popularAttraction = "";
        for (Attractions attraction : attractions) {
            if (attraction.getVisitorCount() > maxVisitors) {
                maxVisitors = attraction.getVisitorCount();
                popularAttraction = attraction.getName();
            }
        }
        return popularAttraction;
    }

    public void viewFeedback() {
        for(String feedback:feedback_list){
            System.out.println("-"+feedback);
        }
    }
    public void addFeedback(String feedback){
        feedback_list.add(feedback);
    }
}
class Visitors{
    private String name;
    private int age;
    private double phone_no;
    private double visitor_balance;
    private boolean basicMembership;
    private String email;
    private String password;
    private boolean isPremiumMember;
    private boolean hasTicket;
    private int availableTickets;
    private String discountCode;
    private List<String> credentials;
    private int no_of_visitors = 0;
    private int VisitorCount = 0;
    public int getNo_of_visitors() {
        return no_of_visitors;
    }

    public Visitors(){
        this.credentials = new ArrayList<>();
    }
    public void Visitors(String name,int age,double phone_no,double visitor_balance,String email,String password){
        this.name = name;
        this.age = age;
        this.phone_no = phone_no;
        this.visitor_balance = visitor_balance;
        this.email = email;
        this.password = password;
    }

    public int getVisitorCount() {
        return VisitorCount;
    }

    public void setVisitor_balance(double visitor_balance) {
        this.visitor_balance = visitor_balance;
    }
    public String getName() {
        return name;
    }
    public void setDiscountCode(String discountCode){
        this.discountCode = discountCode;
    }
    public String getEmail() {
        return email;
    }

    public double getVisitor_balance() {
        return visitor_balance;
    }

    public double getPhone_no() {
        return phone_no;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBasicMembership() {
        return basicMembership;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setBasicMembership(boolean basicMembership) {
        this.basicMembership = basicMembership;
    }

    public void setPremiumMember(boolean premiumMember) {
        isPremiumMember = premiumMember;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public List<String> getCredentials() {
        return credentials;
    }
    public void register(String name, int age, double phone_no, double visitor_balance, String email, String password){
        String info_of_visitor = name+","+age+","+phone_no+","+visitor_balance+","+email+","
                +password;
        credentials.add(info_of_visitor);
        no_of_visitors++;
        VisitorCount++;
        System.out.println("Registration is successful");
    }
    public boolean login(String email, String password) {
        for (String credential : credentials) {
            if (credential.contains(email) && credential.contains(password)) {
                System.out.println("Login successful");
                return true;
            }
        }
        return false;
    }
    public void viewAttractions(Admin admin){

        List<Attractions> attractionsList = admin.getAttractions();
        System.out.println("Attractions in the zoo are:");
        for (int i = 0; i < attractionsList.size(); i++) {
            Attractions attraction = attractionsList.get(i);
            System.out.println((i + 1) + ". " + attraction.getName());
        }
    }
    public void viewAnimals(Admin admin){

        List<Animal> animalList = admin.getAnimals();
        System.out.println("Animals in the zoo are:");
        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);
            System.out.println((i + 1) + ". " + animal.getName());
            System.out.println("   Type: " + animal.getType());
        }
    }
    public void basicMembership(){
        double BasicMemberShipCost = 20.0;
        if (!discountCode.equals("None")) {
            HashMap<String, Double> discounts = new Admin().getDiscount();
            if (discounts.containsKey(discountCode)) {
                double discountPercentage = discounts.get(discountCode);
                BasicMemberShipCost -= (BasicMemberShipCost * discountPercentage) / 100;
            } else if(!discountCode.equals("None")) {
                System.out.println("Invalid Discount Code. Discount not applied.");
            }
        }
        if(visitor_balance >= BasicMemberShipCost){
            visitor_balance -= BasicMemberShipCost;
            setVisitor_balance(visitor_balance);
            setBasicMembership(true);
            basicMembership = true;
            System.out.println("Basic Membership purchased Successfully . your balance is now ₹" +visitor_balance);
        }else{
            System.out.println("Insufficient balance to purchase membership.");
        }
    }
    public void premiumMembership(){
        double PremiumMemberShipCost = 50.0;
        HashMap<String, Double> discounts = new Admin().getDiscount();
        if (!discountCode.equals("None") && discounts.containsKey(discountCode)) {
            double discountPercentage = discounts.get(discountCode);
            PremiumMemberShipCost -= (PremiumMemberShipCost * discountPercentage) / 100;
        } else if (!discountCode.equals("None")) {
            System.out.println("Invalid Discount Code. Discount not applied.");
        }
        if(visitor_balance >= PremiumMemberShipCost){
            setVisitor_balance(visitor_balance - PremiumMemberShipCost);
            setPremiumMember(true);
            isPremiumMember = true;
            System.out.println("Premium membership purchased successfully . Balance left now is ₹" + visitor_balance);
        }else{
            System.out.println("Insufficient balance to purchase it");
        }
    }
    public void BuyTickets(Admin admin, double visitor_balance,int visitorAge){
        System.out.println("Buy tickets:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of tickets:");
        int no_of_tickets = sc.nextInt();
        System.out.println("Buy Tickets:");
        System.out.println("Select an attraction to buy tickets:");
        List<Attractions> attractions = admin.getAttractions();
        for (int i = 0; i < attractions.size(); i++) {
            Attractions attraction = attractions.get(i);
            System.out.println((i + 1) + ". " + attraction.getName() + " (₹" + attraction.getTicketPrice()+ ")");
        }

        int choice = sc.nextInt();
        if(choice >= 1 && choice <= attractions.size()){
            Attractions selectedAttraction = attractions.get(choice - 1);
            double ticketPrice = selectedAttraction.getTicketPrice();
            double discountPrice = admin.calculateDiscount(visitorAge,ticketPrice);
            double total_ticket_price = discountPrice*no_of_tickets;
            if(no_of_tickets == 2){
                total_ticket_price *= 0.85;
            } else if (no_of_tickets == 3) {
                total_ticket_price *= 0.70;
            }
            if(discountCode.equals("MINOR10")){
                total_ticket_price *= 0.9;
            } else if (discountCode.equals("SENIOR20")) {
                total_ticket_price *= 0.8;
            } else if (!discountCode.equals("None")) {
                System.out.println("Invalid , No discounts applied");
            }
            if(visitor_balance >= total_ticket_price){
                availableTickets++;
                hasTicket = true;
                visitor_balance -= total_ticket_price;
                setVisitor_balance(visitor_balance);
                selectedAttraction.incrementRevenue(total_ticket_price);
                System.out.println("The ticket for "+ selectedAttraction.getName() +" was purchased successfully. your balance is now ₹" + visitor_balance);
            }else{
                System.out.println("Insufficient balance");
                hasTicket = false;
            }
        }else{
            System.out.println("Invalid choice. please select a valid attraction.");
        }
    }
    public void viewDiscounts(){
        System.out.println(" view Discounts:");
        System.out.println("1. Minor (10% discount) - MINOR10");
        System.out.println("2. Senior Citizen (20% discount) - SENIOR20");
    }
    public void viewSpecialDeals(Admin admin){
        List<String> specialDeals = admin.getSpecialDeals();
        System.out.println("Special Deals:");
        for (String deal : specialDeals) {
            System.out.println(deal);
        }
    }
    public void visitAnimals() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an animal to visit:");
        System.out.println("1. Lion");
        System.out.println("2. Frog");
        System.out.println("3. Snake");

        int choice = getUserChoice(scanner, 1, 3);
        Animal selectedAnimal = createAnimal(choice);

        if (selectedAnimal != null) {
            displayAnimalInfo(selectedAnimal);

            System.out.println("What would you like to do?");
            System.out.println("1. Feed the " + selectedAnimal.getName());
            System.out.println("2. Read about the " + selectedAnimal.getName() + "'s description");

            int actionChoice = getUserChoice(scanner, 1, 2);
            performAction(selectedAnimal, actionChoice);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private int getUserChoice(Scanner scanner, int min, int max) {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        while (choice < min || choice > max) {
            System.out.println("Invalid choice. Please try again.");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        return choice;
    }

    private Animal createAnimal(int choice) {
        switch (choice) {
            case 1:
                return new Mammals("Lion");
            case 2:
                return new Amphibians("Frog");
            case 3:
                return new Reptiles("Snake");
            default:
                return null;
        }
    }

    private void displayAnimalInfo(Animal animal) {
        System.out.println("You selected " + animal.getName() + ", " + animal.getType());
    }

    private void performAction(Animal animal, int actionChoice) {
        if (actionChoice == 1) {
            System.out.println(animal.getName() + ": " + animal.sound());
        } else if (actionChoice == 2) {
            System.out.println(animal.getName() + ": " + animal.description());
        } else {
            System.out.println("Invalid choice.");
        }
    }
    public void vistAttractions(Admin admin){
        Scanner sc = new Scanner(System.in);
        List<Attractions> attractions = admin.getAttractions();
        while (true) {
            System.out.println("Select an Attraction to Visit:");
            for (int i = 0; i < attractions.size(); i++) {
                System.out.println((i + 1) + ". " + attractions.get(i).getName());
            }
            System.out.println((attractions.size() + 1) + ". Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= attractions.size()) {
                Attractions selectedAttraction = attractions.get(choice - 1);
                if (isPremiumMember) {
                    System.out.println("Welcome to " + selectedAttraction.getName() + "! Enjoy your visit!");
                } else if (basicMembership && availableTickets > 0) {
                    availableTickets--;
                    System.out.println("1 Ticket Used.");
                    System.out.println("Thank you for visiting " + selectedAttraction.getName() +
                            ". Hope you enjoyed the attraction.");
                } else if (basicMembership && availableTickets == 0) {
                    System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                } else {
                    System.out.println("You need a ticket to access " + selectedAttraction.getName() + ".");
                }
            } else if (choice == attractions.size() + 1) {
                System.out.println("Exiting attractions section.");
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void leaveFeedback(Admin admin){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your feedback(max 200 characters):");
        String feed_back_msg = sc.nextLine();
        if(feed_back_msg.length() <= 200){
            System.out.println("Thank you for your feedback");
            String feedback = "Visitors" + name +":" + feed_back_msg;
            admin.addFeedback(feedback);
        }
        else {
            System.out.println("Feedback exceeds 200 characters limit. Feedback not submitted.");

        }
    }
}
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        Visitors visitor = new Visitors();
        double balance = 0.0;
        boolean adminLoggedin = false;
        boolean loggedIn = false;
        while (true){
            System.out.println("Welcome to ZOOtopia!");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a visitor");
            System.out.println("3. view Special Deals");
            System.out.println();
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Admin Username:");
                    String admin_username = sc.next();
                    System.out.print("Enter admin password:");
                    String admin_password = sc.next();
                    if(Admin.recognising(admin_username,admin_password)){
                        adminLoggedin = true;
                        System.out.println("Admin logged in successfully");
                        while(adminLoggedin){
                            System.out.println("Admin menu");
                            System.out.println("1. Manage attractions");
                            System.out.println("2. Manage Animals");
                            System.out.println("3. Schedule events");
                            System.out.println("4. Set discouunts");
                            System.out.println("5. Set Special deals");
                            System.out.println("6. view Visitor Stats");
                            System.out.println("7. View Feedback");
                            System.out.println("8. Exit");
                            int Adminchoice = sc.nextInt();
                            sc.nextLine();
                            switch (Adminchoice){
                                case 1:
                                    int temp = 4;
                                    while(temp == 4){
                                        System.out.println("1. Add attractions");
                                        System.out.println("2. View attractions");
                                        System.out.println("3. Modify attractions");
                                        System.out.println("4. Remove attractions");
                                        System.out.println("5. Exit");
                                        int adminchoice1 = sc.nextInt();
                                        sc.nextLine();
                                        switch (adminchoice1){
                                            case 1:
                                                System.out.println("Enter Attraction name:-");
                                                String Attraction_name = sc.nextLine();
                                                System.out.println("Enter Attraction description");
                                                String Attraction_description = sc.nextLine();
                                                System.out.println("Enter the attraction price:");
                                                double ticketPrice = sc.nextDouble();
                                                sc.nextLine();
                                                admin.addAttractions(Attraction_name, Attraction_description,ticketPrice);
                                                break;
                                            case 2:
                                                admin.viewAttraction(admin);
                                                break;
                                            case 3:
                                                System.out.println("Enter the name of the attraction , you want to modify:");
                                                String name = sc.nextLine();
                                                System.out.println("Enter new attraction name:");
                                                String newName = sc.nextLine();
                                                System.out.println("Enter new Attraction desciption:");
                                                String newDescription = sc.nextLine();
                                                admin.modifyAttraction(name,newName,newDescription);
                                                break;
                                            case 4:
                                                System.out.println("Enter the name of attraction you want to remove:");
                                                String name_to_remove = sc.nextLine();
                                                admin.removeAttractions(name_to_remove);
                                                break;
                                            case 5:
                                                if(adminchoice1 == 5){
                                                    temp = 0;
                                                }
                                                break;

                                            default:
                                                System.out.println("Invalid choice. please enter the correct choice and no");
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    int tem = 0;
                                    while (tem == 0) {
                                        System.out.println("1. Add animal");
                                        System.out.println("2. Update Animal details");
                                        System.out.println("3. Remove Animal");
                                        System.out.println("4. Exit");
                                        int adminchoice2 = sc.nextInt();
                                        sc.nextLine();
                                        switch (adminchoice2) {
                                            case 1:
                                                System.out.println("1. Enter animal Name:");
                                                String newName = sc.nextLine();
                                                System.out.println("2. Enter animal type");
                                                String type = sc.nextLine();
                                                admin.addAnimals(newName, type);
                                                break;
                                            case 2:
                                                System.out.println("Enter the index of the animal you want to modify:");
                                                int animalIndex = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Enter new animal name:");
                                                String modified_name = sc.nextLine();
                                                System.out.println("Enter new animal type");
                                                String modified_type = sc.nextLine();
                                                admin.updateAnimalDetails(animalIndex, modified_name, modified_type);
                                                break;
                                            case 3:
                                                System.out.println("enter the name of the animal you want to remove froom it:");
                                                String animalName = sc.nextLine();
                                                System.out.println("Enter the type of the animal you want to remove from it:");
                                                String animalType = sc.nextLine();
                                                admin.removeAnimals(animalName, animalType);
                                                break;
                                            case 4:
                                                tem = 1;
                                                break;
                                            default:
                                                System.out.println("Invalid choice");
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Enter opening time for attractions:");
                                    String openingTime = sc.nextLine();
                                    System.out.println("Enter closing time for attractions:");
                                    String closingTime = sc.nextLine();
                                    System.out.println("Enter ticket price for attractions:");
                                    double ticketPrice = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Enter initial visitor count for attractions:");
                                    int visitorCount = sc.nextInt();
                                    sc.nextLine();
                                    admin.scheduleEvents(openingTime,closingTime,ticketPrice,visitorCount);
                                    break;
                                case 4:
                                    System.out.println("set discounts");
                                    System.out.println("1. Add discount");
                                    System.out.println("2. Modify discount");
                                    System.out.println("3. Remove discount");
                                    System.out.println("4. Exit");
                                    int adminchoice3 = sc.nextInt();
                                    sc.nextLine();
                                    switch (adminchoice3){
                                        case 1:
                                            admin.addDiscount();
                                            break;
                                        case 2:
                                            System.out.println("Modify Discount:");
                                            System.out.println("Enter the age group to modify:");
                                            int ageGroup = sc.nextInt();
                                            System.out.println("Enter new discount percentage:");
                                            double newPercentage = Double.parseDouble(sc.next());
                                            admin.modifyDiscount(ageGroup, newPercentage);
                                            break;
                                        case 3:
                                            System.out.println("Enter the age of group you want to remove");
                                            int ageGroupToRemove = sc.nextInt();
                                            admin.removeDiscount(ageGroupToRemove);
                                            break;
                                        case 4:
                                            temp = 7;
                                            break;
                                        default:
                                            System.out.println("Invalid choice");

                                    }
                                    if(adminchoice3 == 7){
                                        break;
                                    }
                                    break;
                                case 5:
                                    admin.setSpecialDeals();
                                case 6:
                                    admin.viewVisitorStats(visitor);
                                case 7:
                                    admin.viewFeedback();
                                    break;
                                case 8:
                                    adminLoggedin = false;
                                    System.out.println("Logged out");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        }
                    }else{
                        System.out.println("Invalid admin Credentials");

                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("1.Register");
                        System.out.println("2. Login");
                        System.out.println("Enter your choice");
                        int visitorChoice = sc.nextInt();
                        sc.nextLine();
                        switch (visitorChoice) {
                            case 1:
                                System.out.println("Enter visitor name");
                                String name = sc.nextLine();
                                System.out.println("Enter visitor age");
                                int age = sc.nextInt();
                                visitor.setAge(age);
                                System.out.println("Enter visitor Phone number");
                                double phone = sc.nextDouble();
                                System.out.println("Enter visitor balance");
                                balance = sc.nextDouble();
                                visitor.setVisitor_balance(balance);
                                sc.nextLine();
                                System.out.println("Enter visitor Email");
                                String email = sc.nextLine();
                                System.out.println("Enter visitor password");
                                String password = sc.nextLine();
                                visitor.Visitors(name, age, phone, balance, email, password);
                                visitor.register(name, age, phone, balance, email, password);
                                break;
                            case 2:
                                System.out.println("Enter visitor Email");
                                String email1 = sc.nextLine();
                                System.out.println("Enter visitor password");
                                String pass = sc.nextLine();
                                loggedIn = visitor.login(email1, pass);
                                if (loggedIn) {
                                    System.out.println();
                                    while (true) {
                                        System.out.println("visitor menu:");
                                        System.out.println("1. Explore the zoo");
                                        System.out.println("2. Buy membership");
                                        System.out.println("3. buy tickets");
                                        System.out.println("4. View discounts");
                                        System.out.println("5. View Special deals");
                                        System.out.println("6. Visit Animals");
                                        System.out.println("7. Visit attractions");
                                        System.out.println("8. leave feedback");
                                        System.out.println("9. Log out");
                                        System.out.println();
                                        System.out.println("enter your choice");
                                        int visitorChoice2 = sc.nextInt();
                                        switch (visitorChoice2) {
                                            case 1:
                                                System.out.println("Explore the zoo");
                                                System.out.println("1. View Attractions");
                                                System.out.println("2. View Animals");
                                                System.out.println("3. Exit");
                                                System.out.println();
                                                System.out.println("Enter your choice");
                                                int visitorChoice3 = sc.nextInt();
                                                switch (visitorChoice3) {
                                                    case 1:
                                                        visitor.viewAttractions(admin);
                                                        System.out.println();
                                                        System.out.println("Enter your choice:");
                                                        int visitorChoice4 = sc.nextInt();
                                                        switch (visitorChoice4) {
                                                            case 1:
                                                                System.out.println("ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!");
                                                                break;
                                                            case 2:
                                                                System.out.println("ZOOtopia offers an beautiful garden that allows you to explore unexplored trails. Buy your ticket now!");
                                                                break;
                                                            case 3:
                                                                System.out.println("ZOOtopia offers an amazing dinosaur show that allows you to explore unexplored trails. Buy your ticket now!");
                                                                break;
                                                            default:
                                                                System.out.println("Invalid choice");
                                                                break;
                                                        }
                                                        break;
                                                    case 2:
                                                        visitor.viewAnimals(admin);
                                                        break;
                                                    case 3:
                                                        break;
                                                    default:
                                                        System.out.println("Invalid Choice.");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Buy Membership");
                                                System.out.println("1. Basic membership");
                                                System.out.println("2. Premium membership");
                                                System.out.println("Enter your choice");
                                                int visitorChoice4 = sc.nextInt();
                                                switch (visitorChoice4) {
                                                    case 1:
                                                        System.out.println("Apply Discount code(or type None if don't have):");
                                                        String discountCode = sc.next();
                                                        visitor.setDiscountCode(discountCode);
                                                        visitor.basicMembership();
                                                        balance = visitor.getVisitor_balance();
                                                        break;
                                                    case 2:
                                                        System.out.println("Apply discount code(or type None if don't have):");
                                                        String DiscountCode = sc.next();
                                                        visitor.setDiscountCode(DiscountCode);
                                                        visitor.premiumMembership();
                                                        break;
                                                    default:
                                                        System.out.println("Invalid choice");
                                                }
                                                break;
                                            case 3:
                                                visitor.BuyTickets(admin,balance,visitor.getAge());
                                                break;
                                            case 4:
                                                System.out.println("View Discounts:");
                                                visitor.viewDiscounts();
                                                break;
                                            case 5:
                                                visitor.viewSpecialDeals(admin);
                                                break;
                                            case 6:
                                                visitor.visitAnimals();
                                                break;
                                            case 7:
                                                visitor.vistAttractions(admin);
                                                break;
                                            case 8:
                                                visitor.leaveFeedback(admin);
                                                break;
                                            case 9:
                                                System.out.println("Log out");
                                                loggedIn = false;
                                                break;
                                            default:
                                                System.out.println("Invalid choice");
                                                break;
                                        }
                                        if(!loggedIn){
                                            break;
                                        }
                                    }
                                }
                                else{
                                    System.out.println("Invalid email or password. PLease try again");
                                }
                                break;

                            default:
                                System.out.println("Invalid choice. try again");
                        }
                        break;
                    }
                    break;
                case 3:
                    visitor.viewSpecialDeals(admin);
                    break;
                default:
                    System.out.println("Invalid choice, enter the correct choice");
                    break;
            }
        }
    }
}