import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PartOne {

    public static void main(String[] args) {
        try {
            File input = new File("E:\\Code\\advent_of_code_2022\\day_4\\input\\input");
            Scanner theScanner = new Scanner(input);

            int count = 0;

            while (theScanner.hasNextLine()) {
                String line = theScanner.nextLine();
                String[] pairs = line.split(",");
                assert pairs.length == 2;

                List<Integer> firstRange = Arrays.stream(pairs[0].split("-"))
                        .map(Integer::parseInt)
                        .toList();
                assert firstRange.size() == 2;

                List<Integer> secondRange = Arrays.stream(pairs[1].split("-"))
                        .map(Integer::parseInt)
                        .toList();
                assert secondRange.size() == 2;

                if (firstRange.get(0) <= secondRange.get(0) && firstRange.get(1) >= secondRange.get(1) ||
                    secondRange.get(0) <= firstRange.get(0) && secondRange.get(1) >= firstRange.get(1) ) {
                    count++;
                }
            }

            System.out.println(count);

        } catch (
                FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }
}
