public  abstract class Student implements Comparable<Student>
{
    private String surname;
    private int course;
    private double averageScore;

    public Student(String surname, int course, double averageScore)
    {
        this.surname = surname;
        this.course = course;
        this.averageScore = averageScore;
    }

    public String toString() {
        return " surname = " + surname + ", course = " + course + ", averageScore = " + averageScore;
    }

    public int compareTo(Student o)
    {
        return 0;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageScore() {
        return averageScore;
    }
}
