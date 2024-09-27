// TODO: Determine whether a or b do not represent an integer
// by catching the NumberFormatException. If either one is not an integer,
// use the value 0 when computing the sum.

public class Numbers
{
   public int add(String a, String b)
   {
      boolean flag1 = false;
      boolean flag2 = false;
      int x = 0;
      int y = 0;
      try
      {
         x = Integer.parseInt(a);
      }
      catch(NumberFormatException e)
      {
         flag1 = true;
      }
      try
      {
         y = Integer.parseInt(b);
      }
      catch(NumberFormatException e)
      {
         flag2 = true;
      }
      return x + y;
   }
}
