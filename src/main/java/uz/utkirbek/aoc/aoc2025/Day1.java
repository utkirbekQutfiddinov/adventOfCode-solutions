package uz.utkirbek.aoc.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 01.12.2025
 */
public class Day1 {
    public static void main(String[] args) throws IOException {
//        problem1();
        problem2();
    }

    public static void problem1() throws IOException {
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));
        int count = 0;

        int dial = 50;
        int turn = 0;

        for (String row : rows) {
            turn = Integer.parseInt(row.substring(1));
            if (row.startsWith("L")) {
                dial = dial - turn;
            } else {
                dial = dial + turn;
            }

            if (dial < 0) {
                dial = dial + 100;
            }

            if (dial > 100) {
                dial = dial - 100;
            }

            if (dial % 100 == 0) {
                count++;
                dial = 0;
            }
        }

        System.out.println(count);
    }

    public static void problem2() throws IOException {
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));
        int count = 0;

        int dial = 50;
        int turn = 0;

        for (String row : rows) {

            turn = Integer.parseInt(row.substring(1));

            count += turn / 100;
            turn = turn % 100;


            if (row.startsWith("L")) {
                if (dial == 0) {
                    dial = 100 - turn;
                } else if (turn > dial) {
                    count++;
                    dial = (100 + dial - turn) % 100;
                } else {
                    dial -= turn;
                }
            } else {
                if(dial==0){
                    dial = turn;
                }else if((turn+dial)>100){
                    count++;
                    dial=(turn+dial)%100;
                }else {
                    dial+=turn;
                }
            }

            if(dial%100==0){
                count++;
                dial=0;
            }
        }
        System.out.println(count);
    }
}
