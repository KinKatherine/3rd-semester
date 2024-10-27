import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new MyFrame("New Year's gift");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}