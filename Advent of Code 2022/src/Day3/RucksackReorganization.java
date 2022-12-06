package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RucksackReorganization
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/Day3/input.txt");
        Scanner scanner = new Scanner(file);

        List<String> priorities = new LinkedList<>();
        priorities = Arrays.stream("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",")).toList();

        int sum = 0;

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            CharSequence compartment1 = line.subSequence(0, line.length()/2);
            String compartment2 = line.substring(line.length()/2);

            for(int i = 0; i < compartment1.length(); i++)
            {
                CharSequence current = compartment1.subSequence(i, i+1);
                if(compartment2.contains(current))
                {
                    sum += priorities.indexOf(current.toString()) + 1;
                    break;
                }
            }
        }

        scanner = new Scanner(file);
        int sum2 = 0;

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            CharSequence compartment1 = line.subSequence(0, line.length());
            String compartment2 = scanner.nextLine();
            String compartment3 = scanner.nextLine();

            for(int i = 0; i < compartment1.length(); i++)
            {
                CharSequence current = compartment1.subSequence(i, i+1);
                if(compartment2.contains(current) && compartment3.contains(current))
                {
                    sum2 += priorities.indexOf(current.toString()) + 1;
                    break;
                }
            }
        }

        System.out.println("Total priorities: " + sum);
        System.out.println("Sum2: " + sum2);
    }
}
