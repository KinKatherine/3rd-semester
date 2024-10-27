import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

public class MyPanel extends JPanel
{
    private ArrayList<Item> allSweets = new ArrayList<>();
    private Present present = new Present();

    int size = 20;
    String name = "Courier";
    JLabel firstLabel = new JLabel("New Year's gift");
    JTextArea fileText = new JTextArea();
    JTextArea resText = new JTextArea();

    JButton groupButton = new JButton("group");
    JButton priceButton = new JButton("price");
    JButton cookieButton = new JButton("cookie");
    JButton candyButton = new JButton("candy");
    JButton chocolateButton = new JButton("chocolate");
    JButton openButton = new JButton("open");
    JButton saveButton = new JButton("save");
    JButton addButton = new JButton("add");
    JButton deleteButton = new JButton("delete");
    JButton sortButton = new JButton("sort");
    JButton collectButton = new JButton("collect");
    JButton findButton = new JButton("find");

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

        groupButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        groupButton.setBackground(Color.LIGHT_GRAY);

        candyButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        candyButton.setBackground(Color.LIGHT_GRAY);

        priceButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        priceButton.setBackground(Color.LIGHT_GRAY);

        cookieButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        cookieButton.setBackground(Color.LIGHT_GRAY);

        chocolateButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        chocolateButton.setBackground(Color.LIGHT_GRAY);

        findButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        findButton.setBackground(Color.LIGHT_GRAY);

        collectButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        collectButton.setBackground(Color.LIGHT_GRAY);

        openButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        openButton.setBackground(Color.LIGHT_GRAY);

        addButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        addButton.setBackground(Color.LIGHT_GRAY);

        sortButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        sortButton.setBackground(Color.LIGHT_GRAY);

        saveButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        saveButton.setBackground(Color.LIGHT_GRAY);

        deleteButton.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
        deleteButton.setBackground(Color.LIGHT_GRAY);

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

