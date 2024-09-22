public class Grades
{
   public static double[] makeAverage(double[] test1, double[] test2)
   {
      double[] medium = new double[test1.length];
      for(int i = 0; i < test1.length; i++)
      {
         medium[i] = (test1[i]+test2[i])/2;
      }
      return medium;
   }
}
