public class Liner extends Progression
{
    Liner(int start, int step)
    {
        super(start, step);
    }

    public int calculateElement(int number)
    {
        return super.getStart() +(number - 1) * super.getStep();
    }


    public String extraConvertToString(int count) {
        return "Line: " + super.convertToString(count);
    }

}
