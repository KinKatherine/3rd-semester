import java.util.StringTokenizer;
// вариант 4

public class MyStringBreaker
{
    public static int FindMinIndex(String token)
    {
        int minIndex = token.length()-1;
        for (int i = 0; i < token.length(); i++)
        {
            if (token.charAt(i) - 48 > 0)
            {
                minIndex = token.indexOf(token.charAt(i));
                break;
            }
        }
        return minIndex;
    }

    public static void main(String[] args)
    {
        System.out.println();
        StringTokenizer string = new StringTokenizer(args[0]);
        while (string.hasMoreTokens())
        {
            String token = string.nextToken();
            try
            {
               double d =  Double.parseDouble(token);

                if(token.indexOf('.')==-1) // ситуация где в токене нет точки
                {
                    token = token.substring(FindMinIndex(token));
                }
                else
                {
                    if(token.length()==2)
                    {
                        token = "0.0";
                    }
                    int pointIndex = token.indexOf('.');
                    int minNumIndex = FindMinIndex(token);
                    if (minNumIndex - pointIndex > 0)
                    {
                        token = token.substring(pointIndex - 1 );
                    }
                    else
                    {
                        token = token.substring(minNumIndex);
                    }
                }
            }
            catch(NumberFormatException exc){}
            System.out.print(token + " ");
        }
    }
}