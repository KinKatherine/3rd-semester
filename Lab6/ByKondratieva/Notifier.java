import java.util.Set;

public class Notifier
{
    private Set<Student> notifiables;

    Notifier(Set<Student> notifiables)
    {
        this.notifiables = notifiables;
    }
    
    public void doNotifyAll(String message)
    {
        for (Student i:notifiables)
        {
            i.notify(message);
        }
    }

}
