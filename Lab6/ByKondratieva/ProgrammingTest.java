import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class ProgrammingTest
{
    public static void main(String[] args)
    {
        Set<Student> students =  new HashSet<>();
        Academic firstAcademic = new Academic("Paul Deitel");
        Academic secondAcademic = new Academic("Cay Horstmann");
        Undergraduate firstUG = new Undergraduate("Ivan","gg4","firstUGMail@tut.by", firstAcademic );
        Undergraduate secondUG = new Undergraduate("Kate","pr3","secondUGMail@tut.by", secondAcademic);
        Postgraduate firstPG = new Postgraduate("Kate","te2","firstPGMail@tut.by",firstAcademic);
        Postgraduate secondPG = new Postgraduate("Lena","yj34","secondPGMail@tut.by",secondAcademic);
        Postgraduate thirdPG = new Postgraduate("Anna","jj8","thirdPGMail@tut.by",secondAcademic);
        students.add(firstUG);
        students.add(secondUG);
        students.add(firstPG);
        students.add(secondPG);
        students.add(thirdPG);
        Course course = new Course("Math",students);
        System.out.println("\nCourse:");
        Iterator<Student> it = course.iterator();
        while (it.hasNext())
        {
            Student elem = it.next();
            System.out.printf(elem.toString()+"\n");
        }

        System.out.println("\nPostgraduates with supervisor Cay Horstmann:");
        for(Postgraduate i:course.getPostgraduate("Cay Horstmann"))
        {
            System.out.println(i.toString());
        }

        System.out.println("\nNotify students with message “Hello, Students!”:");
        Notifier notifier = new Notifier(students);
        notifier.doNotifyAll("“Hello, Students!”");

        Writer writer = new Writer("output.txt");
        writer.saveToFile(course);

        System.out.println("\nStudents by predicate:");
        Predicate<Student> predicate = i -> i.getName().equals("Kate");
        for(Student i:course.findPredicateStudents(predicate))
        {
            System.out.println(i.toString());
        }

        course.addStudent(new Student("Alex","kj7","*****Mail@tut.by"),new Academic("Adam Kei"),true);
        System.out.println("\nCourse:");
        Iterator<Student> iterator = course.iterator();
        while (iterator.hasNext())
        {
            Student elem = iterator.next();
            System.out.printf(elem.toString()+"\n");
        }
    }
}