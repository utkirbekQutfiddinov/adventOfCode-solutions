package uz.utkirbek.aoc.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 01.12.2025
 */
public class Day2 {
    public static void main(String[] args) throws IOException {
//        problem1();
        problem2();
    }

    public static void problem1() throws IOException {
        String text = Files.readString(Path.of("text.txt"));
//        List<String> rows = Files.readAllLines(Path.of("text1.txt"));
//11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862
        long sum = 0;

        String[] ranges = text.split(",");
        long start = 0, end = 0;
        for (String range : ranges) {
            start = Long.parseLong(range.split("-")[0]);
            end = Long.parseLong(range.split("-")[1]);

            for (long i = start; i <= end; i++) {
                if (isInValid1(i)) {
                    sum += i;
                }
            }
        }

        System.out.println(sum);

    }

    public static void problem2() throws IOException {
//        String text="998-1012";
        String text=Files.readString(Path.of("text.txt"));
//        List<String> rows = Files.readAllLines(Path.of("text.txt"));

        long sum = 0;

        String[] ranges = text.split(",");
        long start = 0, end = 0;
        for (String range : ranges) {
            start = Long.parseLong(range.split("-")[0]);
            end = Long.parseLong(range.split("-")[1]);

            for (long i = start; i <= end; i++) {
                if (isInValid2(i)) {
//                    System.out.println(i);
                    sum += i;
                }
            }
        }

        System.out.println(sum);

    }

    private static boolean isInValid2(long number) {
        String id = String.valueOf(number);

        StringBuilder sb=new StringBuilder("");

        int len=1;
        String pattern=null;

        while(len<id.length()){
            pattern=id.substring(0,len);
            sb=new StringBuilder("");

            while(sb.length()+len<=id.length()){
                sb.append(pattern);
            }

            if (sb.toString().equals(id)){
                return true;
            }
            len++;
        }


        return false;

    }

    private static boolean isInValid1(long number) {
        String id = String.valueOf(number);

        if (id.length() % 2 == 1) {
            return false;
        }

        String pattern = id.substring(0, id.length() / 2);

        return id.endsWith(pattern);

    }
}
