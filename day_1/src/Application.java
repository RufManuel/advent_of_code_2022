import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            File input = new File("E:\\Code\\advent_of_code_2022\\day_1\\input\\input");
            Scanner theScanner = new Scanner(input);

            ArrayList<Integer> totals = new ArrayList();
            int current = 0;

            while (theScanner.hasNextLine()) {
                String line = theScanner.nextLine();
                if (line.isBlank()) {
                    totals.add(current);
                    current = 0;
                } else {
                    current += Integer.parseInt(line);
                }
            }
            theScanner.close();

            totals.sort(Comparator.naturalOrder());
            ArrayList<Integer> topThree = new ArrayList<>(totals.subList(totals.size() - 3, totals.size()));
            Optional<Integer> total = topThree.stream().reduce((i,j) -> i + j);
            System.out.println(total);

        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }
}
