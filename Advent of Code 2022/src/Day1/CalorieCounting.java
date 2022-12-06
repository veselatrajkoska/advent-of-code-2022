package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCounting
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("Day1/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int elfCount = i;
        String line = "";

        while(scanner.hasNextLine())
        {
            while(scanner.hasNextLine() && !(line = scanner.nextLine()).equals(""))
            {
                sum += Integer.parseInt(line);
            }
            if (sum > maxSum)
            {
                maxSum = sum;
                elfCount = i;
            }
            i++;
            sum = 0;
        }

        System.out.printf("Max calories: %d on elf number %d", maxSum, elfCount);
    }
}
