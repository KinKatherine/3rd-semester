import java.util.ArrayList;
import java.util.Collection;

public class Helper
{
    public static String studetsToString(ArrayList<Student> collection)
    {
        StringBuffer string = new StringBuffer();
        for(Student i: collection)
        {
            string.append(i.toString());
            string.append("\n");
        }
        return string.toString();
    }

    public static String numbersToString(ArrayList<Number> collection)
    {
        StringBuffer string = new StringBuffer();
        for(Number i: collection)
        {
            string.append(i.toString());
            string.append(" ");
        }
        return string.toString();
    }
}
