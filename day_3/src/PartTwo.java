import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class PartTwo {

    public static void main(String[] args) {
        try {
            File input = new File("E:\\Code\\advent_of_code_2022\\day_3\\input\\input");
            Scanner theScanner = new Scanner(input);

            int sum = 0;
            int idx = 0;
            HashSet<Character> commonItems = new HashSet<>();

            while (theScanner.hasNextLine()) {
                String line = theScanner.nextLine();
                if (line.isBlank()) {
                    continue;
                }

                assert line.length() % 2 == 0;

                HashSet<Character> itemsInCurrentBackpack = new HashSet<>();
                for (char character : line.toCharArray()) {
                    itemsInCurrentBackpack.add(character);
                }

                switch (idx % 3) {
                    case 0 -> commonItems = (HashSet<Character>) itemsInCurrentBackpack.clone();
                    case 1 -> commonItems.retainAll(itemsInCurrentBackpack);
                    case 2 -> {
                        commonItems.retainAll(itemsInCurrentBackpack);
                        assert commonItems.size() == 1;
                        for (Character duplicate : commonItems) {
                            System.out.println(duplicate);
                            sum += Alphabet.getNum(duplicate);
                        }
                    }
                }

                itemsInCurrentBackpack.clear();
                idx++;
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
