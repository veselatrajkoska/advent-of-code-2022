package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SupplyStacks
{
    public static List<Stack<String>> stacksCreation()
    {
        List<Stack<String>> stacks = new LinkedList<>();

        Stack<String> stack1 = new Stack<>();
        stack1.push("Q");
        stack1.push("W");
        stack1.push("P");
        stack1.push("S");
        stack1.push("Z");
        stack1.push("R");
        stack1.push("H");
        stack1.push("D");

        Stack<String> stack2 = new Stack<>();
        stack2.push("V");
        stack2.push("B");
        stack2.push("R");
        stack2.push("W");
        stack2.push("Q");
        stack2.push("H");
        stack2.push("F");

        Stack<String> stack3 = new Stack<>();
        stack3.push("C");
        stack3.push("V");
        stack3.push("S");
        stack3.push("H");

        Stack<String> stack4 = new Stack<>();
        stack4.push("H");
        stack4.push("F");
        stack4.push("G");

        Stack<String> stack5 = new Stack<>();
        stack5.push("P");
        stack5.push("G");
        stack5.push("J");
        stack5.push("B");
        stack5.push("Z");

        Stack<String> stack6 = new Stack<>();
        stack6.push("Q");
        stack6.push("T");
        stack6.push("J");
        stack6.push("H");
        stack6.push("W");
        stack6.push("F");
        stack6.push("L");

        Stack<String> stack7 = new Stack<>();
        stack7.push("Z");
        stack7.push("T");
        stack7.push("W");
        stack7.push("D");
        stack7.push("L");
        stack7.push("V");
        stack7.push("J");
        stack7.push("N");

        Stack<String> stack8 = new Stack<>();
        stack8.push("D");
        stack8.push("T");
        stack8.push("Z");
        stack8.push("C");
        stack8.push("J");
        stack8.push("G");
        stack8.push("H");
        stack8.push("F");

        Stack<String> stack9 = new Stack<>();
        stack9.push("W");
        stack9.push("P");
        stack9.push("V");
        stack9.push("M");
        stack9.push("B");
        stack9.push("H");

        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);

        return stacks;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/Day5/input.txt");
        Scanner scanner = new Scanner(file);

        List<Stack<String>> stacks = stacksCreation();

        for(int i = 0; i < 10; i++)
            scanner.nextLine();

        while(scanner.hasNextLine())
        {
            String[] lineParts = scanner.nextLine().split("\\s");
            int n = Integer.parseInt(lineParts[1]);
            int from = Integer.parseInt(lineParts[3]);
            int to = Integer.parseInt(lineParts[5]);

            for(int i = 0; i < n; i++)
            {
                String element = stacks.get(from - 1).pop();
                stacks.get(to - 1).push(element);
            }
        }

        StringBuilder result1 = new StringBuilder();
        for(Stack<String> stack : stacks)
        {
            result1.append(stack.peek());
        }

        stacks = stacksCreation();
        scanner = new Scanner(file);
        for(int i = 0; i < 10; i++)
            scanner.nextLine();

        while(scanner.hasNextLine())
        {
            String[] lineParts = scanner.nextLine().split("\\s");
            int n = Integer.parseInt(lineParts[1]);
            int from = Integer.parseInt(lineParts[3]);
            int to = Integer.parseInt(lineParts[5]);
            LinkedList<String> toBeMoved = new LinkedList<>();

            for(int i = 0; i < n; i++)
            {
                if(!stacks.get(from - 1).empty())
                {
                    String element = stacks.get(from - 1).pop();
                    toBeMoved.addFirst(element);
                }
            }

            for(String element : toBeMoved)
            {
                stacks.get(to - 1).push(element);
            }
        }

        StringBuilder result2 = new StringBuilder();
        for(Stack<String> stack : stacks)
        {
            result2.append(stack.peek());
        }

        System.out.println("Result part 1: " + result1);
        System.out.println("Result part 2: " + result2);
    }
}











