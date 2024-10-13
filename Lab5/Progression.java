import java.io.FileWriter;
import java.io.IOException;

public abstract class Progression
{
    private int start;
    private int step;

    Progression(int start, int step)
    {
        this.start = start;
        this.step = step;
    }

    public abstract int calculateElement(int num); // абстрактный метод
    public abstract String extraConvertToString(int count);

    public int getStart()
    {
        return start;
    }

    public int getStep()
    {
        return step;
    }

    public void setStep(int step)
    {
        this.step = step;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public  int calculateSum(int count)
    {
        int sum = 0;
        for(int i = 1; i <= count; i++)
        {
            sum += calculateElement(i);
        }
        return  sum;
    }

    public String convertToString(int count)
    {
        StringBuffer string = new StringBuffer();
        for(int i = 1; i <= count; i++)
        {
            string.append(calculateElement(i));
            string.append(" ");
        }
        return string.toString();
    }

    public void saveToFile(String string, String filePath) throws IOException // записать в файл строку
    {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(string);
            writer.write("\n");
            writer.close();

        } catch (IOException e)
        {
            System.err.println("Recording error");
        }
    }

}
