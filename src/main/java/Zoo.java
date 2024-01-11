

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Zoo {
    private ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Discount> discounts = new ArrayList<Discount>();
    private ArrayList<SpecialDeal> sdeals = new ArrayList<SpecialDeal>();
    private ArrayList<Visitor> visitors = new ArrayList<Visitor>();
    private double revenue;

    Zoo(ArrayList<Attraction> attractions, ArrayList<Animal> animals, ArrayList<Discount> discounts, ArrayList<SpecialDeal> sdeals, ArrayList<Visitor> visitors) {
        this.attractions = attractions;
        this.animals = animals;
        this.discounts = discounts;
        this.sdeals = sdeals;
        this.visitors = visitors;
        this.revenue = 0;
    }


    //Attraction functions

    public void addAttraction(int attractid,String name,String desc,int price) {    //to add attraction
        Attraction attract = new Attraction(attractid, name, desc, price);
        attractions.add(attract);
    }

    public boolean checkattraction(int id) {   //to check if attraction exists
        boolean stat = false;
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                stat = true;
                break;
            }
        }
        return stat;
    }

    public boolean checkattstatus(int id) {         //to check if attraction is open or closed
        boolean stat = false;
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                stat = attraction.getstatus2();
                break;
            }
        }
        return stat;
    }

    public double getattprice(int id) {       // get price of attraction
        double price = 0;
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                price = attraction.getPrice();
            }
        }
        return price;
    }

    public String getattname(int id) {   //to get name
        String name = "";
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                name = attraction.getName();
            }
        }
        return name;
    }

    public void modifyAttraction(int attractid,String name,String desc,int price) {     //to modify attraction
        for (Attraction attraction : attractions) {
            if (attractid == attraction.getId()) {
                attraction.setName(name); attraction.setDesc(desc); attraction.setPrice(price);
                System.out.println("Attraction Modified Succesfully!");
            }
        }
    }

    public void removeAtt(int id) {   //to remove attraction

        Iterator<Attraction> iterator = attractions.iterator();
        while (iterator.hasNext()) {
            Attraction attraction = iterator.next();
            if (id == attraction.getId()) {
                iterator.remove();
                System.out.println("Attraction Removed Succesfully!");

            }
        }



    }

    public void scheduleEvent(int id, String status, int price) {    //to schedule event
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                if (status.equalsIgnoreCase("open")) {
                    attraction.setStatus(true);
                    attraction.setPrice(price);
                }
                else if (status.equalsIgnoreCase("close")) {
                    attraction.setStatus(false);
                    attraction.setPrice(price);
                }
                else {
                    System.out.println("Please select one of the two options!");
                }

            }
        }



    }

    public void viewAttractions() {           //for admin
        System.out.println("Attractions: ");
        for (Attraction attraction : attractions) {
            System.out.println("ID: "+attraction.getId()+", Name: "+attraction.getName()+", Price: "+attraction.getPrice()+", Status: "+attraction.getStatus());
        }
    }

    public int getLastAttId() {       //to get last index for exit
        int number = 1;
        for (Attraction attraction : attractions) {
            number++;
        }
        return number;

    }



    public void viewattvisitor() {          //while viewing
        System.out.println("Attractions in the Zoo: ");
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getId()+". "+attraction.getName());
        }


    }

    public void viewattvisitor2() {       //while buying
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getId()+". "+attraction.getName()+" (₹"+attraction.getPrice()+")");
        }


    }

    public void viewAttdesc(int id) {      //to get att description
        for (Attraction attraction : attractions) {
            if (id == attraction.getId()) {
                if (attraction.getStatus() == "open") {
                    System.out.println(attraction.getDesc()+" Buy your tickets now!");
                }
                else {  //closed
                    System.out.println(attraction.getDesc()+" Currently closed!");
                }
            }


        }
    }

    public void addCount(int id) {     //to add count of visiters in attraction
        for (Attraction a : attractions) {
            if (a.getId() == id) {
                a.addcount();

            }
        }
    }

    public int getVisitorCount(int id) {
        int count = 0;
        for (Attraction a : attractions) {
            if (a.getId() == id) {
                count = a.getCount();
            }

        }
        return count;



    }


    public int bestAttraction() {  //get the most popular attraction count
        int max = -1;
        for (Attraction a : attractions) {
            if (a.getCount()>max) {
                max = a.getCount();
            }
        }

        return max;
    }

    public void printbestatt(int max) {    //to print most popular attraction(s)
        int number = 0;
        for (Attraction a : attractions) {
            if (a.getCount()==max) {
                number++;
                if (number<2) {
                    System.out.print(a.getName());

                }
                else {
                    System.out.print(", "+a.getName());

                }

            }

        }
    }


    //animal functions

    public void addAnimal(String anname,String atype,String history,String noise) {
        if (atype.equals("Mammal")) {
            Animal animal = new Mammal(anname, history, noise);
            animals.add(animal);
            System.out.println("Animal added to Zoo.");
        }
        else if (atype.equals("Amphibian")) {
            Animal animal = new Amphibian(anname, history, noise);
            animals.add(animal);
            System.out.println("Animal added to Zoo.");
        }
        else if (atype.equals("Reptile")) {
            Animal animal = new Reptile(anname, history, noise);
            animals.add(animal);
            System.out.println("Animal added to Zoo.");
        }

        else {
            System.out.println();
            System.out.println("Invalid type of Animal!\n Only Mammals, Amphibians and Reptiles are allowed in the Zoo.");
        }

    }

    public boolean checkAnimal(String name) {       //check if animal exists
        boolean stat = false;
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                stat = true;
                break;
            }
        }
        return stat;

    }


    public void updateAnimal(String name, String history, String noise) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animal.setHistory(history);
                animal.setNoise(noise);
                System.out.println("Animal Updated Successfully!");
            }
        }



    }

    public void removeAnimal(String name) {


        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (name.equals(animal.getName())) {
                iterator.remove();
                System.out.println("Animal Removed Successfully!");

            }
        }

    }

    public void viewAnimals() {
        int number = 1;
        for (Animal animal : animals) {
            System.out.println(number+". "+animal.getName());
            number++;
        }
    }


    public void viewAniminfo(String name) {       //to get animal info
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                System.out.println(animal.getHistory());
            }
        }
    }


    public void visitAnimal(String name) {      //to handle visit animal commands
        Scanner input = new Scanner(System.in);

        for (Animal a : animals) {
            if (a.getName().equals(name)){
                System.out.println("1. Feed "+a.getName());
                System.out.println("2. Read about "+a.getName());
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();

                if (choice<1 || choice>2) {
                    System.out.println("Invalid choice!");
                }

                else if (choice == 2) {         //read
                    System.out.println();
                    System.out.println(a.getHistory());
                }

                else if (choice == 1) {         //feed
                    System.out.println();
                    System.out.println("*"+a.getNoise()+"*");
                }


                break;
            }

        }



    }


    //discount functions

    public void addDiscount(String category, int percent, String code) {
        Discount discount = new Discount(category, percent, code);
        discounts.add(discount);
    }


    public boolean checkDiscount(String code) {
        boolean stat = false;
        for (Discount d: discounts){
            if (d.getCode().equalsIgnoreCase(code)) {
                stat = true;
                break;
            }
        }
        return stat;
    }


    public void modifyDiscount(String code, int percent) {
        for (Discount d : discounts) {
            if (d.getCode().equalsIgnoreCase(code)) {
                d.setPercent(percent);
                System.out.println("Discount Modified Successfully! ");
            }

        }
    }


    public void removeDiscount(String code) {

        Iterator<Discount> iterator = discounts.iterator();

        while (iterator.hasNext()) {
            Discount discount = iterator.next();
            if (discount.getCode().equalsIgnoreCase(code)) {
                iterator.remove();
                System.out.println("Discount Removed Successfully!");
            }
        }




    }


    public void viewdiscounts() {
        int number = 1;
        System.out.println("View Discounts: ");
        for (Discount d : discounts) {
            System.out.println(number+". "+d.getCategory()+"("+d.getPercent()+"% Discount) - "+d.getCode());
            number++;
        }

    }


    //special deal functions

    public void addDeal(int tickets, double percent) {
        SpecialDeal deal = new SpecialDeal(tickets, percent);
        sdeals.add(deal);
        System.out.println("Special Deal Added Successfully!");
    }

    public boolean checkDeal(int tickets) {
        boolean stat = false;

        for (SpecialDeal deal : sdeals) {
            if (tickets == deal.getTickets()) {
                stat = true;
                break;
            }
        }
        return stat;
    }

    public void removeDeal(int tickets) {





        Iterator<SpecialDeal> iterator = sdeals.iterator();


        while (iterator.hasNext()){
            SpecialDeal specialDeal = iterator.next();
            if (tickets == specialDeal.getTickets()){
                iterator.remove();
                System.out.println("Deal removed successfully!");
                break;
            }
        }

    }


    public void modifyDeal(int tickets, int percent) {
        for (SpecialDeal s : sdeals) {
            if (s.getTickets() == tickets) {
                s.setPercent(percent);
                System.out.println("Deal Modified Successfully! ");

            }
        }

    }

    public void viewDeals() {
        int number = 1;
        System.out.println("Special Deals: ");
        for (SpecialDeal deal : sdeals) {
            System.out.println(number+". Buy "+deal.getTickets()+" tickets and get "+deal.getPer()+"% off");
            number++;
        }



    }




    //visitor functions

    public void viewFeedback() {
        int position = 1;
        System.out.println("Feedbacks: ");
        for (Visitor visitor : visitors) {
            System.out.println(position+". "+visitor.getFeedback());
            position++;
        }
    }

    public boolean checkVisitor(String email, String pass) {        //check if visitor exists
        boolean stat = false;
        for (Visitor v : visitors) {
            if (v.getEmail().equals(email) && v.getPassword().equals(pass)) {
                stat = true;
                break;
            }
        }
        return stat;
    }

    public boolean checkVisitorEnroll(String email) {      //true if exists , false if doesn't
        boolean stat = false;

        for (Visitor v : visitors) {
            if (email.equalsIgnoreCase(v.getEmail())) {
                stat = true;

            }
        }
        return stat;
    }



    public void buybasic2(String email, String code) {       //to buy basic mem
        double percent = 0;
        double currentbalance = 0;
        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                currentbalance = v.getBalance();
            }
        }



        for (Discount d : discounts) {
            if (code.equals(d.getCode())) {
                percent = d.getPercent();
                System.out.println("Discount Applied Successfully!");
                break;
            }
        }

        if ((currentbalance - 20)>0) {


            for (Visitor v : visitors) {
                if (v.getEmail().equals(email)) {
                    double amttodeduct = 20 - (20*(percent/100));

                    v.deductbalance(amttodeduct);
                    revenue+=amttodeduct;                                   //adding revenue
                    v.buyBasic();
                    System.out.println("");
                    System.out.println("Basic Membership purchased successfully. Your balance is now "+v.getBalance()+" Rupees.");
                    break;
                }


            }
        }
        else {
            System.out.println("");
            System.out.println("Insufficient Balance!");
        }


    }


    public void buyPremium2(String email, String code) {        //to buy premium mem
        double percent = 0;
        double currentbalance = 0;
        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                currentbalance = v.getBalance();
            }
        }


        for (Discount d : discounts) {
            if (code.equals(d.getCode())) {
                percent = d.getPercent();
                System.out.println("Discount Applied Successfully!");
                break;
            }
        }

        if ((currentbalance - 50)>0) {

            for (Visitor v : visitors) {
                if (v.getEmail().equals(email)) {
                    double amttodeduct = 50 - (50*(percent/100));
                    revenue+=amttodeduct;                                               //adding revenue
                    v.deductbalance(amttodeduct);
                    v.buyPremium();
                    System.out.println("");
                    System.out.println("Premium Membership purchased successfully. Your balance is now "+v.getBalance()+" Rupees.");
                    break;
                }


            }

        }
        else {
            System.out.println("");
            System.out.println("Insufficient Balance!");
        }



    }


    public void buyticket(String email, Ticket t1) {         //adding the tickets to visitor element

        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                v.addticket(t1);

            }
        }

    }

    public boolean ticketmoneyded(String email, String code, int noof, Ticket t1) {     //to handle the money part of buy ticket          //deducting the money for buying tickets
        double percent = 0;
        double currentbalance = 0;

        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                currentbalance = v.getBalance();
            }
        }





        for (Discount d : discounts) {
            if (code.equals(d.getCode())) {
                percent = d.getPercent();
                System.out.println("Discount Applied Successfully!");
                break;
            }
        }

        double percent2 = 0;
        for (SpecialDeal deal : sdeals) {
            if (noof == deal.getTickets()) {
                percent2 = deal.getPer();
                System.out.println("Special Deal Applied!");
                break;
            }
        }

        //getting the attraction name
        String desired = "";
        for (Attraction a : attractions) {
            if (a.getId() == t1.getId()) {
                desired = a.getName();
            }

        }


        boolean status = false;

        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                double amt1 =((noof*(t1.getPrice())*(percent/100)));
                double amt2 =((noof*(t1.getPrice())*(percent2/100)));
                status = true;

                double amttodeduct = ((noof*t1.getPrice()) - (amt1+amt2));
                if ((v.getBalance() - currentbalance)>0) {


                    revenue+=amttodeduct;                                                   //adding revenue
                    v.deductbalance(amttodeduct);
                    System.out.println("");
                    System.out.println("Ticket for "+desired+" Purchased successfully. Your balance is now "+v.getBalance()+" Rupees.");
                    break;

                }
                else {
                    System.out.println("");
                    System.out.println("Insufficient Balance!");
                    status = false;
                }
            }


        }


        return status;


    }


    public boolean checkbasic(String email) {       //check if visitor has basic mem
        boolean stat = false;

        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                if (v.getMembership()>0) {

                    stat = true;
                }
                break;
            }
        }
        return stat;


    }

    public int visitorMem(String email) {     //get visitor membership
        int mem = 0;
        for (Visitor v : visitors) {
            if (v.getEmail().equals(email)) {
                mem = v.getMembership();

            }
        }
        return mem;

    }

    public void addFeedback(String email, String feed) {
        for (Visitor v : visitors) {
            if (email.equals(v.getEmail())) {
                v.setFeedback(feed);
            }
        }
    }



    //miscellaneous functions

    public boolean checkTicket(String email, int tickid) {    //check if visitor has ticket of the that attraction
        boolean stat = false;

        for (Visitor v :visitors) {
            if (email.equals(v.getEmail())) {
                stat = v.checktick(tickid);
            }
        }
        return stat;

    }

    public void useTicket (String email, int id) {      //to remove ticket when visitor has already visited
        for (Visitor v:visitors){
            if (email.equals(v.getEmail())) {
                v.removeTicket(id);
            }




        }
    }

    public double getRevenue() {

        return revenue;
    }


    public void addRevenue(double money) {

        this.revenue += money;
    }


    public void setvisittotrue(String email) {      //to set visited as true for visitor
        for (Visitor v : visitors) {
            if (email.equals(v.getEmail())) {
                v.setVisited();
            }

        }
    }

    public int getVisited() {       //to get no of visitors in the zoo
        int number = 0;

        for (Visitor v : visitors) {
            if (v.getVisited() == true) {
                number++;
            }
        }
        return number;
    }






}

