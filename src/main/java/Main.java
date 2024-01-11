

import java.util.ArrayList;
import java.util.Scanner;






/**
 *      Assumptions - tickets cannot be bought if att is closed
 *
 *
 *
 */







public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);




        System.out.println("Welcome to Zootopia!");


        //variables for outside the loop
        int attractid = 1;




        ArrayList<Attraction> attractions = new ArrayList<Attraction>();

        ArrayList<Animal> animals = new ArrayList<Animal>();
        Animal an1 = new Mammal("Tiger", "Tigers are the largest species of cat in the world.\nThey have been a symbol in Asian art and culture for centuries.", "Growls");
        Animal an2 = new Mammal( "Elephant", "Elephants are the largest land animals alive today.\nThey are the only remaining species of the family Elephantidae.", "trumpets");
        Animal an3 = new Reptile( "Crocodile", "They are classified as semiaquatic reptiles, meaning they live both in and out of water.\n Crocodiles are found in the tropics of Africa, Asia.", "Bellows");
        Animal an4 = new Reptile("King Cobra", "The king cobra is a venomous snake endemic to Asia. \nThe sole member of the genus Ophiophagus.", "Hisses");
        Animal an5 = new Amphibian("Axolotl", "The axolotl is a paedomorphic salamander closely related to the tiger salamander. \nIt is unusual among amphibians in that it reaches adulthood without undergoing metamorphosis.", "Squeaks");
        Animal an6 = new Amphibian("Frog", "The average frog or salamander may not indulge in large game, but every amphibian is a carnivore. \nAnything that they can swallow will become their dinner.", "Croaks");
        animals.add(an1); animals.add(an2); animals.add(an3); animals.add(an4); animals.add(an5); animals.add(an6);

        ArrayList<Discount> discounts = new ArrayList<Discount>();
        Discount d1 = new Discount("Minor", 10, "MINOR10");
        Discount d2 = new Discount("Senior", 20, "SENIOR20");
        discounts.add(d1); discounts.add(d2);

        ArrayList<SpecialDeal> sdeals = new ArrayList<SpecialDeal>();
        SpecialDeal deal1 = new SpecialDeal(2, 15);
        SpecialDeal deal2 = new SpecialDeal(3, 30);
        sdeals.add(deal1); sdeals.add(deal2);


        ArrayList<Visitor> visitors = new ArrayList<Visitor>();





        Zoo zoo = new Zoo(attractions, animals, discounts, sdeals, visitors);






        while (true) {


            System.out.println("");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");

            System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            System.out.println("");


            if (choice == 3) {
                System.out.println();
                zoo.viewDeals();
            }


            else if (choice == 1) {                                 //admin
                System.out.print("Enter Admin Username: ");
                String adname = input.nextLine();
                System.out.print("Enter Admin Password: ");
                String adpass = input.nextLine();



                if (adname.equals("admin") && adpass.equals("admin123")) {
                    System.out.println("");
                    System.out.println("Logged in as Admin.");

                    int choice1 = 1;

                    while (choice1!=8) {
                        System.out.println("");
                        System.out.println("Admin Menu:");
                        System.out.println("1. Manage Attractions");
                        System.out.println("2. Manage Animals");
                        System.out.println("3. Schedule Events");
                        System.out.println("4. Set Discounts");
                        System.out.println("5. Set Special Deal");
                        System.out.println("6. View Visitor Stats");
                        System.out.println("7. View Feedback");
                        System.out.println("8. Exit");
                        System.out.println();
                        System.out.print("Enter your choice: ");
                        choice1 = input.nextInt();
                        input.nextLine();

                        if (choice1<1 || choice1>8) {
                            System.out.println();
                            System.out.println("Invalid Choice! Try Again.");
                        }

                        else if (choice1 == 8) {
                            System.out.println("");
                            System.out.println("Logged Out.");
                            break;
                        }


                        else if (choice1 == 1) {            //manage attractions
                            System.out.println();
                            System.out.println("Manage Attractions:");
                            System.out.println("1. Add Attraction");
                            System.out.println("2. View Attractions");
                            System.out.println("3. Modify Attraction");
                            System.out.println("4. Remove Attraction");
                            System.out.println("5. Exit");
                            System.out.println("");
                            System.out.print("Enter your choice: ");
                            int choice2 = input.nextInt();
                            input.nextLine();


                            if (choice2<1 || choice2>5) {
                                System.out.println("Invalid Choice! Try Again.");
                            }


                            else if (choice2 == 1) {      //add attraction
                                System.out.println("");
                                System.out.print("Enter Attraction Name: ");
                                String name = input.nextLine();
                                System.out.print("Enter Attraction Description: ");
                                String desc = input.nextLine();
                                System.out.print("Enter Attraction Price: ");
                                int price = input.nextInt();
                                input.nextLine();

                                if (price<0) {
                                    System.out.println();
                                    System.out.println("Price cannot be negative!");
                                }
                                else {
                                    zoo.addAttraction(attractid, name, desc, price);
                                    System.out.println("Attraction added successfully! ");
                                    attractid++;
                                }
                            }

                            else if (choice2 == 2) {       //view attraction
                                System.out.println("");
                                zoo.viewAttractions();

                            }

                            else if (choice2 == 3) {       //modify attraction
                                System.out.println("");
                                System.out.print("Enter Attraction ID: ");
                                int id = input.nextInt();
                                input.nextLine();




                                if (zoo.checkattraction(id) == true) {
                                    System.out.print("Enter New Name: ");
                                    String name = input.nextLine();
                                    System.out.print("enter New Description: ");
                                    String desc = input.nextLine();
                                    System.out.print("Enter New Price: ");
                                    int price = input.nextInt();
                                    input.nextLine();

                                    if (price<0) {
                                        System.out.println("Price cannot be negative!");
                                    }
                                    else {
                                        zoo.modifyAttraction(id, name, desc, price);
                                    }
                                }
                                else {
                                    System.out.println("No Such Attraction Found!");
                                }



                            }

                            else if (choice2 == 4) { // Remove attraction
                                System.out.println("");
                                System.out.print("Enter Attraction ID: ");
                                int id = input.nextInt();
                                input.nextLine();



                                if (zoo.checkattraction(id) == true) {
                                    zoo.removeAtt(id);
                                }
                                else {
                                    System.out.println("No Such Attraction Found!");
                                }
                            }




                        }

                        else if (choice1 == 2) {             //manage animals
                            System.out.println("");
                            System.out.println("Manage Animals:");
                            System.out.println("1. Add Animal");
                            System.out.println("2. Update Animal Details");
                            System.out.println("3. Remove Animal");
                            System.out.println("4. Exit");
                            System.out.println("");
                            System.out.print("Enter your choice: ");
                            int choice2 = input.nextInt();
                            input.nextLine();


                            if (choice2<1 || choice2>4) {
                                System.out.println("Invalid Choice! Try Again.");
                            }

                            else if (choice2 == 1) {          //add animal
                                System.out.println("");
                                System.out.print("Enter Animal name: ");
                                String anname = input.nextLine();
                                System.out.print("Enter Animal Type: ");
                                String atype = input.nextLine();
                                System.out.print("Enter Animal History: ");
                                String history = input.nextLine();
                                System.out.print("Enter Animal's noise: ");
                                String noise = input.nextLine();

                                zoo.addAnimal(anname, atype, history, noise);

                            }

                            else if (choice2 == 2) {       //update animal details
                                System.out.println("");
                                System.out.print("Enter Animal Name: ");
                                String anname = input.nextLine();


                                if (zoo.checkAnimal(anname) == true) {
                                    System.out.print("Enter New Animal History: ");
                                    String history = input.nextLine();
                                    System.out.print("Enter New Animal's noise: ");
                                    String noise = input.nextLine();

                                    zoo.updateAnimal(anname, history, noise);
                                }

                                else {
                                    System.out.println("No Such Animal Found!");
                                }



                            }

                            else if (choice2 == 3) {        //remove animal
                                System.out.println("");
                                System.out.print("Enter Animal Name: ");
                                String anname = input.nextLine();


                                if (zoo.checkAnimal(anname) == true) {
                                    zoo.removeAnimal(anname);
                                }

                                else {
                                    System.out.println("No Such Animal Found!");
                                }


                            }

                        }


                        else if (choice1 == 3) {        //schedule events
                            System.out.println("");
                            System.out.print("Enter Attraction ID: ");
                            int id = input.nextInt();
                            input.nextLine();


                            if (zoo.checkattraction(id) == true) {
                                System.out.print("Select one of the two options(open or close): ");
                                String status = input.nextLine().toLowerCase();
                                System.out.print("Enter New Price: ");
                                int price = input.nextInt();
                                input.nextLine();


                                if (price<0) {
                                    System.out.println();
                                    System.out.println("Price cannot be negative!");
                                }

                                else {
                                    zoo.scheduleEvent(id, status, price);
                                    System.out.println("Changes made successfully!");
                                }

                            }

                            else {
                                System.out.println("No such Event Found!");
                            }



                        }

                        else if (choice1 == 4) {           //set discounts
                            System.out.println("");
                            System.out.println("Set Discounts:");
                            System.out.println("1. Add Discount");
                            System.out.println("2. Modify Discount");
                            System.out.println("3. Remove Discount");
                            System.out.println("4. Exit");
                            System.out.println("");
                            System.out.print("Enter your choice: ");
                            int choice2 = input.nextInt();
                            input.nextLine();

                            if (choice2<1 || choice2>4) {
                                System.out.println("Invalid Choice! Try Again.");
                            }

                            else if (choice2 == 1) {        //add discount
                                System.out.println("");
                                System.out.print("Enter Discount Category: ");
                                String category = input.nextLine();
                                System.out.print("Enter Discount Percentage(e.g., 20 for 20%): ");
                                int percent = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter Discount Code: ");
                                String code = input.nextLine();

                                if (percent<100 && percent>0) {

                                    if (zoo.checkDiscount(code) == false) {

                                        zoo.addDiscount(category, percent, code);
                                        System.out.println("Discount added successfully.");
                                    }
                                    else {
                                        System.out.println("Discount with similar code already exists! please use different code.");
                                    }
                                }
                                else {
                                    System.out.println("Illegal Discount Percentage!");
                                }

                            }

                            else if (choice2 == 2) {        //modify discount
                                System.out.println("");
                                System.out.print("Enter Discount Code: ");
                                String code1 = input.nextLine();

                                if (zoo.checkDiscount(code1) == true) {
                                    System.out.print("Enter New Discount Percentage: ");
                                    int percent1 = input.nextInt();
                                    input.nextLine();

                                    if (percent1>0 && percent1<100) {
                                        zoo.modifyDiscount(code1, percent1);
                                    }
                                    else {
                                        System.out.println("Illegal Discount Percentage!");
                                    }
                                }
                                else {
                                    System.out.println("No such discount found!");
                                }



                            }

                            else if (choice2 == 3) { // Remove discount
                                System.out.println("");
                                System.out.print("Enter Discount Code: ");
                                String code1 = input.nextLine();

                                if (zoo.checkDiscount(code1) == true) {
                                    zoo.removeDiscount(code1);
                                }
                                else {
                                    System.out.println("No such discount found!");
                                }
                            }
                        }


                        else if (choice1 == 5) {       //set Special deals
                            System.out.println("");
                            System.out.println("Set Special Deals:");
                            System.out.println("1. Add Deal");
                            System.out.println("2. Modify Deal");
                            System.out.println("3. Remove Deal");
                            System.out.println("4. View Deals");
                            System.out.println("5. Exit");
                            System.out.println("");
                            System.out.print("Enter your choice: ");
                            int choice2 = input.nextInt();
                            input.nextLine();


                            if (choice2<1 || choice2>5) {
                                System.out.println("Invalid Choice! Try Again.");
                            }

                            else if (choice2 == 1) {        //add deal
                                System.out.println("");
                                System.out.print("Enter No Of Tickets: ");
                                int tickets = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter Discount Percentage(e.g., 20 for 20%): ");
                                int percent = input.nextInt();
                                input.nextLine();

                                if (percent>0 && percent<100) {

                                    if (zoo.checkDeal(tickets) == true) {
                                        System.out.println();
                                        System.out.print("A similar special deal exists!\n Do you want to overwrite it?(y or n): ");
                                        String reply = input.nextLine();

                                        if (reply.equalsIgnoreCase("y")) {
                                            zoo.modifyDeal(tickets, percent);
                                        }
                                    }
                                    else {
                                        zoo.addDeal(tickets, percent);
                                    }
                                }
                                else {
                                    System.out.println("\nIllegal Deal Percentage!");
                                }
                            }

                            else if (choice2 == 2) {        //modify deal
                                System.out.print("\nEnter no of Tickets in the deal: ");
                                int tickets = input.nextInt();
                                input.nextLine();

                                if (zoo.checkDeal(tickets) == true) {
                                    System.out.print("Enter New Discount Percentage: ");
                                    int percent1 = input.nextInt();
                                    input.nextLine();

                                    if (zoo.checkDeal(tickets) == true) {

                                        if (percent1>0 && percent1<100) {
                                            zoo.modifyDeal(tickets, percent1);
                                        }
                                        else {
                                            System.out.println("\nIllegal Discount Percentage!");
                                        }

                                    }

                                    else {
                                        System.out.println("\nNo such deal exists.");
                                    }
                                }




                            }


                            else if (choice2 == 3) {        //remove deal
                                System.out.println("");
                                System.out.print("Enter no of Tickets the deal was applied to: ");
                                int tickets = input.nextInt();
                                input.nextLine();

                                if (zoo.checkDeal(tickets) == true) {
                                    zoo.removeDeal(tickets);
                                }

                                else {
                                    System.out.println("Deal doesn't exist.");
                                }
                            }

                            else if (choice2 == 4) {     //view deals
                                System.out.println("");
                                zoo.viewDeals();
                            }




                        }


                        else if (choice1 == 6){      //view visitor stats
                            System.out.println();
                            System.out.println("Visitor Statistics: ");
                            System.out.println("-Total Visitors: "+zoo.getVisited());

                            System.out.println("-Total Revenue: "+zoo.getRevenue());
                            int max = zoo.bestAttraction();
                            System.out.print("-Most Popular Attraction: ");
                            zoo.printbestatt(max);
                            System.out.println();


                        }

                        else if (choice1 == 7) {        //view feedback
                            System.out.println();
                            zoo.viewFeedback();


                        }

                    }


                }

                else {
                    System.out.println("");
                    System.out.println("Invalid Login Details! ");
                }

            }

            else if (choice == 2) {                          //visitor


                while(true) {
                    System.out.println();
                    System.out.println("1.Register");
                    System.out.println("2.Login");
                    System.out.println("3.Exit");
                    System.out.println();
                    System.out.print("Enter Your Choice: ");
                    int choice1 = input.nextInt();
                    input.nextLine();

                    if (choice1<1 || choice1>3) {
                        System.out.println();
                        System.out.println("Invalid Choice! Try Again.");

                    }

                    else if (choice1 == 3) {
                        System.out.println("");

                        break;
                    }

                    else if (choice1 == 1) {              //register
                        System.out.println();
                        System.out.print("Enter Visitor Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter Visitor Age: ");
                        int age = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter Visitor Phone Number: ");
                        String phone = input.nextLine();
                        System.out.print("Enter Visitor Balance: ");
                        double balance = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter Visitor Email: ");
                        String email = input.nextLine();
                        System.out.print("Enter Visitor Password: ");
                        String password = input.nextLine();


                        boolean statt = zoo.checkVisitorEnroll(email);



                        if (statt == true) {
                            System.out.println("");
                            System.out.println("This email Id is already in use! Please use another one.");
                        }

                        else {
                            if (balance>0) {
                                ArrayList<Ticket> mytickets = new ArrayList<Ticket>();
                                Visitor visitor = new Visitor(name, age, phone, balance, email, password, mytickets);
                                visitors.add(visitor);
                                System.out.println("Registration is successful.");

                            }
                            else {
                                System.out.println("Balance should be greater than zero!");
                            }

                        }
                    }

                    else if (choice1 == 2) {            //login
                        System.out.println();
                        System.out.print("Enter Visitor Email: ");
                        String email = input.nextLine();
                        System.out.print("Enter Visitor Password: ");
                        String pass = input.nextLine();

                        boolean vistat = zoo.checkVisitor(email, pass);

                        if (vistat == false) {
                            System.out.println();
                            System.out.println("Invalid Login Info!");
                        }

                        else {
                            System.out.println("");
                            System.out.println("Login Successful.");

                            int choice2 = 1;
                            while(true) {

                                System.out.println("");
                                System.out.println("Visitor Menu:");
                                System.out.println("1. Explore the Zoo");
                                System.out.println("2. Buy Membership");
                                System.out.println("3. Buy Tickets");
                                System.out.println("4. View Discounts");
                                System.out.println("5. View Special Deals");
                                System.out.println("6. Visit Animals");
                                System.out.println("7. Visit Attractions");
                                System.out.println("8. Leave Feedback");
                                System.out.println("9. Log Out");
                                System.out.println("");
                                System.out.println();
                                System.out.print("Enter your choice: ");
                                choice2 = input.nextInt();
                                input.nextLine();

                                if (choice2<1 || choice2>9) {
                                    System.out.println();
                                    System.out.println("Invalid Choice! Try Again.");
                                }

                                else if (choice2 == 9) {
                                    System.out.println("");
                                    System.out.println("Logged Out.");
                                    break;
                                }

                                else if (choice2 == 1) {        //explore zoo

                                    while (true) {
                                        System.out.println();
                                        System.out.println("Explore The Zoo: ");
                                        System.out.println("1. View Attractions");
                                        System.out.println("2. View Animals");
                                        System.out.println("3. Exit");
                                        System.out.println("");
                                        System.out.print("Enter your choice: ");
                                        int choice3 = input.nextInt();
                                        input.nextLine();

                                        if (choice3<1 || choice3>3) {
                                            System.out.println();
                                            System.out.println("Invalid Choice!");
                                        }

                                        else if (choice3 == 3) {
                                            break;
                                        }

                                        else if (choice3 == 1) {      //view Attractions
                                            System.out.println();
                                            zoo.viewattvisitor();
                                            System.out.println();

                                            System.out.print("Enter your choice: ");
                                            int choice4 = input.nextInt();
                                            input.nextLine();

                                            if (zoo.checkattraction(choice4) == true) {
                                                zoo.viewAttdesc(choice4);

                                            }

                                            else {
                                                System.out.println("Invalid choice!");
                                            }


                                        }

                                        else if (choice3 == 2) {        //view animals
                                            System.out.println();
                                            zoo.viewAnimals();
                                            System.out.println();
                                            System.out.print("Enter Animal's name: ");
                                            String choice4 = input.nextLine();

                                            if (zoo.checkAnimal(choice4)) {
                                                zoo.viewAniminfo(choice4);
                                            }
                                            else {
                                                System.out.println("Invalid choice!");
                                            }


                                        }





                                    }


                                }

                                else if (choice2 == 2) {        //buy membership
                                    System.out.println();
                                    System.out.println("Buy Membership: ");
                                    System.out.println("1. Basic Membership (₹20)");
                                    System.out.println("2. Premium Membership (₹50)");
                                    System.out.print("Enter your choice: ");
                                    int choice3 = input.nextInt();
                                    input.nextLine();

                                    if (choice3 == 1) {         //basic

                                        int memstatus = zoo.visitorMem(email);

                                        if (memstatus == choice3) {
                                            System.out.println();
                                            System.out.println("You already have Basic Membership.");
                                        }
                                        else {
                                            System.out.println("");
                                            System.out.print("Apply Discount Code: ");
                                            String code = input.nextLine();
                                            zoo.buybasic2(email, code);



                                        }
                                    }

                                    else if (choice3 == 2) {        //premium

                                        int memstatus = zoo.visitorMem(email);

                                        if (memstatus == choice3) {
                                            System.out.println();
                                            System.out.println("You already have Premium Membership.");
                                        }

                                        else {
                                            System.out.println("");
                                            System.out.print("Apply Discount Code: ");
                                            String code = input.nextLine();

                                            zoo.buyPremium2(email, code);
                                        }

                                    }

                                    else {
                                        System.out.println("Invalid choice!");
                                    }

                                }

                                else if (choice2 == 3) {            //buy tickets
                                    System.out.println();
                                    System.out.print("Enter the number of tickets: ");
                                    int noof = input.nextInt();
                                    input.nextLine();

                                    System.out.println();
                                    System.out.println("Select an Attraction to Buy a Ticket:");
                                    zoo.viewattvisitor2();
                                    System.out.print("Enter your choice: ");
                                    int choice3 = input.nextInt();
                                    input.nextLine();
                                    System.out.print("Apply Discount Code: ");
                                    String code = input.nextLine();

                                    int memstatus = zoo.visitorMem(email);
                                    if (memstatus<1) {
                                        System.out.println("You Don't have a Membership.");
                                    }

                                    else if (memstatus == 2) {
                                        System.out.println("You already have a Premium Membership.");
                                    }

                                    else {

                                        if (zoo.checkattraction(choice3) == true) {

                                            if (zoo.checkattstatus(choice3) == true) {
                                                double price = zoo.getattprice(choice3);
                                                Ticket t1 = new Ticket(choice3, price);
                                                boolean statt = zoo.ticketmoneyded(email, code, noof, t1);
                                                if (statt == true) {
                                                    zoo.setvisittotrue(email);

                                                    for (int i = 0; i < noof; i++) {
                                                        System.out.println();
                                                        zoo.buyticket(email, t1);

                                                    }
                                                }

                                            } else {
                                                System.out.println("The Attraction is closed right now!");
                                            }
                                        }
                                        else {
                                            System.out.println("The attraction doesn't exist!");
                                        }

                                    }




                                }

                                else if (choice2 == 4) {           //view discounts
                                    System.out.println();
                                    zoo.viewdiscounts();
                                }


                                else if (choice2 == 5) {           // view special deals
                                    System.out.println();
                                    zoo.viewDeals();
                                }


                                else if (choice2 == 6) {        //visit animals
                                    System.out.println("");
                                    System.out.println("Visit Animals: ");

                                    while (true) {
                                        System.out.println();
                                        System.out.println("Select an Animal to visit: ");
                                        zoo.viewAnimals();
                                        System.out.println("   Exit");
                                        System.out.println("");
                                        System.out.print("Enter Animal Name: ");
                                        String choice3 = input.nextLine();

                                        if (choice3.equalsIgnoreCase("Exit")) {
                                            break;
                                        }

                                        boolean stat = zoo.checkAnimal(choice3);

                                        boolean visstat = zoo.checkbasic(email);

                                        if (visstat == true) {
                                            if (stat == false) {
                                                System.out.println("Invalid choice!");
                                            }

                                            else {
                                                System.out.println("");
                                                zoo.visitAnimal(choice3);


                                            }
                                        }
                                        else {
                                            System.out.println("You Don't have a Membership.");
                                        }

                                    }

                                }

                                else if (choice2 == 7) {        //visit attractions
                                    System.out.println();
                                    System.out.println("Visit Attractions: ");

                                    while (true) {
                                        System.out.println();
                                        System.out.println("Select an Attraction to visit: ");
                                        zoo.viewattvisitor();
                                        int exit = zoo.getLastAttId();
                                        System.out.println(zoo.getLastAttId()+". Exit");
                                        System.out.println("");
                                        System.out.print("Enter your choice: ");
                                        int choice3 = input.nextInt();
                                        input.nextLine();

                                        int memstat = zoo.visitorMem(email);

                                        if (choice3 == exit) {
                                            break;
                                        }

                                        if (memstat == 0) {
                                            System.out.println("You Don't have a membership.");
                                        }

                                        else if (memstat == 1) {
                                            if (zoo.checkattstatus(choice3) == true) {
                                                if (zoo.checkTicket(email, choice3)) {
                                                    System.out.println("1 Ticket Used.");
                                                    System.out.println("Welcome to "+zoo.getattname(choice3)+". Hope you enjoyed the attraction.");
                                                    zoo.useTicket(email, choice3);
                                                    zoo.addCount(choice3);

                                                    break;
                                                }
                                                else {
                                                    System.out.println("Ticket not available.");
                                                }

                                            }

                                            else {
                                                System.out.println("Sorry, this attraction is closed right now.");
                                            }

                                        }

                                        else if (memstat == 2) {
                                            if (zoo.checkattstatus(choice3) == true) {
                                                System.out.println("Welcome to "+zoo.getattname(choice3)+". Hope you enjoyed the attraction.");
                                                zoo.setvisittotrue(email);
                                                zoo.addCount(choice3);
                                                break;

                                            }

                                            else {
                                                System.out.println("Sorry, this attraction is closed right now.");
                                            }


                                        }


                                    }




                                }


                                else if (choice2 == 8) {       //leave feedback

                                    System.out.println();
                                    System.out.print("Enter your feedback (max 200 characters): ");
                                    String feed = input.nextLine();

                                    int size = feed.length();

                                    if (size<1 || size>200) {
                                        System.out.println("Illegal feedback length! Please try again.");
                                    }

                                    else {
                                        zoo.addFeedback(email, feed);
                                        System.out.println("Thank you for your feedback.");
                                    }

                                }






                            }





                        }



                    }
                }
            }


            else {

                System.out.println("Invalid Choice!");
            }



        }





    }
}
