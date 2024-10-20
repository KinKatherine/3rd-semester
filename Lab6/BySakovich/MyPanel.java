import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyPanel extends JPanel
{
    private Student student;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Student> duplicatedStudents = new ArrayList<>();

    int size = 20;
    String name = "Courier";
    JLabel deanLabel = new JLabel("Dean's Office");
    JTextArea fileText = new JTextArea();
    JTextArea resText = new JTextArea();
    JButton openButton = new JButton("open file");
    JButton saveButton = new JButton("add");
    JButton addButton = new JButton("add student");
    JButton deleteButton = new JButton("delete");
    JButton sortButton = new JButton("sort students");
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

        deanLabel.setBorder(new EmptyBorder(0,10,0,0));
        deanLabel.setFont(new Font(name, Font.BOLD | Font.ITALIC, size));
    }

    private JPanel createFirstPanel()
    {
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        firstPanel.add(deanLabel);
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
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser fileOpen = new JFileChooser();
                int ret = fileOpen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileOpen.getSelectedFile();
                    readFile(file.getName());
                }
            }
        });

        fourthPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(students.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Download data","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try
                {
                    int course = Integer.parseInt(JOptionPane.showInputDialog("Inter course"));
                    int group = Integer.parseInt(JOptionPane.showInputDialog("Inter group"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Inter id"));
                    String surname = JOptionPane.showInputDialog("Inter surname");
                    if(!surname.matches("[a-zA-Z]+"))
                    {
                        JOptionPane.showMessageDialog(null,"Enter correct surname","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    for (Student i :students)
                    {
                        if(i.getId()==id)
                        {
                            JOptionPane.showMessageDialog(null,"id must be unique!","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    student = new Student(id,surname,course,group);
                    students.add(student);
                    fileText.setText(null);
                    resText.setText(null);
                    printStudents(students);

                }
                catch (NumberFormatException a)
                {
                    JOptionPane.showMessageDialog(null,"Enter correct data","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        fourthPanel.add(sortButton);
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                createDuplicatedStudents();
                Collections.sort(duplicatedStudents, new MixedComparator());
                for (Student i: duplicatedStudents)
                {
                    resText.append(i.toString());
                }
            }
        });

        fourthPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                resText.setText(null);
            }
        });
        return fourthPanel;
    }

     public void readFile(String fileName)
     {
         students.clear();
         try
         {
             BufferedReader reader = new BufferedReader(new FileReader(fileName));
             String line;
             while ((line = reader.readLine()) != null)
             {
                 String[] words = line.split("\\s");
                 if(words.length == 4)
                 {
                     Student student = new Student(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]));
                     students.add(student);
                 }
             }
             reader.close();
         } catch (IOException e)
         {
             JOptionPane.showMessageDialog(null,"Problems with file!","Error",JOptionPane.ERROR_MESSAGE);
         }
         fileText.setText(null);
         printStudents(students);
     }

     private void printStudents(ArrayList<Student> students)
     {
         for (Student i :students)
         {
             fileText.append(i.toString());
         }
     }

     private void createDuplicatedStudents()
     {
         duplicatedStudents.clear();
         resText.setText(null);
         Set<Student> seen = new HashSet<>();
         for (int i = 0; i < students.size() - 1; i++)
         {
             for (int j = i + 1; j < students.size(); j++)
             {
                 if (students.get(i).getSurname().equals(students.get(j).getSurname()))
                 {
                     if (!seen.contains(students.get(i)))
                     {
                         duplicatedStudents.add(students.get(i));
                         seen.add(students.get(i));
                     }
                     if (!seen.contains(students.get(j)))
                     {
                         duplicatedStudents.add(students.get(j));
                         seen.add(students.get(j));
                     }
                 }
             }
         }
     }
}
