import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        JFrame frame = new MyFrame("Series generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fr.setBounds(100,200,800,400);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);// окно - в центре экрана
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("icon.png")));// помещение иконки на frame
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setVisible(true);
    }
}