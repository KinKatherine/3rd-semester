import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer
{
    public static void writePresentInFile(ArrayList<Item> collection, String fileName) {

        try(FileWriter writer = new FileWriter(fileName,false);)
        {
            writer.write(Helper.collectionToString(collection));
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
