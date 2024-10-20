import java.io.FileWriter;
import java.io.IOException;

public class Writer
{
    private String fileName;

    Writer(String fileName)
    {
        this.fileName = fileName;
    }

    public void saveToFile(Course course)
    {
        try(FileWriter writer = new FileWriter(fileName,false))
        {
            writer.write(course.courseToString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
