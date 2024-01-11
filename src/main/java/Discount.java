public class Discount {
    private String category;
    private int percent;
    private String code;

    // Constructor
    public Discount(String category, int percent, String code) {
        this.category = category;
        this.percent = percent;
        this.code = code;
    }

    // Getters
    public String getCategory() {
        return category;
    }

    public int getPercent() {
        return percent;
    }

    public String getCode() {
        return code;
    }

    // Setters
    public void setCategory(String category) {
        this.category = category;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


