import java.util.StringTokenizer;
public class MainNum2
{
    public static boolean isLatinLetter(char c)
    {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args)
    {
        int wordCount = 0;
        StringTokenizer string = new StringTokenizer("One two three раз два три one1 two2 123 asd");
        while (string.hasMoreTokens())
        {
            String token = string.nextToken();
            boolean isValid = true;

            for (int i = 0; i < token.length(); i++)
            {
                if (!isLatinLetter(token.charAt(i)))
                {
                    isValid = false;
                }
            }

            if (isValid)
            {
                wordCount++;
            }
        }
        System.out.print(wordCount);
    }
}
