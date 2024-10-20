import java.util.Comparator;
import java.util.Objects;

public class MixedComparator implements Comparator<Student>
{
    @Override
    public int compare(Student st1, Student st2) {
        if(st1.getCourse()== st2.getCourse())
        {
            if(st1.getGroup()== st2.getGroup())
            {
                return st1.getSurname().compareTo(st2.getSurname());
            }
            else
            {
                return Integer.compare(st1.getGroup(), st2.getGroup());
            }
        }
        return Integer.compare(st1.getCourse(), st2.getCourse());
    }
}
