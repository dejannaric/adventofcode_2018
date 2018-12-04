import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day1Main {

    public static void main(String args[]) {
        calculateFrequency();
        countDuplicates();
    }

    private static void calculateFrequency() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File input = new File("input.txt");
        try {
            FileReader fileReader = new FileReader("day1/src/input.txt");
            BufferedReader br = new BufferedReader(fileReader);

            Integer value = 0;
            String line;
            while ((line = br.readLine()) != null) {
                Integer cifra = Integer.valueOf(line);
                value += cifra;
            }
            System.out.println(value);
            fileReader.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countDuplicates() {
        File input = new File("input.txt");
        try {
            FileReader fileReader = new FileReader("day1/src/input.txt");
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            List<Integer> cifre = new ArrayList<Integer>();
            while ((line = br.readLine()) != null) {
                Integer cifra = Integer.valueOf(line);
                cifre.add(cifra);
            }

            List<Integer> seznamDuplicatov = new ArrayList<Integer>();
            boolean duplicate = false;
            Integer prviDuplikat = null;
            Integer duplicateNumber = 0;
            int i = 0;
            seznamDuplicatov.add(duplicateNumber);
            while(!duplicate) {
                if(i < cifre.size()) {
                    Integer cifra = cifre.get(i);
                    duplicateNumber += cifra;
                    //System.out.println(duplicateNumber +"   cifra=" + cifra);
                    duplicate = seznamDuplicatov.contains(duplicateNumber);
                    seznamDuplicatov.add(duplicateNumber);
                    i++;

                } else {
                    i = 0;
                }
            }
            System.out.println(duplicateNumber);
            //System.out.println(cifre);
            fileReader.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
