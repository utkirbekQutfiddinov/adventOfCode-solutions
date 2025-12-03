package uz.utkirbek.aoc.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException {
//        problem1();
        problem2();
    }

    public static void problem1() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text1.txt"));

        long sum = 0;
        int mxInd = 0;
        int mnInd = 1;


        for (String row : rows) {

            mxInd = getMaxIndex(row, 0, row.length() - 2);
            mnInd = getMaxIndex(row, mxInd + 1, row.length() - 1);

            sum += ((row.charAt(mxInd) - 48) * 10 + row.charAt(mnInd) - 48);

        }


        System.out.println(sum);
    }


    private static int getMaxIndex(String line, int from, int to) {
        int max = from;

        for (int i = from; i <= to; i++) {
            if (line.charAt(i) > line.charAt(max)) {
                max = i;
            }
        }
        return max;
    }

    public static void problem2() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));

        long sum = 0;
        int[] indices = new int[12];

        int pow = 1, from, to;
        for (String row : rows) {

            from = 0;
            to = row.length() - indices.length;
            for (int i = 0; i < indices.length; i++) {
                indices[i] = getMaxIndex(row, from, to);

                from = indices[i] + 1;
                to++;
            }

            pow = 0;
            for (int i = indices.length - 1; i >= 0; i--) {
                sum += (row.charAt(indices[i]) - 48) * Math.pow(10, pow);
                pow++;
            }

        }


        System.out.println(sum);

    }
}
