package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CalorieCounting
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/Day1/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        String line;
        List<Integer> sums = new LinkedList<>();

        while(scanner.hasNextLine())
        {
            while(scanner.hasNextLine() && !(line = scanner.nextLine()).equals(""))
            {
                sum += Integer.parseInt(line);
            }
            sums.add(sum);
            sum = 0;
        }

        sums = sums.stream()
                        .sorted(Comparator.reverseOrder())
                        .toList();

        System.out.printf("Max calories: %d\n", sums.get(0));
        System.out.printf("Top 3 max calories sum: %d", sums.get(0) + sums.get(1) + sums.get(2));
    }
}
