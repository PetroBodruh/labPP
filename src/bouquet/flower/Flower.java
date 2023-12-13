package bouquet.flower;

public class Flower {
    String name;
    double price;
    int freshnessLevel;
    double stemLength;

    public Flower(String name, double price, int freshnessLevel, double stemLength) {
        this.name = name;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public double getStemLength() {
        return stemLength;
    }
}
