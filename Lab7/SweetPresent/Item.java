

public class Item
{
    private double weight;
    private  double price;
    private String name;
    private double sugar;

    public Item(double weight, double price, String name, double sugar)
    {
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.sugar = sugar;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getSugar() {
        return sugar;
    }

    @Override
    public String toString()
    {
        return "weight = " + weight + " gr" +
                ", price = " + price + " coins" +
                ", name = " + name +
                ", sugar = " + sugar + " %";
    }

}
