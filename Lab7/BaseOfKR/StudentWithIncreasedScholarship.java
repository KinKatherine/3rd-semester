public class StudentWithIncreasedScholarship extends Student
{
    private double scholarship;
    public StudentWithIncreasedScholarship(String surname, int course, double averageScore,double scholarship)
    {
        super(surname, course, averageScore);
        this.scholarship = scholarship;
    }

    public String toString() {
        return "StudentWithIncreasedScholarship: " + super.toString()+ ", scholarship = " + scholarship;
    }
}
