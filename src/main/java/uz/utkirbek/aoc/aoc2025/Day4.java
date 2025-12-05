package uz.utkirbek.aoc.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        problem1();
//        problem2();
    }

    public static void problem1() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));

        List<StringBuilder> rows1 = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            rows1.add(new StringBuilder(rows.get(i)));
        }

        long res = 0;

        int[][] grid = new int[rows.size()][];

        while (true) {
            for (int i = 0; i < rows.size(); i++) {
                grid[i] = new int[rows.get(i).length()];
            }
            for (int i = 0; i < rows1.size(); i++) {
                StringBuilder row = rows1.get(i);
                for (int j = 0; j < row.length(); j++) {

                    if (row.charAt(j) == '.') {
                        grid[i][j] = 100;
                        continue;
                    }

                    if (j > 0) {
                        grid[i][j - 1]++;
                    }

                    if (i > 0) {
                        grid[i - 1][j]++;
                    }

                    if (j < row.length() - 1) {
                        grid[i][j + 1]++;
                    }

                    if (i < row.length() - 1) {
                        grid[i + 1][j]++;
                    }

                    if (i > 0 && j > 0) {
                        grid[i - 1][j - 1]++;
                    }

                    if (i > 0 && j < row.length() - 1) {
                        grid[i - 1][j + 1]++;
                    }

                    if (i < row.length() - 1 && j < row.length() - 1) {
                        grid[i + 1][j + 1]++;
                    }

                    if (i < rows.size() - 1 && j > 0) {
                        grid[i + 1][j - 1]++;
                    }

                }
            }

            long currRes = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] < 4) {
                        currRes++;
                        StringBuilder row = rows1.get(i);
                        row.setCharAt(j, '.');
                    }
                }
            }

            if (currRes==0){
                break;
            }else {
                res+=currRes;
            }
        }
        System.out.println(res);

    }

    public static void problem2() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));


    }
}
