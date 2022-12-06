package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RockPaperScissors
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/Day2/input.txt");
        Scanner scanner = new Scanner(file);
        String line = "";
        int score = 0;
        HashMap<String, Integer> points = new HashMap<>();

        points.put("A X", 3);
        points.put("A Y", 4);
        points.put("A Z", 8);
        points.put("B X", 1);
        points.put("B Y", 5);
        points.put("B Z", 9);
        points.put("C X", 2);
        points.put("C Y", 6);
        points.put("C Z", 7);

        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            score += points.get(line);
        }

        System.out.println("Part 2 total score: " + score);
    }
}
