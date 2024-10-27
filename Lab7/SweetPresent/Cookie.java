public class Cookie extends Item
{
    private boolean filling;
    public Cookie(double weight, double price, String name, double sugar, boolean filling)
    {
        super(weight, price, name, sugar);
        this.filling = filling;
    }

    public boolean isFilling()
    {
        return filling;
    }

    @Override
    public String toString() {
        return "Cookie: " + super.toString() +
                ", filling = " + filling;
    }
}
