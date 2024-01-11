public class Attraction {
    private int Id;
    private String name;
    private Boolean status;   // true for open, false for closed
    private String desc;
    private int count;
    private double price;

    Attraction(int Id,String name,String desc, double price) {
        this.Id = Id;
        this.name=name;
        this.status=true;
        this.desc=desc;
        this.count=0;
        this.price=price;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        if (status == true) {
            return "open";
        }
        else {
            return "closed";
        }
    }

    public boolean getstatus2() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String newname) {
        name = newname;

    }

    public void setDesc(String newdesc) {
        desc = newdesc;
    }

    public void setStatus(Boolean stat) {
        status = stat;
    }

    public void addvisitor() {
        count++;
    }

    public void setPrice(int price1) {
        price = price1;
    }

    public void addcount() {
        count++;


    }



}
