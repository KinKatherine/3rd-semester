public class ArrayOps
{
   public static int bigSum(int[][] theArray)
   {
      int sum1 = 0;
      int sum2 = 0;
      for(int i = 0; i < theArray[0].length; i++)
      {
         sum1 += theArray[0][i];
      }
      
      for(int i = 0; i < theArray[1].length; i++)
      {
         sum2 += theArray[1][i];
      }
      return Math.max(sum1,sum2);

   }
}
