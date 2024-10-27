public class Candy extends Item
{
    private CandyColourType colour;

    public Candy(double weight, double price, String name, double sugar, CandyColourType colour)
    {
        super(weight, price, name, sugar);
        this.colour = colour;
    }


    public CandyColourType getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Candy: " + super.toString() +
                ", colour = " + colour;
    }
}
