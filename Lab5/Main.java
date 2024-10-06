import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        Liner liner = new Liner(2,3);
        System.out.println("Liner:");
        System.out.println(liner.calculateElement(2));
        System.out.println(liner.calculateSum(2));
        System.out.println(liner.convertToString(3));

        liner.saveToFile("5 elements of Liner:");
        liner.saveToFile(liner.convertToString(5));
        liner.saveToFile("Sum of elements of Liner:");
        liner.saveToFile(Double.toString(liner.calculateSum(5)));


        Exponential exponential = new Exponential(2,4);
        System.out.println("Exponential:");
        System.out.println(exponential.calculateElement(2));
        System.out.println(exponential.calculateSum(2));
        System.out.println(exponential.convertToString(3));

        exponential.saveToFile("5 elements of Exponential:");
        exponential.saveToFile(exponential.convertToString(5));
        exponential.saveToFile("Sum of elements of Liner:");
        exponential.saveToFile(Double.toString(exponential.calculateSum(5)));
    }
}