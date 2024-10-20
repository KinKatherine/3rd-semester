public class Student extends Person implements Notifiable
{
    private String login;
    private  String email;

    Student(String name,String login,String email)
    {
        super(name);
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + login + " " + email + " ";
    }

    public void notify(String message)
    {
        System.out.println(message + " is sent to email: "+ email);
    }
}
