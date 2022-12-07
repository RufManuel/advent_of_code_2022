import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class PartOne {

    public static void main(String[] args) {
        try {
            File input = new File("E:\\Code\\advent_of_code_2022\\day_3\\input\\input");
            Scanner theScanner = new Scanner(input);

            int sum = 0;

            while (theScanner.hasNextLine()) {
                HashSet<Character> firstCompartment = new HashSet<>();
                HashSet<Character> secondCompartment = new HashSet<>();
                firstCompartment.clear();
                secondCompartment.clear();

                String line = theScanner.nextLine();
                if (line.isBlank()) {
                    continue;
                }

                assert line.length() % 2 == 0;
                int index = 0;

                for (Character item : line.toCharArray()) {
                    if (index < line.length() / 2) {
                        firstCompartment.add(item);
                    } else {
                        secondCompartment.add(item);
                    }
                    index++;
                }
                firstCompartment.retainAll(secondCompartment);
                assert firstCompartment.size() == 1;

                for (Character duplicate: firstCompartment) {
                    System.out.println(duplicate);
                    sum += Alphabet.getNum(duplicate);
                }
            }
            theScanner.close();

            System.out.println(sum);
        } catch (
                FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }

    public enum Alphabet {
        a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,
        A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;

        public static int getNum(String arg) {
            return valueOf(arg).ordinal() + 1;
        }

        public static int getNum(char arg) {
            return valueOf(String.valueOf(arg)).ordinal() + 1;
        }
    }
}
