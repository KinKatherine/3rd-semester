import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class Course implements Iterable<Student>
{
    private Set<Student> allStudents;
    private String course;

    Course(String name,Set<Student> students)
    {
        this.course = name;
        this.allStudents = students;
    }

    public void addStudent(Student student,Academic academic, boolean isUndergraduate) // в ГИ будет соmboBox без 3 параметра
    {
        if(isUndergraduate)
        {
            Undergraduate thidrUG = new Undergraduate(student.getName(),student.getLogin(),student.getEmail(),academic);
            allStudents.add(thidrUG);
        }
        else
        {
            Postgraduate fourthPG = new Postgraduate(student.getName(),student.getLogin(),student.getEmail(),academic);
            allStudents.add(fourthPG);
        }
    }

    @Override
    public Iterator<Student> iterator()
    {
        return allStudents.iterator();
    }

    public String courseToString()
    {
        StringBuffer string = new StringBuffer();
        for(Student i:allStudents)
        {
            string.append(i.toString());
            string.append("\n");
        }
        return course + ":\n" + string.toString();
    }

    public Set<Postgraduate> getPostgraduate(String nameOfSupervisor)
    {
        Set<Postgraduate> studentsWithSupervisor = new HashSet<>();

        for (Student i : allStudents)
        {
            try
            {
                Postgraduate pg = (Postgraduate)i;
                if (Objects.equals(pg.getSupervisor().getName(), nameOfSupervisor))
                {
                    studentsWithSupervisor.add(pg);
                }
            }
            catch (ClassCastException e)
            {
            }

        }

        return studentsWithSupervisor;
    }

    public  Set<Student> findPredicateStudents(Predicate<Student> predicate)
    {
        Set<Student> predicateStudent = new HashSet<>();
        for (Student elem : allStudents)
        {
            if (predicate.test(elem))
            {
                predicateStudent.add(elem);
            }
        }
        return predicateStudent;
    }
}
