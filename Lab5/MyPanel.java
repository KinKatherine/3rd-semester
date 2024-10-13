import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel
{
    private Progression progression;

    int size = 20;
    String name = "Courier";

    JButton findButton = new JButton("find n element");
    JButton deleteButton = new JButton("clear");
    JButton printSeriesButton = new JButton("print series");
    JButton saveSeriesButton = new JButton("save series");
    JButton printSumButton = new JButton("print sum");
    JButton saveSumButton = new JButton("save sum");
    JTextField startField = new JTextField();
    JTextField stepField = new JTextField();
    JTextField countField = new JTextField();
    JTextArea textArea = new JTextArea();
    JLabel startLabel = new JLabel("Input start");
    JLabel stepLabel = new JLabel("Input step");
    JLabel countLabel = new JLabel("Input n");
    JLabel welcomeLabel = new JLabel("Progression calculator!");
    JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JComboBox<String> comboBox = new JComboBox<>(new String[]{"Linear progression","Exponential progression"});

    public MyPanel()
    {
        GridLayout gridLayout = new GridLayout(4, 1,20,20);
        setLayout(gridLayout);
        add(createFirstPanel());
        add(createSecondPanel());
        add(createThirdPanel());
        add(createFourthPanel());
        Initialize();
    }

    private void Initialize() {

        printSeriesButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        printSeriesButton.setBackground(Color.LIGHT_GRAY);

        saveSeriesButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        saveSeriesButton.setBackground(Color.LIGHT_GRAY);

        printSumButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        printSumButton.setBackground(Color.LIGHT_GRAY);

        saveSumButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        saveSumButton.setBackground(Color.LIGHT_GRAY);

        findButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        findButton.setBackground(Color.LIGHT_GRAY);

        deleteButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        deleteButton.setBackground(Color.LIGHT_GRAY);

        textArea.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        startField.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));

        stepField.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));

        countField.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));

        comboBox.setFont(new Font(name, Font.BOLD, size));
        comboBox.setBorder(new EmptyBorder(0,10,0,10));

        startLabel.setBorder(new EmptyBorder(0,10,0,0));
        startLabel.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));

        stepLabel.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        stepLabel.setBorder(new EmptyBorder(0,10,0,0));

        countLabel.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        countLabel.setBorder(new EmptyBorder(0,10,0,0));

        welcomeLabel.setFont(new Font(name, Font.BOLD, size+10));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private JPanel createFourthPanel()
    {
        JPanel fourthPanel4 = new JPanel();
        fourthPanel4.setLayout(new GridLayout(3, 2, 20, 20));

        fourthPanel4.add(printSeriesButton);
        printSeriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea.setText(null);
                createProgression();
                textArea.append("Elements: "+ progression.convertToString(Integer.parseInt(countField.getText()))+"\n");
            }
        });

        fourthPanel4.add(saveSeriesButton);
        saveSeriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileDialog = new JFileChooser();
                int ret = fileDialog.showDialog(null, "Сохранить в файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileDialog.getSelectedFile();
                    createProgression();
                    try {
                        progression.saveToFile(progression.extraConvertToString(Integer.parseInt(countField.getText())), file.getAbsolutePath());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        fourthPanel4.add(printSumButton);
        printSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProgression();
                textArea.append("Sum: "+progression.calculateSum(Integer.parseInt(countField.getText()))+"\n");
            }
        });

        fourthPanel4.add(saveSumButton);
        saveSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                createProgression();
                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileOpen.getSelectedFile();
                    createProgression();
                    try {
                        progression.saveToFile("Sum: " + Integer.toString(progression.calculateSum(Integer.parseInt(countField.getText()))),file.getAbsolutePath());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        fourthPanel4.add(findButton);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProgression();
                textArea.append(countField.getText() + " element is: " + Integer.toString(progression.calculateElement(Integer.parseInt(countField.getText())))+"\n");
            }
        });

        fourthPanel4.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
            }
        });

        return fourthPanel4;
    }

    private JPanel createThirdPanel()
    {
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new GridLayout(3, 2, 20, 20));

        thirdPanel.add(startLabel);

        thirdPanel.add(startField);

        thirdPanel.add(stepLabel);

        thirdPanel.add(stepField);

        thirdPanel.add(countLabel);

        thirdPanel.add(countField);

        return thirdPanel;
    }

    private JPanel createSecondPanel()
    {
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(scroll, BorderLayout.CENTER);

        return panel2;
    }

    private JPanel createFirstPanel()
    {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1, 20, 20));
        panel1.add(welcomeLabel);

        panel1.add(comboBox);
        return panel1;
    }

    private void createProgression()
    {
        Object object = comboBox.getSelectedIndex();
        int start = 0;
        int step = 0;
        try
        {
            start = Integer.parseInt(startField.getText());
            step = Integer.parseInt(stepField.getText());
            Integer.parseInt(countField.getText());

            if (object.toString().equals("0"))
            {
                progression = new Liner(start, step);
            }
            else
            {
                progression = new Exponential(start, step);
            }
        }
        catch (NumberFormatException ex)
        {
            textArea.setText(null);
            textArea.append("Enter the correct data!");
        }

    }
}
