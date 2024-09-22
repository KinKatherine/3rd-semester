public class ArrayOps
{
   
   public static int findValue(int values[], int valueToFind)
   {
      int res = 0;
      int count = 0;
      boolean b = false;

      for(int i:values)
      {
         count++;
      }
      
      for(int i = 0; i < count; i++)
      {
         if(values[i]==valueToFind)
         {
            res = i;
            b = true;
         }
      }
      if(b==false)
      {
         res = count;
      }
      return res;

   }
}
