public class ArrayOps
{
   /**
      This method accepts and integer array as a parameter, and then
      returns the "middle" value of the array.
      For an array of odd length, this would be the actual middle value.
      For an array of even length, there are TWO middle values, so only
      the first of the two values is returned.
      @param values, an array of integers
      @ return, the "middle" element of the array
   */
   public static int middleArray(int values[])
   {
      int count = 0;
      int index = 0;

      for(int i :values)
      {
         count++;
      }
      index = count/2;
      if(count%2!=0)
      {
         
      return values[index];
      }
      return values[index- 1 ];
   }
}
