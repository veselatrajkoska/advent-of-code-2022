package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CampCleanup
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/Day4/input.txt");
        Scanner scanner = new Scanner(file);
        int fullOverlap = 0;
        int anyOverlap = 0;

        while(scanner.hasNextLine())
        {
            String[] split = scanner.nextLine().split(",");
            String[] range1 = split[0].split("-");
            String[] range2 = split[1].split("-");

            int[] numbers = new int[4];
            numbers[0] = Integer.parseInt(range1[0]);
            numbers[1] = Integer.parseInt(range1[1]);
            numbers[2] = Integer.parseInt(range2[0]);
            numbers[3] = Integer.parseInt(range2[1]);

            if((numbers[0] <= numbers[2] && numbers[1] >= numbers[3])
                    || (numbers[2] <= numbers[0] && numbers[3] >= numbers[1]))
                fullOverlap++;

            if((numbers[2] >= numbers[0] && numbers[2] <= numbers[1])
                    || (numbers[0] >= numbers[2] && numbers[0] <= numbers[3]))
                anyOverlap++;
        }

        System.out.println("Total: " + fullOverlap);
        System.out.println("Any: " + anyOverlap);
    }
}
