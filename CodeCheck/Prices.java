import java.util.Scanner;
public class Prices
{
   /**
      A method to determine and return the average price
   */
   public static double averagePrice(double[] priceData)
   {
      double res = 0;
      int count = 0;
      for(double i:priceData)
      {
         res+=i;
         count++;
      }
      return res/count;
   }
}
