import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    public MyFrame(String title) throws HeadlessException
    {
        super(title);
        setLayout(new GridLayout(1,1,20,20));
        JPanel panel = new MyPanel();
        add(panel);
    }
}
