import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader
{
    public static ArrayList<Item> createSweets(String fileName)
    {
        ArrayList<Item> collection = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                Item item = parseToItem(line);
                if (item != null)
                {
                    collection.add(item);
                }
            }
        } catch (IOException e)
        {
        }
        return collection;
    }

    public static Item parseToItem(String str)
    {
        String[] words = str.split("\\s");
        if (words.length == 5)
        {
            double weight;
            double price;
            double sugar;
            boolean filling = true;

            try
            {
                weight = Double.parseDouble(words[0]);
                price = Double.parseDouble(words[1]);
                String name = words[2];

                if(name.matches("[a-zA-Z]+"))
                {
                    sugar = Double.parseDouble(words[3]);

                    CandyColourType color = null;
                    ChocolateType type = null;

                    try
                    {
                        color = CandyColourType.valueOf(words[4]);
                    } catch (IllegalArgumentException e)
                    {

                    }

                    try
                    {
                        type = ChocolateType.valueOf(words[4]);
                    } catch (IllegalArgumentException e)
                    {
                    }

                    try
                    {
                        filling = Boolean.parseBoolean(words[4]);
                    }
                    catch (IllegalArgumentException exception)
                    {
                    }

                    if (color != null)
                    {
                        return new Candy(weight, price, name, sugar, color);

                    } else if (type != null)
                    {
                        return new Chocolate(weight, price, name, sugar, type);
                    } else if(filling || !filling)
                    {
                        return new Cookie(weight,price,name,sugar,filling);
                    }
                } else
                {
                    MyPanel.showError("Enter correct name");
                }
            } catch (NumberFormatException e)
            {
            }
        }
        return null;
    }
}
