package days.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day2Main {
    public static void main(String args[]) {
        calculateFrequency();
        countBoxes();
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

    private static void countBoxes() {
        try {
            FileReader fileReader = new FileReader("advent/src/days/day2/input.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            List<String> listOfWords = new ArrayList<>();
            while ((line = br.readLine()) != null) {
               listOfWords.add(line);
            }
            int common = 0;
            for (int i = 0; i < listOfWords.size(); i++) {
                List<String> listCopy = listOfWords;
                listCopy.remove(i);
                common += checkOthers(listOfWords.get(i), listCopy);
            }

            System.out.println(common);
            fileReader.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int checkOthers(String word, List<String> listOfWords) {
        int common = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < listOfWords.size(); i++) {
            final String s = listOfWords.get(i);
            String tmpWord = "";
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                char wordChar = word.charAt(j);
                if (wordChar == c) {
                    tmpWord += wordChar;
                }
            }
            int tmpLength = tmpWord.length();
            if(map.containsKey(tmpLength)) {
                Integer value = map.get(tmpLength);
                map.put(tmpLength, value+1);
            } else {
                map.put(tmpLength, 1);
            }
        }
        Integer finalInt = map.get(word.length()-1);
        if(finalInt != null) {
            common = map.get(word.length()-1);
        }
        return common;
    }



}
