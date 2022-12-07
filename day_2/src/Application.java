import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try {
            File input = new File("E:\\Code\\advent_of_code_2022\\day_2\\input\\input");
            Scanner theScanner = new Scanner(input);
            HashMap<String, Integer> values = new HashMap<>();

            values.put("A", 1);
            values.put("B", 2);
            values.put("C", 3);
            values.put("X", 1);
            values.put("Y", 2);
            values.put("Z", 3);

            HashMap<Integer, Integer> defeats = new HashMap<>();
            defeats.put(1, 3);
            defeats.put(2, 1);
            defeats.put(3, 2);

            HashMap<Integer, Integer> loses = new HashMap<>();
            loses.put(3, 1);
            loses.put(1, 2);
            loses.put(2, 3);

            int score = 0;

            while (theScanner.hasNextLine()) {
                String line = theScanner.nextLine();
                if (line.isBlank()) {
                    continue;
                }

                String[] moves = line.split(" ");
                Integer hisMove = values.get(moves[0]);
                Integer myMove = values.get(moves[1]);
                Integer myMoveDefeats = defeats.get(myMove);

                if (myMove == 2) { //draw
                    score += hisMove + 3;
                } else if (myMove == 3) { //win
                    score += loses.get(hisMove) + 6;
                } else { //lose
                    score += defeats.get(hisMove);
                }

            }
            theScanner.close();

            System.out.println(score);

        } catch (
                FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }
}
