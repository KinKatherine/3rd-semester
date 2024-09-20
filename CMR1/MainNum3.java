 //Строка состоит из слов, разделенных пробелом, запятой или точкой. Удалить из строки все слова,
 //которые являются целыми числами (состоят только из цифр).
 public class MainNum3
 {
     public static void main(String[] args)
     {
         String str = "123 I, love. Java1 123 ";
         String strFinish = "";
         StringBuilder result = new StringBuilder();
         String[] words = str.split("[\\s,. ]");// как разделитель пробел, точка и запятая
         for (int i = 0; i < words.length; i++)
         {
             try
             {
                 int d = Integer.parseInt(words[i]);
                 strFinish = strFinish +" " +words[i];
                 str = str.replace (words[i], "");
             }
             catch (Exception e)
             {

             }
         }

         System.out.println(str);
     }
 }


