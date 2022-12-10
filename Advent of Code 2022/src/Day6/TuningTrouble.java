package Day6;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TuningTrouble
{
    public static boolean detectPacket(String input)
    {
        Set<Character> characters = new HashSet<>();
        for(int i = 0; i < 4; i++)
        {
            characters.add(input.charAt(i));
        }

        return characters.size() >= 4;
    }

    public static boolean detectMessage(String input)
    {
        Set<Character> characters = new HashSet<>();
        for(int i = 0; i < 14; i++)
        {
            characters.add(input.charAt(i));
        }

        return characters.size() >= 14;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/Day6/input.txt");
        Scanner scanner = new Scanner(file);

        String content = scanner.next();

        for(int i = 0; i < content.length(); i++)
        {
            boolean result = detectPacket(content.substring(i, i + 5));
            if(result)
            {
                System.out.printf("First start-of-packet at %d characters.\n", i + 4);
                break;
            }
        }

        scanner = new Scanner(file);
        content = scanner.next();

        for(int i = 0; i < content.length(); i++)
        {
            boolean result = detectMessage(content.substring(i, i + 15));
            if(result)
            {
                System.out.printf("First start-of-message after %d characters.", i + 14);
                break;
            }
        }
    }
}
