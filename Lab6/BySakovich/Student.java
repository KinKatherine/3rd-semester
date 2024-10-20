public class Student
{
    private int id;
    private String surname;
    private int course;
    private int group;

    public Student(int id, String surname, int course, int group)
    {
        this.id = id;
        this.surname = surname;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return  "course = " + course +
                ", group = " + group +
                ", surname = " + surname +
                ", id = " + id + "\n";
    }

}