    private JPanel createFourthPanel()
    {
        JPanel fourthPanel = new JPanel();
        fourthPanel.setLayout(new FlowLayout());
        fourthPanel.add(openButton);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileOpen.getSelectedFile();
                    allSweets.addAll(allSweets.size(),Reader.createSweets(file.toString()));
                    fileText.setText(Helper.collectionToString(allSweets));
                }
            }
        });

        fourthPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!present.isEmpty())
                {
                    JFileChooser fileOpen = new JFileChooser();
                    int ret = fileOpen.showDialog(null, "Сохранить в файл");
                    if (ret == JFileChooser.APPROVE_OPTION)
                    {
                        File file = fileOpen.getSelectedFile();
                        Writer.writePresentInFile(present.getPresentSweets(),file.toString());
                    }
                }
                else
                {
                    showError("Collect the gift");
                }
            }
        });

        fourthPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String string = "";

                    String weight = JOptionPane.showInputDialog("Inter weight");
                    String price = JOptionPane.showInputDialog("Inter prise");
                    String name = JOptionPane.showInputDialog("Inter name");
                    String sugar = JOptionPane.showInputDialog("Inter sugar");
                    String extra = JOptionPane.showInputDialog("Inter color (BLUE,YELLOW,PINK,GREEN) or\n" +
                            "type(MILK,BITTER,WHITE) or \n" +
                            "filling(true,false)");

                    string = weight + " " + price + " " + name + " " + sugar + " " + extra;
                    Item item = Reader.parseToItem(string);
                    allSweets.add(item);
                    present.add(item);
                    fileText.append(item.toString());
                    resText.setText(null);
                    resText.append(Helper.collectionToString(present.getPresentSweets()));
                }catch (NumberFormatException exception)
                {
                    showError("Inter correct data");
                }
                catch (NullPointerException exception)
                {
                }
            }
        });

        fourthPanel.add(collectButton);
        collectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!allSweets.isEmpty())
                {
                    try
                    {
                        double weight = Double.parseDouble(JOptionPane.showInputDialog("Inter weight of present"));
                        present = Factory.createPresent(allSweets,weight);
                        resText.setText(null);
                        resText.append("Weight of present: "+weight+"\n");
                        resText.append(Helper.collectionToString(present.getPresentSweets()));
                        if(present.isEmpty())
                        {
                            showError("Increase the weight");
                        }
                    }catch (NumberFormatException exception)
                    {
                        showError("Inter correct data");
                    }

                }
                else
                {
                    showError("Download data");
                }
            }
        });

        fourthPanel.add(sortButton);
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(present.getPresentSweets(),new ComparatorByWeight());
                if(!present.isEmpty())
                {
                    resText.setText(null);
                    resText.append(Helper.collectionToString(present.getPresentSweets()));
                }else
                {
                    showError("Collect the gift");
                }

            }
        });

        fourthPanel.add(findButton);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(!present.isEmpty())
                    {
                        double inf = Double.parseDouble(JOptionPane.showInputDialog("Inter lower bound of sugar"));
                        double sup = Double.parseDouble(JOptionPane.showInputDialog("Inter upper bound of sugar"));
                        Predicate<Item> predicate = i -> i.getSugar() >= inf && i.getSugar()<= sup;
                        //Predicate<Student> predicate = i -> i.getName().equals("Kate");
                        Set<Item> collection = present.findSweetBySugar(predicate);
                        resText.setText(null);
                        resText.append(Helper.collectionToString(collection));
                    }
                    else
                    {
                        showError("Collect the gift");
                    }
                }catch (NumberFormatException exception)
                {
                    showError("Inter correct data");
                }
                catch (NullPointerException exception)
                {
                }
            }
        });

        fourthPanel.add(groupButton);
        groupButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!present.isEmpty())
                {
                    try
                    {
                        double weight = Double.parseDouble(JOptionPane.showInputDialog("Inter weight of sweet"));
                        resText.setText(Helper.mapByKeyToString(present.groupSweetsByWeight(),weight));

                        if(resText == null)
                        {
                            showError("There is no sweet of this weight");
                        }
                    }catch (NumberFormatException exception)
                    {
                        showError("Inter correct data");
                    }

                }else
                {
                    showError("Collect the gift");
                }
            }
        });

        fourthPanel.add(priceButton);
        priceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!present.isEmpty())
                {
                    double prise = 0;
                    for (Item i: present.getPresentSweets())
                    {
                        prise += i.getPrice();
                    }
                    resText.append("Price of the present is " + prise);

                }
                else
                {
                    showError("Collect the gift");
                }
            }
        });

        fourthPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resText.setText(null);
            }
        });

        fourthPanel.add(candyButton);
        candyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!present.isEmpty())
                {
                    double persent =  present.getProsInPresent(ItemType.CANDY);
                    resText.append("Percent of candies: " + String.format("%.2f", persent) + "\n");

                    double weight = present.getWeightInPresent(ItemType.CANDY);
                    resText.append("Weight of candies: " + weight+"\n");
                }
                else
                {
                    showError("Collect the gift");
                }
            }
        });

        fourthPanel.add(cookieButton);
        cookieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!present.isEmpty())
                {
                    double persent =  present.getProsInPresent(ItemType.COOKIE);
                    resText.append("Percent of cookies: " + String.format("%.2f", persent) + "\n");

                    double weight = present.getWeightInPresent(ItemType.COOKIE);
                    resText.append("Weight of cookies: " + weight+"\n");
                }
                else
                {
                    showError("Collect the gift");
                }
            }

        });

        fourthPanel.add(chocolateButton);
        chocolateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!present.isEmpty())
                {
                    double persent =  present.getProsInPresent(ItemType.CHOCOLATE);
                    resText.append("Percent of chocolates: " + String.format("%.2f", persent) + "\n");

                    double weight = present.getWeightInPresent(ItemType.CHOCOLATE);
                    resText.append("Weight of chocolates: " + weight+"\n");
                }
                else
                {
                    showError("Collect the gift");
                }
            }
        });

        return fourthPanel;
    }

    public static void showError(String string)
    {
        JOptionPane.showMessageDialog(null,string,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
