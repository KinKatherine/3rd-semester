public class Postgraduate extends Student
{
    private Academic supervisor;

    Postgraduate(String name, String login, String email, Academic supervisor)
    {
        super(name, login, email);
        this.supervisor = supervisor;
    }

    public Academic getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor)
    {
        this.supervisor = supervisor;
    }

    @Override
    public String toString()
    {
        return super.toString() + supervisor.toString();
    }
}
