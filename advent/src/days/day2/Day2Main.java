package days.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day2Main {
    public static void main(String args[]) {
        calculateFrequency();
    }

    private static void calculateFrequency() {
        try {
            FileReader fileReader = new FileReader("advent/src/days/day2/input.txt");
            BufferedReader br = new BufferedReader(fileReader);

            Integer twoLetterCounter = 0;
            Integer threeLetterCounter = 0;
            String line;
            Map<Character, Integer> mapChars;
            while ((line = br.readLine()) != null) {
                mapChars = new HashMap<>();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if(mapChars.containsKey(c)) {
                        Integer count = mapChars.get(c);
                        mapChars.put(c, count + 1);
                    } else {
                        mapChars.put(c, 1);
                    }
                }
                boolean twoCounted = false;
                boolean threCounted = false;
                for(Integer number : mapChars.values()) {
                    if(number == 2 && !twoCounted) {
                        twoLetterCounter++;
                        twoCounted = true;
                    } else if(number == 3 && !threCounted) {
                        threeLetterCounter++;
                        threCounted = true;
                    }
                }
            }
            System.out.println(twoLetterCounter * threeLetterCounter);
            fileReader.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
