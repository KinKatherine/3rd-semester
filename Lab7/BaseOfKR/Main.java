import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new MyFrame("Container boundaries");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}