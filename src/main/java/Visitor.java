

import java.util.ArrayList;


public class Visitor {
    private String name;
    private int age;
    private String phone;
    private double balance;
    private String email;
    private String password;
    private int memship;    // 0 for none, 1 for basic, 2 for premium
    private String feedback;
    private ArrayList<Ticket> mytickets = new ArrayList<Ticket>();
    public boolean visited;

    public Visitor(String name, int age, String phone, double balance, String email, String password, ArrayList<Ticket> mytickets) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.memship = 0;
        this.feedback = "";
        this.mytickets = mytickets;
        this.visited = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMembership() {
        return memship;
    }


    public void setMembership(int memship) {
        this.memship = memship;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public void buyBasic() {
        memship = 1;

    }

    public void buyPremium() {
        memship = 2;
    }

    public void deductbalance(double diff) {
        balance -= diff;
    }

    public void addticket(Ticket t1) {
        mytickets.add(t1);
    }

    public boolean checktick(int tickid) {
        boolean stat = false;
        for (Ticket t : mytickets) {
            if (t.getId() == tickid) {
                stat = true;
            }
        }
        return stat;


    }

    public void removeTicket(int ticketId) {
        for (Ticket ticket : mytickets) {
            if (ticket.getId() == ticketId) {
                mytickets.remove(ticket);
                break;
            }
        }
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited() {
        visited = true;
    }




}


