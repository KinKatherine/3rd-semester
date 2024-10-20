import javax.swing.*;
import java.util.Objects;

// вариант 4

public  class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new MyFrame("Dean's Office");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("picture.png")));
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setVisible(true);
    }
}