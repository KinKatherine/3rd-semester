import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


public class MyPanel extends JPanel
{
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private ArrayList<Number> numberArrayList = new ArrayList<>();

    int size = 20;
    String name = "Courier";
    JLabel firstLabel = new JLabel("Container boundaries");

    JTextArea fileText = new JTextArea();
    JTextArea resText = new JTextArea();

    JButton clearButton = new JButton("clear");
    JButton openStudentsButton = new JButton("open students");
    JButton openNumberButton = new JButton("open numbers");
    JButton minButton = new JButton("min");
    JButton maxButton = new JButton("max");

    JScrollPane scrollFile = new JScrollPane(fileText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollRes = new JScrollPane(resText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


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

        clearButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        clearButton.setBackground(Color.LIGHT_GRAY);

        minButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        minButton.setBackground(Color.LIGHT_GRAY);

        openStudentsButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        openStudentsButton.setBackground(Color.LIGHT_GRAY);

        openNumberButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        openNumberButton.setBackground(Color.LIGHT_GRAY);

        maxButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        maxButton.setBackground(Color.LIGHT_GRAY);

        fileText.setFont(new Font(name, Font.BOLD , size));
        fileText.setEditable(false);
        fileText.setLineWrap(true);

        resText.setFont(new Font(name, Font.BOLD, size));
        resText.setEditable(false);
        resText.setLineWrap(true);

        firstLabel.setBorder(new EmptyBorder(0,10,0,0));
        firstLabel.setFont(new Font(name, Font.BOLD | Font.ITALIC, size+20));
    }

    private JPanel createFirstPanel()
    {
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        firstPanel.add(firstLabel);
        return firstPanel;
    }

    private JPanel createSecondPanel()
    {
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(1, 1, 20, 20));
        secondPanel.add(scrollFile);
        return secondPanel;
    }

    private JPanel createThirdPanel()
    {
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new GridLayout(1, 1, 20, 20));
        thirdPanel.add(scrollRes);
        return thirdPanel;
    }

    private JPanel createFourthPanel() {
        JPanel fourthPanel = new JPanel();
        fourthPanel.setLayout(new FlowLayout());
        fourthPanel.add(openStudentsButton);
        openStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileOpen.getSelectedFile();
                    numberArrayList.clear();
                    studentArrayList.addAll(studentArrayList.size(), Reader.createStudents(file.toString()));
                    fileText.setText(Helper.studetsToString(studentArrayList));
                }
            }
        });

        fourthPanel.add(openNumberButton);
        openNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileOpen.getSelectedFile();
                    studentArrayList.clear();
                    numberArrayList.addAll(numberArrayList.size(), Reader.createNumbers(file.toString()));
                    fileText.setText(Helper.numbersToString(numberArrayList));
                }
            }
        });

        fourthPanel.add(maxButton);
        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!studentArrayList.isEmpty())
                {
                    Item<Student> item = new Item<>(studentArrayList);
                    resText.setText(item.findMax(new ComparatorByAverageScore()).toString());
                }
                else
                {
                    if(!numberArrayList.isEmpty())
                    {
                        Item<Number> item = new Item<>(numberArrayList);
                        resText.setText(item.findMax(new ComparatorByValue()).toString());
                    }
                    else
                    {
                        showError("Download data");
                    }
                }
            }
        });

        fourthPanel.add(minButton);
        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!studentArrayList.isEmpty())
                {
                    Item<Student> item = new Item<>(studentArrayList);
                    resText.setText(item.findMin(new ComparatorByAverageScore()).toString());
                }
                else
                {
                    if(!numberArrayList.isEmpty())
                    {
                        Item<Number> item = new Item<>(numberArrayList);
                        resText.setText(item.findMin(new ComparatorByValue()).toString());
                    }
                    else
                    {
                        showError("Download data");
                    }
                }

            }
        });

        fourthPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resText.setText(null);
                fileText.setText(null);
            }
        });

        return  fourthPanel;

    }

    public static void showError(String string)
    {
        JOptionPane.showMessageDialog(null,string,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
