public class ExpelledStudent extends Student
{
    private int orderNumber;


    public ExpelledStudent(String surname, int course, double averageScore, int orderNumber) {
        super(surname, course, averageScore);
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "ExpelledStudent: " + super.toString()+ ", orderNumber = " + orderNumber;
    }

}
