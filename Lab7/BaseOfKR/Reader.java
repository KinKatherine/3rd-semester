import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader
{
    public static ArrayList<Student> createStudents(String fileName)
    {
        ArrayList<Student> arrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                Student student = parseToStudent(line);
                if (student != null)
                {
                    arrayList.add(student);
                }
            }
        } catch (IOException e)
        {
            //todo
        }
        return arrayList;
    }

    public static Student parseToStudent(String str)
    {
        String[] words = str.split("\\s");
        if (words.length == 4)
        {
            try
            {
                String surname = words[0];
                int course = Integer.parseInt(words[1]);
                double averageScore = Double.parseDouble(words[2]);
                double scholarship = 0;
                int orderNumber = 0;

                if(surname.matches("[a-zA-Z]+"))
                {
                    try
                    {
                        orderNumber = Integer.parseInt(words[3]);
                        return new ExpelledStudent(surname,course,averageScore,orderNumber);

                    } catch (IllegalArgumentException e)
                    {
                        try
                        {
                            scholarship = Double.parseDouble(words[3]);
                            return new StudentWithIncreasedScholarship(surname,course,averageScore,scholarship);
                        }
                        catch (IllegalArgumentException exception)
                        {
                        }
                    }

                }
            } catch (NumberFormatException e)
            {
            }
        }
        return null;
    }

    public static ArrayList<Number> createNumbers(String fileName)
    {
        ArrayList<Number> arrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.split("\\s");
                for(String i: words)
                {
                    Number number = parseToNumber(i);
                    if (number != null)
                    {
                        arrayList.add(number);
                    }
                }
            }
        } catch (IOException e)
        {
            //todo
        }
        return arrayList;
    }

    public static Number parseToNumber(String str)
    {
        String[] words = str.split("\\s");
        try
        {
            double number = Double.parseDouble(words[0]);
            return number;
        } catch (NumberFormatException e)
        {
        }
        return null;
    }
}
