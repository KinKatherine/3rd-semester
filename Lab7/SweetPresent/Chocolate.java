public class Chocolate extends Item
{
    private ChocolateType type;

    public Chocolate(double weight, double price, String name, double sugar, ChocolateType type)
    {
        super(weight,price,name,sugar);
        this.type = type;
    }

    public ChocolateType getType() {
        return type;
    }

    @Override
    public String toString()
    {
        return "Chocolate: " + super.toString() +
                ", type = " + type;
    }
}
