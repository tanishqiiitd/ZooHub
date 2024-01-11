

public class Mammal implements Animal {
    private String name;
    private String history;
    private String noise;

    Mammal(String name, String history, String noise) {

        this.name = name;
        this.history = history;
        this.noise = noise;
    }





    public String getName() {
        return name;
    }

    public String getHistory() {
        return history;
    }

    public String getNoise() {
        return noise;
    }




    public void setName(String name) {
        this.name = name;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }



}
