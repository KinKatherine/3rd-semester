import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void printMatrix(int[][] matrix, int lines,int rows)
    {
        for (int i = 0; i < lines; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] array)
    {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int [] findNeighbors(int [][] matrix, int lines,int rows, int iEl,int jEl)
    {
        if(iEl==0 && jEl ==0)
        {
            int [] array ={matrix[iEl+1][jEl],matrix[iEl+1][jEl+1],matrix[iEl][jEl+1]};
            Arrays.sort(array);
            return array;
        }
        if(iEl==0 && jEl == rows-1)
        {
            int [] array ={matrix[iEl+1][jEl],matrix[iEl+1][jEl-1],matrix[iEl][jEl-1]};
            Arrays.sort(array);
            return array;
        }
        if(iEl == 0 && (jEl < rows-1 && jEl > 0))
        {
            int [] array ={matrix[iEl][jEl-1],matrix[iEl+1][jEl-1],matrix[iEl+1][jEl],matrix[iEl+1][jEl+1],matrix[iEl][jEl+1]};
            Arrays.sort(array);
            return array;
        }
        if ((iEl < lines-1 && iEl > 0) && jEl ==0)
        {
            int [] array ={matrix[iEl-1][jEl],matrix[iEl-1][jEl+1],matrix[iEl][jEl+1],matrix[iEl+1][jEl+1],matrix[iEl+1][jEl]};
            Arrays.sort(array);
            return array;
        }
        if((iEl < lines-1 && iEl > 0) && jEl == rows-1)
        {
            int [] array ={matrix[iEl-1][jEl],matrix[iEl-1][jEl-1],matrix[iEl][jEl-1],matrix[iEl+1][jEl-1],matrix[iEl+1][jEl]};
            Arrays.sort(array);
            return array;
        }
        if(iEl == lines-1 && jEl==0)
        {
            int [] array = {matrix[iEl-1][jEl], matrix[iEl-1][jEl+1],matrix[iEl][jEl+1]};
            Arrays.sort(array);
            return array;
        }
        if(iEl==lines-1 && jEl== rows-1)
        {
            int [] array = {matrix[iEl-1][jEl],matrix[iEl-1][jEl-1],matrix[iEl][jEl-1]};
            Arrays.sort(array);
            return array;
        }
        if(iEl==lines-1 && (jEl > 0 && jEl < rows - 1))
        {
            int[] array = {matrix[iEl][jEl-1],matrix[iEl-1][jEl-1],matrix[iEl-1][jEl],matrix[iEl-1][jEl+1],matrix[iEl][jEl+1]};
            Arrays.sort(array);
            return array;
        }
        int[] array = {matrix[iEl - 1][jEl], matrix[iEl + 1][jEl], matrix[iEl][jEl + 1], matrix[iEl][jEl - 1], matrix[iEl - 1][jEl - 1], matrix[iEl + 1][jEl + 1], matrix[iEl + 1][jEl - 1], matrix[iEl - 1][jEl + 1]};
        Arrays.sort(array);
        return array;
    }

    public static int [] findLocalMin(int [][] matrix, int lines,int rows)
    {
        int index = 0;
        int [] array = new int[lines*rows];
        for(int i = 0; i < lines;i++)
        {
            for(int j = 0; j < rows; j++)
            {
                if(matrix[i][j] < (findNeighbors(matrix,lines,rows,i,j)[0]))
                {
                    array[index] = matrix[i][j];
                    index ++;
                }
            }
        }
        int [] arrayLocalMin = new int[index];
        System.arraycopy(array, 0, arrayLocalMin, 0, index);
        return arrayLocalMin;
    }

    public static int [] findLocalMax(int [][] matrix, int lines,int rows)
    {
        int index = 0;
        int [] array = new int[lines*rows];
        for(int i = 0; i <lines;i++)
        {
            for(int j = 0; j <rows; j++)
            {
                if(matrix[i][j] > (findNeighbors(matrix,lines,rows,i,j)[(findNeighbors(matrix,lines,rows,i,j).length-1)]))
                {
                    array[index] = matrix[i][j];
                    index++;
                }
            }
        }
        int [] arrayLocalMax = new int[index];
        System.arraycopy(array, 0, arrayLocalMax, 0, index);
        return arrayLocalMax;
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidTypeArgumentExeption, LackElementsExeption {
        int lines;
        int rows;
        Scanner scannerFile = new Scanner(new File(args[0])); //  файл нашло :)
        try
        {
            String sizeStr = scannerFile.nextLine();
            Scanner scannerStr = new Scanner(sizeStr);
            try
            {
                lines = scannerStr.nextInt();

            } catch (Exception e)
            {
                throw new InvalidTypeArgumentExeption("Неверный тип данных");
            }
            if (scannerStr.hasNextInt()) {
                rows = scannerStr.nextInt();
            } else
            {
                rows = lines;
            }
            if (scannerStr.hasNextInt())
            {
                System.err.println("Много данных для размерности");
            }
        }
        catch (FileIsEmptyExeption e)
        {
            throw new FileIsEmptyExeption("Файл пуст");
        }
        int[][] matrix = new int[lines][rows];
        for (int i = 0; i < lines; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                if(scannerFile.hasNext())
                {
                    try
                    {
                        matrix[i][j] = scannerFile.nextInt();
                    }
                    catch (Exception e)
                    {
                        throw new InvalidTypeArgumentExeption("Неверный тип данных");
                    }
                }
                else
                {
                    throw new LackElementsExeption("Недостаночно данных");
                }
            }
        }

        if(scannerFile.hasNext())
        {
            System.err.println("Присутствуют лишние элементы");
        }

        printMatrix(matrix, lines,rows);
        System.out.println("Локальные минимумы матрицы:");
        printArray(findLocalMin(matrix, lines,rows));
        System.out.println("Локальные максимумы матрицы:");
        printArray(findLocalMax(matrix, lines,rows));
    }
}