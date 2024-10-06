import java.io.FileWriter;
import java.io.IOException;

public abstract class Series
{
    protected   double start;
    protected   double step;

    Series(double start, double step)
    {
        this.start = start;
        this.step = step;
    }

    public abstract double calculateElement(int num); // абстрактный метод
    public  double calculateSum(int count)
    {
        double sum = 0;
        for(int i = 1; i <= count; i++)
        {
            sum += calculateElement(i);
        }
        return  sum;
    }

    public  String convertToString(int count)
    {
        StringBuffer string = new StringBuffer();
        for(int i = 1; i <= count; i++)
        {
            string.append(calculateElement(i));
            string.append(" ");
        }
        return string.toString();
    }

    public void saveToFile(String string) throws IOException // записать в файл строку
    {
        try {
            FileWriter writer = new FileWriter("output", true);
            writer.write(string);
            writer.write("\n");
            writer.close();

        } catch (IOException e)
        {
            System.err.println("Recording error");
        }
    }

}
